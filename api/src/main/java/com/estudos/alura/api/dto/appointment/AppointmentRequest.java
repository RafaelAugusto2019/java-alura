package com.estudos.alura.api.dto.appointment;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AppointmentRequest(
        @NotBlank
        @JsonProperty("patient_cpf")
        String patientCpf,
        @NotNull
        @JsonProperty("doctor_id")
        Long doctorId,
        @NotBlank
        String date,
        @NotBlank
        String time
) {
}
