package br.edu.ifba.inf008.eventManager.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class FormatterUtil {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatDate(LocalDate date) {
        if (date == null) return "N/A";
        return date.format(DATE_FORMATTER);
    }

    public static String formatParticipantName(Participant p) {
        if (p == null) return "N/A";
        return p.getName();
    }
}
