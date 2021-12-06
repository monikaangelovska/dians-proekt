package mk.ukim.finki.dians.service;

import mk.ukim.finki.dians.model.*;

import java.util.List;
import java.util.Optional;

public interface SearchService {
    public List<Clinic> findAllClinics();
    public List<Hospital> findAllHospitals();
    public List<Veterinary> findAllVeterinaries();
    public List<Pharmacy> findAllPharmacies();
    public Optional<Hospital> findByIdHospital(Long Id);
    public Optional<Pharmacy> findByIdPharmacy(Long Id);
    public Optional<Veterinary> findByIdVeterinary(Long Id);
    public Optional<Clinic> findByIdClinic(Long Id);
    public Optional<Hospital> findByNameHospital(String text);
    public Optional<Pharmacy> findByNamePharmacy(String text);
    public Optional<Veterinary> findByNameVeterinary(String text);
    public Optional<Clinic> findByNameClinic(String text);
}
