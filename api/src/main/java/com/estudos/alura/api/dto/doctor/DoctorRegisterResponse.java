package com.estudos.alura.api.doctor.dto;

import com.estudos.alura.api.enums.MedicalSpecialties;
import com.estudos.alura.api.doctor.repository.DoctorJPA;

public record DoctorRegisterResponse(
        Long id,
        String name,
        String email,
        String crm,
        MedicalSpecialties medicalSpecialties) {

    public DoctorRegisterResponse(DoctorJPA doctorJPA){
        this(   doctorJPA.getId(),
                doctorJPA.getName(),
                doctorJPA.getEmail(),
                doctorJPA.getCrm(),
                doctorJPA.getMedicalSpecialties());
    }

}
