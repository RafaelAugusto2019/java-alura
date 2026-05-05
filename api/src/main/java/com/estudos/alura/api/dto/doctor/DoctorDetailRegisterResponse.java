package com.estudos.alura.api.dto.doctor;

import com.estudos.alura.api.dto.address.AddressRegisterRequest;
import com.estudos.alura.api.enums.MedicalSpecialties;
import com.estudos.alura.api.repository.doctor.DoctorJPA;

public record DoctorDetailRegisterResponse(
        Long id,
        String name,
        String email,
        String crm,
        String phoneNumber,
        boolean enable,
        MedicalSpecialties medicalSpecialties,
        AddressRegisterRequest addressRegisterRequest) {

    public DoctorDetailRegisterResponse(DoctorJPA doctorJPA){
        this(   doctorJPA.getId(),
                doctorJPA.getName(),
                doctorJPA.getEmail(),
                doctorJPA.getCrm(),
                doctorJPA.getPhoneNumber(),
                doctorJPA.isEnable(),
                doctorJPA.getMedicalSpecialties(),
                doctorJPA.getAddress());
    }

}
