package mk.ukim.finki.controller;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.entity.Veterinary;
import mk.ukim.finki.service.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veterinaries")
@Slf4j
public class VeterinaryController {

    @Autowired
    private VeterinaryService veterinaryService;

    @GetMapping("/{id}")
    public Veterinary findVeterinaryById(@PathVariable("id") Long veterinaryId) {
        return veterinaryService.findByIdVeterinary(veterinaryId).get();
    }
}
