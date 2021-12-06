package mk.ukim.finki.dians.service;

import mk.ukim.finki.dians.model.*;
import mk.ukim.finki.dians.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService{
    private final SearchRepository searchRepository;

    public SearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<Clinic> findAllClinics(){
        return searchRepository.findAllClinics();
    }
    public List<Hospital> findAllHospitals(){
        return searchRepository.findAllHospitals();
    }
    public List<Veterinary> findAllVeterinaries(){
        return searchRepository.findAllVeterinaries();
    }
    public List<Pharmacy> findAllPharmacies(){
        return searchRepository.findAllPharmacies();
    }

    @Override
    public Optional<Hospital> findByIdHospital(Long Id) {
       return searchRepository.findByIdHospital(Id);
    }

    @Override
    public Optional<Pharmacy> findByIdPharmacy(Long Id) {
        return searchRepository.findByIdPharmacy(Id);
    }

    @Override
    public Optional<Veterinary> findByIdVeterinary(Long Id) {
        return searchRepository.findByIdVeterinary(Id);
    }

    @Override
    public Optional<Clinic> findByIdClinic(Long Id) {
        return searchRepository.findByIdClinic(Id);
    }
}
