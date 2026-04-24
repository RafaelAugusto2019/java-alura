package com.estudos.alura.api.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientJPA,String> {
}
