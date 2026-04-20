package com.estudos.alura.api.dto;

import com.estudos.alura.api.enums.MedicalSpecialties;

public record DoctorRegisterRequest(
        String name,
        String email,
        String crm,
        MedicalSpecialties medicalSpecialties,
        AddressRegisterRequest address) {
}
