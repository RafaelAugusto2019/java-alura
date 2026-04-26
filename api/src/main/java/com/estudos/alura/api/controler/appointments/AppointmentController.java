package com.estudos.alura.api.controler.appointments;

import com.estudos.alura.api.dto.appointment.AppointmentRequest;
import com.estudos.alura.api.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public void registerAppointment(@RequestBody @Valid AppointmentRequest appointmentRequest){
        appointmentService.registerAppointment(appointmentRequest);
    }

}
