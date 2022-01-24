package mk.ukim.finki.dians.service;

import mk.ukim.finki.dians.model.*;
import mk.ukim.finki.dians.repository.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        List<Clinic> clinics=clinic_repository.findAll();
        clinics.sort(Clinic.compareByName);
        return clinics;
    }
    public List<Hospital> findAllHospitals(){
        List<Hospital> hospitals=hospital_repository.findAll();
        hospitals.sort(Hospital.compareByName);
        return hospitals;
    }
    public List<Veterinary> findAllVeterinaries(){
        List<Veterinary> veterinaries=veterinary_repository.findAll();
        veterinaries.sort(Veterinary.compareByName);
        return veterinaries;
    }
    public List<Pharmacy> findAllPharmacies(){
        List<Pharmacy> pharmacies=pharmacy_repository.findAll();
        pharmacies.sort(Pharmacy.compareByName);
        return pharmacies;
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
    public List<Hospital> findByNameHospital(String text) {
        if (hospital_repository.findByNameIgnoreCaseContains(text).size()>1)
        {
            List<Hospital> hospitals=hospital_repository.findByNameIgnoreCaseContains(text);
            hospitals.sort(Hospital.compareByName);
            return hospitals;
        }
        return hospital_repository.findByNameIgnoreCaseContains(text);
    }

    @Override
    public List<Pharmacy> findByNamePharmacy(String text) {
        if(pharmacy_repository.findByNameIgnoreCaseContains(text).size()>1)
        {
            List<Pharmacy> pharmacies=pharmacy_repository.findByNameIgnoreCaseContains(text);
            pharmacies.sort(Pharmacy.compareByName);
            return pharmacies;
        }
        return pharmacy_repository.findByNameIgnoreCaseContains(text);
    }

    @Override
    public List<Veterinary> findByNameVeterinary(String text) {
        if(veterinary_repository.findByNameIgnoreCaseContains(text).size()>1)
        {
            List<Veterinary> veterinaries=veterinary_repository.findByNameIgnoreCaseContains(text);
            veterinaries.sort(Veterinary.compareByName);
            return veterinaries;
        }
        return veterinary_repository.findByNameIgnoreCaseContains(text);
    }

    @Override
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
