package mk.ukim.finki.dians.clinics.web;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.dians.clinics.model.Clinic;
import mk.ukim.finki.dians.clinics.service.Clinic_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinic")
@Slf4j
public class ClinicController {

    @Autowired
    private Clinic_service clinic_service;



    @GetMapping("/{id}")
    public Clinic findDepartmentById(@PathVariable("id") Long clinicId) {
//        log.info("Inside findDepartmentById method of DepartmentController");
        return clinic_service.findByIdClinic(clinicId).get();
    }

}