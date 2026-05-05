package com.estudos.alura.api.repository.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentJPA,Long> {
    List<AppointmentJPA> findAllByCpfAndDateAndEnable(String cpf, String date, Boolean enable);

    List<AppointmentJPA> findAllByDoctorIdAndEnable(Long doctorId, boolean enable);
}
