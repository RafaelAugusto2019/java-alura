package com.estudos.alura.api.doctor.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorJPA, Long> {
    Page<DoctorJPA> findAllByEnableIsTrue(Pageable pageable);
}
