package mk.ukim.finki.dians.service;

import mk.ukim.finki.dians.model.*;
import mk.ukim.finki.dians.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService{
    private final Clinic_repository clinic_repository;
    private final Hospital_repository hospital_repository;
    private final Pharmacy_repository pharmacy_repository;
    private final Veterinary_repository veterinary_repository;



    public SearchServiceImpl(Clinic_repository clinic_repository, Hospital_repository hospital_repository, Pharmacy_repository pharmacy_repository, Veterinary_repository veterinary_repository) {
        this.clinic_repository = clinic_repository;
        this.hospital_repository = hospital_repository;
        this.pharmacy_repository = pharmacy_repository;
        this.veterinary_repository = veterinary_repository;

    }

    public List<Clinic> findAllClinics(){
        return clinic_repository.findAll();
    }
    public List<Hospital> findAllHospitals(){
        return hospital_repository.findAll();
    }
    public List<Veterinary> findAllVeterinaries(){
        return veterinary_repository.findAll();
    }
    public List<Pharmacy> findAllPharmacies(){
        return pharmacy_repository.findAll();
    }

    @Override
    public Optional<Hospital> findByIdHospital(Long Id) {
       return hospital_repository.findById(Id);
    }

    @Override
    public Optional<Pharmacy> findByIdPharmacy(Long Id) {
        return pharmacy_repository.findById(Id);
    }

    @Override
    public Optional<Veterinary> findByIdVeterinary(Long Id) {
        return veterinary_repository.findById(Id);
    }

    @Override
    public Optional<Clinic> findByIdClinic(Long Id) {
        return clinic_repository.findById(Id);
    }

    @Override
    public Optional<Hospital> findByNameHospital(String text) {
        return hospital_repository.findByName(text);
    }

    @Override
    public Optional<Pharmacy> findByNamePharmacy(String text) {
        return pharmacy_repository.findByName(text);
    }

    @Override
    public Optional<Veterinary> findByNameVeterinary(String text) {
        return veterinary_repository.findByName(text);
    }

    @Override
    public Optional<Clinic> findByNameClinic(String text) {
        return clinic_repository.findByName(text);
    }
}
