package com.estudos.alura.api.repository.appointment;

import jakarta.persistence.*;

@Table(name = "appointments")
@Entity(name = "appointments")
public class AppointmentJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private Long doctorId;
    private String date;
    private String time;

    public AppointmentJPA(){}

    public AppointmentJPA(Long id, String cpf, Long doctorId, String date, String time) {
        this.id = id;
        this.cpf = cpf;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
