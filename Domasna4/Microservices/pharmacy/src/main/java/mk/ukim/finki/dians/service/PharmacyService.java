package mk.ukim.finki.dians.service;

import mk.ukim.finki.dians.entity.Pharmacy;
import mk.ukim.finki.dians.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacyService {
    @Autowired
    private PharmacyRepository pharmacyRepository;

    public List<Pharmacy> findAllPharmacies(){
        List<Pharmacy> pharmacies=pharmacyRepository.findAll();
        pharmacies.sort(Pharmacy.compareByName);
        return pharmacies;
    }


    public Optional<Pharmacy> findByIdPharmacy(Long Id) {
        return pharmacyRepository.findById(Id);
    }

    public List<Pharmacy> findByNamePharmacy(String text) {
        if(pharmacyRepository.findByNameIgnoreCaseContains(text).size()>1)
        {
            List<Pharmacy> pharmacies=pharmacyRepository.findByNameIgnoreCaseContains(text);
            pharmacies.sort(Pharmacy.compareByName);
            return pharmacies;
        }
        return pharmacyRepository.findByNameIgnoreCaseContains(text);
    }
}
