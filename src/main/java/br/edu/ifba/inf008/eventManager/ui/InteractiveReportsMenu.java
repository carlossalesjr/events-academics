package br.edu.ifba.inf008.eventManager.ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import br.edu.ifba.inf008.eventManager.services.management.EventManager;

public class InteractiveReportsMenu {

    public static void displayMenu(Scanner scanner, EventManager eventManager) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Reports Menu ---");
            System.out.println("1. Generate Chart (PNG): Event Count by Type");
            System.out.println("2. Generate Chart (PDF): Event Count by Type");
            System.out.println("3. Generate Chart (PNG): Participant Count by Event");
            System.out.println("4. Generate Chart (PDF): Participant Count by Event");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    generateChartEventsByTypePNG(scanner, eventManager);
                    break;
                case 2:
                    generateChartEventsByTypePDF(scanner, eventManager);
                    break;
                case 3:
                    generateChartParticipantsByEventPNG(scanner, eventManager);
                    break;
                case 4:
                    generateChartParticipantsByEventPDF(scanner, eventManager);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void generateChartEventsByTypePNG(Scanner scanner, EventManager eventManager) {
        System.out.print("Enter output PNG file name for 'Events by Type' chart (e.g., events_by_type.png) [default: events_by_type.png]: ");
        String outputFileName = scanner.nextLine();
        if (outputFileName.isEmpty()) {
            outputFileName = "events_by_type.png";
        }
        JFreeChart chart = createEventCountByTypeChart(eventManager);
        if (chart == null) return;
        saveChartAsPNG(chart, outputFileName, 600, 400);
    }

    private static void generateChartParticipantsByEventPNG(Scanner scanner, EventManager eventManager) {
        System.out.print("Enter output PNG file name for 'Participants by Event' chart (e.g., participants_by_event.png) [default: participants_by_event.png]: ");
        String outputFileName = scanner.nextLine();
        if (outputFileName.isEmpty()) {
            outputFileName = "participants_by_event.png";
        }
        JFreeChart chart = createParticipantCountByEventChart(eventManager);
        if (chart == null) return;
        saveChartAsPNG(chart, outputFileName, 800, 600);
    }

    private static void generateChartEventsByTypePDF(Scanner scanner, EventManager eventManager) {
        System.out.print("Enter output PDF file name for 'Events by Type' chart (e.g., events_by_type.pdf) [default: events_by_type.pdf]: ");
        String outputFileName = scanner.nextLine();
        if (outputFileName.isEmpty()) {
            outputFileName = "events_by_type.pdf";
        }
        JFreeChart chart = createEventCountByTypeChart(eventManager);
        if (chart == null) return;
        saveChartAsPDF(chart, outputFileName, 600, 400);
    }

    private static void generateChartParticipantsByEventPDF(Scanner scanner, EventManager eventManager) {
        System.out.print("Enter output PDF file name for 'Participants by Event' chart (e.g., participants_by_event.pdf) [default: participants_by_event.pdf]: ");
        String outputFileName = scanner.nextLine();
        if (outputFileName.isEmpty()) {
            outputFileName = "participants_by_event.pdf";
        }
        JFreeChart chart = createParticipantCountByEventChart(eventManager);
        if (chart == null) return;
        saveChartAsPDF(chart, outputFileName, 800, 600);
    }

    private static JFreeChart createEventCountByTypeChart(EventManager eventManager) {
        Map<String, Integer> data = eventManager.getEventCountByType();
        if (data.isEmpty()) {
            System.out.println("No event data to generate the chart.");
            return null;
        }
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            dataset.setValue(entry.getKey() + " (" + entry.getValue() + ")", entry.getValue());
        }
        return ChartFactory.createPieChart(
                "Event Count by Type",
                dataset,
                true, true, false);
    }

    private static JFreeChart createParticipantCountByEventChart(EventManager eventManager) {
        Map<String, Integer> data = eventManager.getParticipantCountByEvent();
        if (data.isEmpty()) {
            System.out.println("No participant data in events to generate the chart.");
            return null;
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            dataset.addValue(entry.getValue(), "Participants", entry.getKey());
        }
        return ChartFactory.createBarChart(
                "Participant Count by Event",
                "Event",
                "Number of Participants",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
    }

    // --- Métodos auxiliares para salvar gráficos ---

    private static void saveChartAsPNG(JFreeChart chart, String fileName, int width, int height) {
        try {
            ChartUtils.saveChartAsPNG(new File(fileName), chart, width, height);
            System.out.println("Chart (PNG) saved to: " + new File(fileName).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving PNG chart: " + e.getMessage());
        }
    }

    private static void saveChartAsPDF(JFreeChart chart, String fileName, int imageWidth, int imageHeight) {
        BufferedImage bufferedImage = chart.createBufferedImage(imageWidth, imageHeight); 

        try (PDDocument document = new PDDocument()) { 
            PDPage page = new PDPage(PDRectangle.A4); 
            document.addPage(page);

            PDImageXObject pdImage = LosslessFactory.createFromImage(document, bufferedImage); 

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                float pageWidth = page.getMediaBox().getWidth();
                float pageHeight = page.getMediaBox().getHeight();
                float imageAspectRatio = (float) imageWidth / imageHeight;
                
                float drawWidth = pageWidth * 0.8f; 
                float drawHeight = drawWidth / imageAspectRatio;

                if (drawHeight > pageHeight * 0.8f) {
                    drawHeight = pageHeight * 0.8f;
                    drawWidth = drawHeight * imageAspectRatio;
                }

                float x = (pageWidth - drawWidth) / 2;
                float y = pageHeight - drawHeight - (pageHeight * 0.1f); 

                contentStream.drawImage(pdImage, x, y, drawWidth, drawHeight); 
            }
            document.save(fileName); 
            System.out.println("Chart (PDF) saved to: " + new File(fileName).getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error saving PDF chart: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
