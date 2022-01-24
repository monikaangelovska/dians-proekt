package mk.finki.ukim.dians.hospital.service;

import mk.finki.ukim.dians.hospital.entity.Hospital;
import mk.finki.ukim.dians.hospital.repository.Hospitalrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private Hospitalrepository hospitalrepository;

    public List<Hospital> findAllHospitals(){
        List<Hospital> veterinaries=hospitalrepository.findAll();
        veterinaries.sort(Hospital.compareByName);
        return veterinaries;
    }

    public Optional<Hospital> findByIdHospital(Long Id) {
        return hospitalrepository.findById(Id);
    }

    public List<Hospital> findByNameHospital(String text) {
        if(hospitalrepository.findByNameIgnoreCaseContains(text).size()>1)
        {
            List<Hospital> veterinaries=hospitalrepository.findByNameIgnoreCaseContains(text);
            veterinaries.sort(Hospital.compareByName);
            return veterinaries;
        }
        return hospitalrepository.findByNameIgnoreCaseContains(text);
    }

}
