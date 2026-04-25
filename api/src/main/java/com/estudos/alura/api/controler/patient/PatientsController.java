package com.estudos.alura.api.controler.patient;

import com.estudos.alura.api.dto.patient.PatientRecordRequest;
import com.estudos.alura.api.dto.patient.PatientRecordResponse;
import com.estudos.alura.api.dto.patient.PatientUpdateRequest;
import com.estudos.alura.api.repository.doctor.DoctorJPA;
import com.estudos.alura.api.repository.patient.PatientJPA;
import com.estudos.alura.api.repository.patient.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<PatientRecordResponse> getAllPatients(@PageableDefault(size = 2) Pageable pageable){
        return patientRepository.findByEnableIsTrue(pageable).map(PatientRecordResponse::new);
    }

    @PutMapping("/{cpf}")
    @Transactional
    public void updatePatient(@PathVariable String cpf, @RequestBody PatientUpdateRequest patientUpdateRequest){

        PatientJPA patientJPA = patientRepository.getReferenceById(cpf);
        patientJPA.updateInformation(patientUpdateRequest);

    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public void deleteDoctor(@PathVariable String cpf){

        PatientJPA patientJPA = patientRepository.getReferenceById(cpf);
        patientJPA.setEnableFalse();

    }

}
