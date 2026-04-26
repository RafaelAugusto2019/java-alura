package com.estudos.alura.api.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class OperatingRuleService {

    private static final LocalTime OPENING_TIME = LocalTime.of(7, 0);
    private static final LocalTime CLOSING_TIME = LocalTime.of(19, 0);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public boolean validateDateTime(String date, String time){

        var localTime = LocalTime.parse(time);
        var localDate = LocalDate.parse(date, DATE_FORMATTER);

        boolean isBusinessHour = localTime.isAfter(OPENING_TIME) && localTime.isBefore(CLOSING_TIME);

        boolean isNotMonday = localDate.getDayOfWeek() != DayOfWeek.SUNDAY;

        return isBusinessHour && isNotMonday;
    }
}
