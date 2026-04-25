package com.estudos.alura.api.repository.patient;

import com.estudos.alura.api.dto.address.AddressRegisterRequest;
import com.estudos.alura.api.dto.patient.PatientUpdateRequest;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Table(name = "patients")
@Entity(name = "patients")
public class PatientJPA {

    @Id
    @NotBlank
    private String cpf;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;
    private boolean enable;
    @Embedded
    @Valid
    private AddressRegisterRequest address;

    public PatientJPA(){}

    public PatientJPA(String cpf, String name, String email, String phoneNumber, boolean enable, AddressRegisterRequest address) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.enable = enable;
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public AddressRegisterRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRegisterRequest address) {
        this.address = address;
    }

    public void updateInformation(PatientUpdateRequest patientUpdateRequest) {
        this.name = patientUpdateRequest.name();
        this.phoneNumber = patientUpdateRequest.phoneNumber();
        this.address =  patientUpdateRequest.address();
    }
}
