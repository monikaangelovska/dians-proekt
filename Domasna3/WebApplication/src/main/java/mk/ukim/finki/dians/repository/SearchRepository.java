package mk.ukim.finki.dians.repository;

import mk.ukim.finki.dians.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class SearchRepository {
    public List<Clinic> findAllClinics(){return DataHolder.clinics;}
    public List<Hospital> findAllHospitals(){
        return DataHolder.hospitals;
    }
    public List<Veterinary> findAllVeterinaries(){
        return DataHolder.veterinaries;
    }
    public List<Pharmacy> findAllPharmacies(){
        return DataHolder.pharmacies;
    }
    public Optional<Hospital> findByIdHospital(Long Id)
    {
       return DataHolder.hospitals.stream().filter(h->h.getId().equals(Id)).findFirst();
    }
    public Optional<Pharmacy> findByIdPharmacy(Long Id)
    {
        return DataHolder.pharmacies.stream().filter(h->h.getId().equals(Id)).findFirst();
    }
    public Optional<Veterinary> findByIdVeterinary(Long Id)
    {
        return DataHolder.veterinaries.stream().filter(h->h.getId().equals(Id)).findFirst();
    }
    public Optional<Clinic> findByIdClinic(Long Id)
    {
        return DataHolder.clinics.stream().filter(h->h.getId().equals(Id)).findFirst();
    }
    public Optional<Hospital> findByNameHospital(String text)
    {
        return DataHolder.hospitals.stream().filter(h->h.getName().toLowerCase().contains(text.toLowerCase())).findFirst();
    }
    public Optional<Pharmacy> findByNamePharmacy(String text)
    {
        return DataHolder.pharmacies.stream().filter(h->h.getName().toLowerCase().contains(text.toLowerCase())).findFirst();
    }
    public Optional<Veterinary> findByNameVeterinary(String text)
    {
        return DataHolder.veterinaries.stream().filter(h->h.getName().toLowerCase().contains(text.toLowerCase())).findFirst();
    }
    public Optional<Clinic> findByNameClinic(String text)
    {
        return DataHolder.clinics.stream().filter(h->h.getName().toLowerCase().contains(text.toLowerCase())).findFirst();
    }


}
