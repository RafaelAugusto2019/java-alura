package com.estudos.alura.api.dto;

import com.estudos.alura.api.enums.MedicalSpecialties;
import com.estudos.alura.api.jpa.DoctorJPA;

public record DoctorRegisterResponse(
        String name,
        String email,
        String crm,
        MedicalSpecialties medicalSpecialties) {

    public DoctorRegisterResponse(DoctorJPA doctorJPA){
        this(   doctorJPA.getName(),
                doctorJPA.getEmail(),
                doctorJPA.getCrm(),
                doctorJPA.getMedicalSpecialties());
    }

}
