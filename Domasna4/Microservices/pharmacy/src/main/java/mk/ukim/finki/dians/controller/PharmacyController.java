package mk.ukim.finki.dians.controller;


import mk.ukim.finki.dians.entity.Pharmacy;
import mk.ukim.finki.dians.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping("/show/{id}")
    public List<Pharmacy> findDepartmentById(@PathVariable("id") Long pharmacyId) {
        List<Pharmacy> pharmacies=new ArrayList<>();
        if(pharmacyService.findByIdPharmacy(pharmacyId).isPresent())
        {
            pharmacies.add(pharmacyService.findByIdPharmacy(pharmacyId).get());
        }
        return pharmacies;
    }

    @GetMapping("/all")
    public List<Pharmacy> findAll() {
        return pharmacyService.findAllPharmacies();
    }

    @GetMapping("/name/{name}")
    public List<Pharmacy> findByName(@PathVariable("name") String pharmacy) {
        return pharmacyService.findByNamePharmacy(pharmacy);
    }
}
