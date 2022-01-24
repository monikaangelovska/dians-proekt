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

//    @GetMapping("/show/{id}")
//    public WrapperHospital findVeterinaryById(@PathVariable("id") Long veterinaryId) {
////        WrapperHospital wrapperHospital;
////        if(hospitalService.findByIdHospital(veterinaryId).isPresent())
////        {
////            return new WrapperHospital(hospitalService.findByIdHospital(veterinaryId).get());
////        }
////        wrapperHospital= new WrapperHospital(null);
////        return wrapperHospital;
//        return  hospitalService.findByIdHospital(veterinaryId).get();
//    }
    @GetMapping("/show/{id}")
    public List<Hospital> findVeterinaryById(@PathVariable("id") Long veterinaryId) {
        List<Hospital> hospitals=new ArrayList<>();
        if(hospitalService.findByIdHospital(veterinaryId).isPresent())
        {
            hospitals.add(hospitalService.findByIdHospital(veterinaryId).get());
        }
        return hospitals;
//        return  hospitalService.findByIdHospital(veterinaryId).get();
    }
    @GetMapping("/all")
    public List<Hospital> findAll() {
        return hospitalService.findAllHospitals();
    }

    @GetMapping("/name/{name}")
    public List<Hospital> findByName(@PathVariable("name") String clinic) {

        return hospitalService.findByNameHospital(clinic);
    }
}
