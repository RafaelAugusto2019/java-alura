package com.estudos.alura.api.dto.patient;

import com.estudos.alura.api.repository.patient.PatientJPA;
import jakarta.validation.constraints.NotEmpty;

@NotEmpty
public record PatientRecordResponse(
        String cpf,
        String name,
        String email
) {

    public PatientRecordResponse(PatientJPA patientJPA) {
        this(patientJPA.getCpf(), patientJPA.getName(), patientJPA.getEmail());
    }

}
