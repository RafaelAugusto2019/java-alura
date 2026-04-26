package com.estudos.alura.api.service;

import com.estudos.alura.api.repository.appointment.AppointmentJPA;
import com.estudos.alura.api.repository.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class DoctorScheduleRuleService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public boolean validateDoctorSchedule(Long doctorId, String time) {
        LocalTime appointmentStartHour = LocalTime.parse(time);
        LocalTime appointmentEndHour = LocalTime.parse(time).plusHours(1);

        List<AppointmentJPA> appointments = appointmentRepository.findAllByDoctorId(doctorId);

        for (AppointmentJPA appointment : appointments) {
            LocalTime hourStart = LocalTime.parse(appointment.getTime());
            LocalTime hourEnd = hourStart.plusHours(1);

            if(appointmentStartHour.equals(hourStart) ||
                appointmentStartHour.isAfter(hourStart) && appointmentStartHour.isBefore(hourEnd)){
                return  false;
            }

            if(appointmentEndHour.isAfter(hourStart) && appointmentEndHour.isBefore(hourEnd)){
                return  false;
            }

        }

        return true;
    }

}
