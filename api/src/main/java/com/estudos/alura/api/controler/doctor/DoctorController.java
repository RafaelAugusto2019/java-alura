package com.estudos.alura.api.controler.doctor;

import com.estudos.alura.api.dto.address.AddressRegisterRequest;
import com.estudos.alura.api.dto.doctor.DoctorRegisterRequest;
import com.estudos.alura.api.dto.doctor.DoctorRegisterResponse;
import com.estudos.alura.api.dto.doctor.DoctorUpdateRequest;
import com.estudos.alura.api.repository.doctor.DoctorJPA;
import com.estudos.alura.api.repository.doctor.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerDoctor(@RequestBody @Valid DoctorRegisterRequest doctorRegisterRequest, UriComponentsBuilder uriComponentsBuilder){

        var doctorJPA = new DoctorJPA(null,
                doctorRegisterRequest.name(),
                doctorRegisterRequest.email(),
                doctorRegisterRequest.phoneNumber(),
                doctorRegisterRequest.crm(),
                true,
                doctorRegisterRequest.medicalSpecialties(),
                new AddressRegisterRequest(
                        doctorRegisterRequest.address().addressLine1(),
                        doctorRegisterRequest.address().addressLine2(),
                        doctorRegisterRequest.address().district(),
                        doctorRegisterRequest.address().zipCode(),
                        doctorRegisterRequest.address().state(),
                        doctorRegisterRequest.address().city()
                ));

        doctorRepository.save(doctorJPA);

        var uri =  uriComponentsBuilder.path("/doctor/{id}").buildAndExpand(doctorJPA.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorRegisterResponse(doctorJPA));

    }

    @GetMapping
    public ResponseEntity<Page<DoctorRegisterResponse>> getAllDoctors(@PageableDefault(size = 2, sort = "name") Pageable pageable){
        var page = doctorRepository.findAllByEnableIsTrue(pageable).map(DoctorRegisterResponse::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DoctorRegisterResponse> updateDoctor(@PathVariable Long id, @RequestBody DoctorUpdateRequest doctorUpdateRequest){

        DoctorJPA doctorJPA = doctorRepository.getReferenceById(id);
        doctorJPA.updateInformation(doctorUpdateRequest);

        return ResponseEntity.ok(new DoctorRegisterResponse(doctorJPA));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDoctor(@PathVariable Long id){

        DoctorJPA doctorJPA = doctorRepository.getReferenceById(id);
        doctorJPA.setEnableFalse();

        return ResponseEntity.noContent().build();

    }

}
