package com.estudos.alura.api.service;

import com.estudos.alura.api.dto.appointment.AppointmentRequest;
import com.estudos.alura.api.repository.appointment.AppointmentJPA;
import com.estudos.alura.api.repository.appointment.AppointmentRepository;
import com.estudos.alura.api.repository.doctor.DoctorJPA;
import com.estudos.alura.api.repository.doctor.DoctorRepository;
import com.estudos.alura.api.repository.patient.PatientJPA;
import com.estudos.alura.api.repository.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private OperatingRuleService operatingRuleService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorScheduleRuleService doctorScheduleRuleService;

    public void registerAppointment(AppointmentRequest appointmentRequest) throws RuntimeException{

        var doctor = doctorRepository.findById(appointmentRequest.doctorId())
                .filter(DoctorJPA::isEnable)
                .orElseThrow(() -> new RuntimeException("Doctor is disabled or does not exist"));

        var patient = patientRepository.findById(appointmentRequest.patientCpf())
                .filter(PatientJPA::isEnable)
                .orElseThrow(() -> new RuntimeException("Patient is disabled or does not exist"));

        if (!operatingRuleService.validateDateTime(
                appointmentRequest.date(),
                appointmentRequest.time())){

            throw new RuntimeException("Please respect rules to schedule");
        }

        if(!appointmentRepository.findAllByCpfAndDate(
                patient.getCpf(),
                appointmentRequest.date()).isEmpty()){

            throw new RuntimeException("You already have an appointment scheduled to this day");
        }

        if(!doctorScheduleRuleService.validateDoctorSchedule(doctor.getId(), appointmentRequest.time())){
            throw new RuntimeException("There is already an appointment for this hour");
        }

        appointmentRepository.save(new AppointmentJPA(
                null,
                appointmentRequest.patientCpf(),
                appointmentRequest.doctorId(),
                appointmentRequest.date(),
                appointmentRequest.time()));

    }

}
