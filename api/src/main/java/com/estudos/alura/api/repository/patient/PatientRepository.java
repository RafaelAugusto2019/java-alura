package com.estudos.alura.api.repository.patient;

import com.estudos.alura.api.dto.patient.PatientRecordResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientJPA,String> {
    Page<PatientJPA> findByEnableIsTrue(Pageable pageable);
}
