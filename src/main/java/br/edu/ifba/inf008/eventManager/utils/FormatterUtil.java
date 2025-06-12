package br.edu.ifba.inf008.eventManager.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class FormatterUtil {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String formatDate(LocalDate date) {
        if (date == null) {
            return "N/A";
        }
        return date.format(DATE_FORMATTER);
    }

    public static LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format for '" + dateStr + "'. Use DD-MM-YYYY.");
            return null;
        }
    }

    public static String formatParticipantName(Participant participant) {
        if (participant == null) {
            return "N/A";
        }
        return participant.getName() + " (" + participant.getEmail() + ")";
    }
}