package com.estudos.alura.api.controller.doctor;

import com.estudos.alura.api.record.doctor.DoctorRegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @PostMapping
    public void registerDoctor(@RequestBody DoctorRegisterRequest doctorRegisterRequest){

        System.out.println(doctorRegisterRequest.toString());

    }

}
