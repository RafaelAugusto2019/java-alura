package com.estudos.alura.api.controller.doctor;

import com.estudos.alura.api.dto.AddressRegisterRequest;
import com.estudos.alura.api.dto.DoctorRegisterRequest;
import com.estudos.alura.api.dto.DoctorRegisterResponse;
import com.estudos.alura.api.dto.DoctorUpdateRequest;
import com.estudos.alura.api.jpa.DoctorJPA;
import com.estudos.alura.api.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void registerDoctor(@RequestBody @Valid DoctorRegisterRequest doctorRegisterRequest){

        doctorRepository.save(new DoctorJPA(null,
                doctorRegisterRequest.name(),
                doctorRegisterRequest.email(),
                doctorRegisterRequest.phoneNumber(),
                doctorRegisterRequest.crm(),
                doctorRegisterRequest.medicalSpecialties(),
                new AddressRegisterRequest(
                        doctorRegisterRequest.address().addressLine1(),
                        doctorRegisterRequest.address().addressLine2(),
                        doctorRegisterRequest.address().district(),
                        doctorRegisterRequest.address().zipCode(),
                        doctorRegisterRequest.address().state(),
                        doctorRegisterRequest.address().city()
                )));

    }

    @GetMapping
    public Page<DoctorRegisterResponse> getAllDoctors(@PageableDefault(size = 2, sort = "name") Pageable pageable){
        return doctorRepository.findAll(pageable).map(DoctorRegisterResponse::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void updateDoctor(@PathVariable Long id, @RequestBody DoctorUpdateRequest doctorUpdateRequest){

        DoctorJPA doctorJPA = doctorRepository.getReferenceById(id);
        doctorJPA.updateInformation(doctorUpdateRequest);

    }

}
