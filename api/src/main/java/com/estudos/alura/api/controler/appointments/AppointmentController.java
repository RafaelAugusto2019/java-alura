package com.estudos.alura.api.controler.appointments;

import com.estudos.alura.api.dto.appointment.AppointmentRequest;
import com.estudos.alura.api.repository.appointment.AppointmentJPA;
import com.estudos.alura.api.repository.appointment.AppointmentRepository;
import com.estudos.alura.api.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping
    public void registerAppointment(@RequestBody @Valid AppointmentRequest appointmentRequest){
        appointmentService.registerAppointment(appointmentRequest);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void cancelAppointment(@PathVariable Long id){

        var appointment = appointmentRepository.getReferenceById(id);
        appointment.setEnableFalse();

    }

}
