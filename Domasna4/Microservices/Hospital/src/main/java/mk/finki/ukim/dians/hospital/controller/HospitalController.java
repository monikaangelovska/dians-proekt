package mk.finki.ukim.dians.hospital.controller;


import lombok.extern.slf4j.Slf4j;
import mk.finki.ukim.dians.hospital.VO.WrapperHospital;
import mk.finki.ukim.dians.hospital.entity.Hospital;
import mk.finki.ukim.dians.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hospitals")
@Slf4j
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/show/{id}")
    public List<Hospital> findVeterinaryById(@PathVariable("id") Long hospitalId) {
        List<Hospital> hospitals=new ArrayList<>();
        if(hospitalService.findByIdHospital(hospitalId).isPresent())
        {
            hospitals.add(hospitalService.findByIdHospital(hospitalId).get());
        }
        return hospitals;
    }
    @GetMapping("/all")
    public List<Hospital> findAll() {
        return hospitalService.findAllHospitals();
    }

    @GetMapping("/name/{name}")
    public List<Hospital> findByName(@PathVariable("name") String hospital) {

        return hospitalService.findByNameHospital(hospital);
    }
}
