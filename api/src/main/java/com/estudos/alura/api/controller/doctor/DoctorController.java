package com.estudos.alura.api.controller.doctor;

import com.estudos.alura.api.dto.AddressRegisterRequest;
import com.estudos.alura.api.dto.DoctorRegisterRequest;
import com.estudos.alura.api.dto.DoctorRegisterResponse;
import com.estudos.alura.api.jpa.DoctorJPA;
import com.estudos.alura.api.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
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
    public List<DoctorRegisterResponse> getAllDoctors(){
        return doctorRepository.findAll().stream().map(DoctorRegisterResponse::new).toList();
    }

}
