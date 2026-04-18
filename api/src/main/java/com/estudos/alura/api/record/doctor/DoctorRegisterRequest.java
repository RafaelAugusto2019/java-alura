package com.estudos.alura.api.doctor;

import com.estudos.alura.api.address.Address;

public record DoctorRegisterRequest(
        String name,
        String email,
        String crm,
        MedicalSpecialties medicalSpecialties,
        Address address) {
}
