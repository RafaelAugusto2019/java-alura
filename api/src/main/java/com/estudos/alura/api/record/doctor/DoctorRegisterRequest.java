package com.estudos.alura.api.record.doctor;

import com.estudos.alura.api.record.address.AddressRegisterRequest;

public record DoctorRegisterRequest(
        String name,
        String email,
        String crm,
        MedicalSpecialties medicalSpecialties,
        AddressRegisterRequest address) {
}
