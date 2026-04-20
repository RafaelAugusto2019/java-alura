package com.estudos.alura.api.controller.doctor;

import com.estudos.alura.api.dto.AddressRegisterRequest;
import com.estudos.alura.api.dto.DoctorRegisterRequest;
import com.estudos.alura.api.jpa.DoctorJPA;
import com.estudos.alura.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public void registerDoctor(@RequestBody DoctorRegisterRequest doctorRegisterRequest){

        System.out.println(doctorRegisterRequest.toString());

        doctorRepository.save(new DoctorJPA(null,
                doctorRegisterRequest.name(),
                doctorRegisterRequest.email(),
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

}
