package mk.ukim.finki.controller;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.entity.Veterinary;
import mk.ukim.finki.service.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/veterinaries")
@Slf4j
public class VeterinaryController {

    @Autowired
    private VeterinaryService veterinaryService;

    @GetMapping("/show/{id}")
    public List<Veterinary> findVeterinaryById(@PathVariable("id") Long veterinaryId) {
        List<Veterinary> hospitals=new ArrayList<>();
        if(veterinaryService.findByIdVeterinary(veterinaryId).isPresent())
        {
            hospitals.add(veterinaryService.findByIdVeterinary(veterinaryId).get());
        }
        return hospitals;
//        return veterinaryService.findByIdVeterinary(veterinaryId).get();
    }


    @GetMapping("/all")
    public List<Veterinary> findAll() {
        return veterinaryService.findAllVeterinaries();
    }

    @GetMapping("/name/{name}")
    public List<Veterinary> findByName(@PathVariable("name") String clinic) {
        return veterinaryService.findByNameVeterinary(clinic);
    }
}
