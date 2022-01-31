package mk.ukim.finki.dians.service;

import mk.ukim.finki.dians.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService{
    private final RestTemplate restTemplate;

    public SearchServiceImpl( RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public List<Clinic> findAllClinics(){
        Clinic[] clinics = restTemplate.getForObject("http://localhost:9191/clinic/all",Clinic[].class);
        List<Clinic> clinicList = Arrays.asList(clinics);
        clinicList.sort(Clinic.compareByName);
        return clinicList;
    }
    public List<Hospital> findAllHospitals(){
        Hospital[] hospitals = restTemplate.getForObject("http://localhost:9191/hospitals/all",Hospital[].class);
        List<Hospital> hospitals1 = Arrays.asList(hospitals);
        hospitals1.sort(Hospital.compareByName);
        return hospitals1;
    }
    public List<Veterinary> findAllVeterinaries(){
        Veterinary[] veterinaries = restTemplate.getForObject("http://localhost:9191/veterinaries/all",Veterinary[].class);
        List<Veterinary> veterinaries1 =Arrays.asList(veterinaries);
        veterinaries1.sort(Veterinary.compareByName);
        return veterinaries1;
    }
    public List<Pharmacy> findAllPharmacies(){
        Pharmacy[] pharmacies = restTemplate.getForObject("http://localhost:9191/pharmacies/all",Pharmacy[].class);
        List<Pharmacy> pharmacies1 = Arrays.asList(pharmacies);
        pharmacies1.sort(Pharmacy.compareByName);
        return pharmacies1;
    }

    @Override
    public Optional<Hospital> findByIdHospital(Long Id) {
        Hospital[] hospitals = restTemplate.getForObject("http://localhost:9191/hospitals/show/" + Id,Hospital[].class);
        List<Hospital> hospitals1 = Arrays.asList(hospitals);
        if(hospitals1.size()==1)
       return Optional.of(hospitals1.get(0));
        else
            return Optional.empty();
    }

    @Override
    public Optional<Pharmacy> findByIdPharmacy(Long Id) {
        Pharmacy[] pharmacies = restTemplate.getForObject("http://localhost:9191/pharmacies/show/" + Id,Pharmacy[].class);
        List<Pharmacy> pharmacies1 = Arrays.asList(pharmacies);
        if(pharmacies1.size()==1)
            return Optional.of(pharmacies1.get(0));
        else
            return Optional.empty();
    }

    @Override
    public Optional<Veterinary> findByIdVeterinary(Long Id) {
        Veterinary[] veterinaries = restTemplate.getForObject("http://localhost:9191/veterinaries/show/" + Id,Veterinary[].class);
        List<Veterinary> veterinaries1 = Arrays.asList(veterinaries);
        if(veterinaries1.size()==1)
            return Optional.of(veterinaries1.get(0));
        else
            return Optional.empty();
    }

    @Override
    public Optional<Clinic> findByIdClinic(Long Id) {
        Clinic[] clinics = restTemplate.getForObject("http://localhost:9191/clinic/show/" + Id,Clinic[].class);
        List<Clinic> clinics1 = Arrays.asList(clinics);
        if(clinics1.size()==1)
            return Optional.of(clinics1.get(0));
        else
            return Optional.empty();
    }

    @Override
    public List<Hospital> findByNameHospital(String text) {
        Hospital[] hospitals = restTemplate.getForObject("http://localhost:9191/hospitals/name/"+text,Hospital[].class);
        List<Hospital> hospitals1 = Arrays.asList(hospitals);
        if (hospitals1.size()>1)
        {
            hospitals1.sort(Hospital.compareByName);
            return hospitals1;
        }
        return hospitals1;
    }

    @Override
    public List<Pharmacy> findByNamePharmacy(String text) {
        Pharmacy[] pharmacies = restTemplate.getForObject("http://localhost:9191/pharmacies/name/"+text,Pharmacy[].class);
        List<Pharmacy> pharmacies1 = Arrays.asList(pharmacies);
        if(pharmacies1.size()>1)
        {
            pharmacies1.sort(Pharmacy.compareByName);
            return pharmacies1;
        }
        return pharmacies1;
    }

    @Override
    public List<Veterinary> findByNameVeterinary(String text) {
        Veterinary[] veterinaries = restTemplate.getForObject("http://localhost:9191/veterinaries/name/"+text,Veterinary[].class);
        List<Veterinary> veterinaries1 =Arrays.asList(veterinaries);
        if(veterinaries1.size()>1)
        {
            veterinaries1.sort(Veterinary.compareByName);
            return veterinaries1;
        }
        return veterinaries1;

    }

    @Override
    public List<Clinic> findByNameClinic(String text) {
        Clinic[] clinics = restTemplate.getForObject("http://localhost:9191/clinic/name/"+text,Clinic[].class);
        List<Clinic> clinicList = Arrays.asList(clinics);
        if(clinicList.size()>1)
        {
            clinicList.sort(Clinic.compareByName);
            return clinicList;
        }
        return clinicList;
    }
}
