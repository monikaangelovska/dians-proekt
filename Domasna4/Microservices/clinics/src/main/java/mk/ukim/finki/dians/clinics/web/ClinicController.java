package mk.ukim.finki.dians.clinics.web;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.dians.clinics.VO.WrapperClinic;
import mk.ukim.finki.dians.clinics.model.Clinic;
import mk.ukim.finki.dians.clinics.service.Clinic_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinic")
@Slf4j
public class ClinicController {

    @Autowired
    private Clinic_service clinic_service;

    @GetMapping("/all")
    public List<Clinic> findAll() {
        return clinic_service.findAllClinics();
    }
    @GetMapping("/name/{name}")
    public List<Clinic> findByName(@PathVariable("name") String clinic) {
        return clinic_service.findByNameClinic(clinic);
    }

    @GetMapping("/show/{id}")
    public List<Clinic> findDepartmentById(@PathVariable("id") Long clinicId) {
//        log.info("Inside findDepartmentById method of DepartmentController");
//        WrapperClinic wrapperClinic;
//        if(clinic_service.findByIdClinic(clinicId).isPresent())
//        {
//                return    wrapperClinic =new WrapperClinic(clinic_service.findByIdClinic(clinicId).get());
//
//        }
//        wrapperClinic= new WrapperClinic(null);
//        return wrapperClinic;
//        return clinic_service.findByIdClinic(clinicId).get();
        List<Clinic> hospitals=new ArrayList<>();
        if(clinic_service.findByIdClinic(clinicId).isPresent())
        {
            hospitals.add(clinic_service.findByIdClinic(clinicId).get());
        }
        return hospitals;
    }
}