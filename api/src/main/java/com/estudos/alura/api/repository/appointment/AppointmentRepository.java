package com.estudos.alura.api.repository.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentJPA,Long> {
    List<AppointmentJPA> findAllByCpfAndDate(String cpf, String date);

    List<AppointmentJPA> findAllByDoctorId(Long doctorId);
}
