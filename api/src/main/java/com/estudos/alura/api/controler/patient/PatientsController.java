package com.estudos.alura.api.controler.patient;

import com.estudos.alura.api.dto.patient.PatientRecordRequest;
import com.estudos.alura.api.repository.patient.PatientJPA;
import com.estudos.alura.api.repository.patient.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patients")
public class PatientsController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public void registerPatients(@RequestBody @Valid PatientRecordRequest patientRecordRequest){

        patientRepository.save(new PatientJPA(
                patientRecordRequest.cpf(),
                patientRecordRequest.name(),
                patientRecordRequest.email(),
                patientRecordRequest.phoneNumber(),
                true,
                patientRecordRequest.address()));


    }

}
