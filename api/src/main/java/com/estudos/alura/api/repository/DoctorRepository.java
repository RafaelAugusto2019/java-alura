package com.estudos.alura.api.repository;

import com.estudos.alura.api.jpa.DoctorJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorJPA, Long> {
}
