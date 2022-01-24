package mk.ukim.finki.dians.controller;


import mk.ukim.finki.dians.entity.Pharmacy;
import mk.ukim.finki.dians.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping("/{id}")
    public Pharmacy findDepartmentById(@PathVariable("id") Long pharmacyId) {
        return pharmacyService.findByIdPharmacy(pharmacyId).get();
    }
}
