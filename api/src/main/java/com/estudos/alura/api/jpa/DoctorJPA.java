package com.estudos.alura.api.jpa;

import com.estudos.alura.api.dto.AddressRegisterRequest;
import com.estudos.alura.api.enums.MedicalSpecialties;
import jakarta.persistence.*;

@Table(name = "doctors")
@Entity(name = "doctor")
public class DoctorJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String crm;
    @Enumerated(EnumType.STRING)
    private MedicalSpecialties medicalSpecialties;
    @Embedded
    private AddressRegisterRequest address;

    public DoctorJPA(){

    }

    public DoctorJPA(Long id, String name, String email, String phoneNumber, String crm, MedicalSpecialties medicalSpecialties, AddressRegisterRequest address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.crm = crm;
        this.medicalSpecialties = medicalSpecialties;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public MedicalSpecialties getMedicalSpecialties() {
        return medicalSpecialties;
    }

    public void setMedicalSpecialties(MedicalSpecialties medicalSpecialties) {
        this.medicalSpecialties = medicalSpecialties;
    }

    public AddressRegisterRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRegisterRequest address) {
        this.address = address;
    }

}
