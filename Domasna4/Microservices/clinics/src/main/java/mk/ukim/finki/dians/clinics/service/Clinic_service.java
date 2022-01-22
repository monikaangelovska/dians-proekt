package mk.ukim.finki.dians.clinics.service;

import mk.ukim.finki.dians.clinics.model.Clinic;
import mk.ukim.finki.dians.clinics.repository.Clinic_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Clinic_service {

    private final Clinic_repository clinic_repository;

    public Clinic_service(Clinic_repository clinic_repository) {
        this.clinic_repository = clinic_repository;
    }
    public List<Clinic> findAllClinics(){
        List<Clinic> clinics=clinic_repository.findAll();
        clinics.sort(Clinic.compareByName);
        return clinics;
    }

    public Optional<Clinic> findByIdClinic(Long Id) {
        return clinic_repository.findById(Id);
    }

    public List<Clinic> findByNameClinic(String text) {
        if(clinic_repository.findByNameIgnoreCaseContains(text).size()>1)
        {
            List<Clinic> clinics=clinic_repository.findByNameIgnoreCaseContains(text);
            clinics.sort(Clinic.compareByName);
            return clinics;
        }
        return clinic_repository.findByNameIgnoreCaseContains(text);
    }
}
