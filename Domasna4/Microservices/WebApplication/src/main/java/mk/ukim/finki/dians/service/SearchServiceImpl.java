package mk.ukim.finki.dians.service;

import mk.ukim.finki.dians.VO.WrapperClinic;
import mk.ukim.finki.dians.VO.WrapperHospital;
import mk.ukim.finki.dians.model.*;
import mk.ukim.finki.dians.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService{
    private final Clinic_repository clinic_repository;
    private final Hospital_repository hospital_repository;
    private final Pharmacy_repository pharmacy_repository;
    private final Veterinary_repository veterinary_repository;
    private final RestTemplate restTemplate;



    public SearchServiceImpl(Clinic_repository clinic_repository, Hospital_repository hospital_repository, Pharmacy_repository pharmacy_repository, Veterinary_repository veterinary_repository, RestTemplate restTemplate) {
        this.clinic_repository = clinic_repository;
        this.hospital_repository = hospital_repository;
        this.pharmacy_repository = pharmacy_repository;
        this.veterinary_repository = veterinary_repository;
        this.restTemplate = restTemplate;
    }


    public List<Clinic> findAllClinics(){
/*
        List<Clinic> clinics=clinic_repository.findAll();
*/
        Clinic[] clinics = restTemplate.getForObject("http://localhost:9191/clinic/all",Clinic[].class);
        List<Clinic> clinicList = Arrays.asList(clinics);
        clinicList.sort(Clinic.compareByName);
        return clinicList;
    }
    public List<Hospital> findAllHospitals(){
        /*List<Hospital> hospitals=hospital_repository.findAll();
        */
        Hospital[] hospitals = restTemplate.getForObject("http://localhost:9191/hospitals/all",Hospital[].class);
        List<Hospital> hospitals1 = Arrays.asList(hospitals);
        hospitals1.sort(Hospital.compareByName);
        return hospitals1;
    }
    public List<Veterinary> findAllVeterinaries(){
        /*List<Veterinary> veterinaries=veterinary_repository.findAll();*/
        Veterinary[] veterinaries = restTemplate.getForObject("http://localhost:9191/veterinaries/all",Veterinary[].class);
        List<Veterinary> veterinaries1 =Arrays.asList(veterinaries);
        veterinaries1.sort(Veterinary.compareByName);
        return veterinaries1;
    }
    public List<Pharmacy> findAllPharmacies(){
/*
        List<Pharmacy> pharmacies=pharmacy_repository.findAll();
*/
        Pharmacy[] pharmacies = restTemplate.getForObject("http://localhost:9191/pharmacies/all",Pharmacy[].class);
        List<Pharmacy> pharmacies1 = Arrays.asList(pharmacies);
        pharmacies1.sort(Pharmacy.compareByName);
        return pharmacies1;
    }

    @Override
    public Optional<Hospital> findByIdHospital(Long Id) {
       /*return hospital_repository.findById(Id);*/
//       WrapperHospital wrapperHospital = restTemplate.getForObject("http://localhost:9191/hospitals/show/" + Id, WrapperHospital.class);
//        Hospital hospital = wrapperHospital.getHospital();
        Hospital[] hospitals = restTemplate.getForObject("http://localhost:9191/hospitals/show/" + Id,Hospital[].class);
        List<Hospital> hospitals1 = Arrays.asList(hospitals);
//        Hospital hospital = restTemplate.getForObject("http://localhost:9191/hospitals/show/" + Id,Hospital.class);
        if(hospitals1.size()==1)
       return Optional.of(hospitals1.get(0));
        else
            return Optional.empty();
    }

    @Override
    public Optional<Pharmacy> findByIdPharmacy(Long Id) {
        /*return pharmacy_repository.findById(Id);*/
//        Pharmacy pharmacy = restTemplate.getForObject("http://localhost:9191/pharmacies/show/" + Id,Pharmacy.class);
//        return Optional.of(pharmacy);

        Pharmacy[] hospitals = restTemplate.getForObject("http://localhost:9191/pharmacies/show/" + Id,Pharmacy[].class);
        List<Pharmacy> hospitals1 = Arrays.asList(hospitals);
//        Hospital hospital = restTemplate.getForObject("http://localhost:9191/hospitals/show/" + Id,Hospital.class);
        if(hospitals1.size()==1)
            return Optional.of(hospitals1.get(0));
        else
            return Optional.empty();
    }

    @Override
    public Optional<Veterinary> findByIdVeterinary(Long Id) {
       /* return veterinary_repository.findById(Id);*/
//       Veterinary veterinary = restTemplate.getForObject("http://localhost:9191/veterinaries/show/" + Id,Veterinary.class);
//       return Optional.of(veterinary);
        Veterinary[] hospitals = restTemplate.getForObject("http://localhost:9191/veterinaries/show/" + Id,Veterinary[].class);
        List<Veterinary> hospitals1 = Arrays.asList(hospitals);
//        Hospital hospital = restTemplate.getForObject("http://localhost:9191/hospitals/show/" + Id,Hospital.class);
        if(hospitals1.size()==1)
            return Optional.of(hospitals1.get(0));
        else
            return Optional.empty();
    }

    @Override
    public Optional<Clinic> findByIdClinic(Long Id) {
/*        return clinic_repository.findById(Id);*/
//        WrapperClinic wrapperClinic =restTemplate.getForObject("http://localhost:9191/clinic/show/" + Id,WrapperClinic.class);
//        Clinic clinic = wrapperClinic.getClinic();
//        return Optional.of(clinic);
        Clinic[] hospitals = restTemplate.getForObject("http://localhost:9191/clinic/show/" + Id,Clinic[].class);
        List<Clinic> hospitals1 = Arrays.asList(hospitals);
//        Hospital hospital = restTemplate.getForObject("http://localhost:9191/hospitals/show/" + Id,Hospital.class);
        if(hospitals1.size()==1)
            return Optional.of(hospitals1.get(0));
        else
            return Optional.empty();
    }

    @Override
    public List<Hospital> findByNameHospital(String text) {
        Hospital[] hospitals = restTemplate.getForObject("http://localhost:9191/hospitals/name/"+text,Hospital[].class);
        List<Hospital> hospitals1 = Arrays.asList(hospitals);
       /* hospitals1.sort(Hospital.compareByName);*/
        if (hospitals1.size()>1)
        {
            /*List<Hospital> hospitals=hospital_repository.findByNameIgnoreCaseContains(text);*/
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
            /*List<Pharmacy> pharmacies=pharmacy_repository.findByNameIgnoreCaseContains(text);
            */
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
            /*List<Veterinary> veterinaries=veterinary_repository.findByNameIgnoreCaseContains(text);
            */
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
/*
            List<Clinic> clinics=clinic_repository.findByNameIgnoreCaseContains(text);
*/
            clinicList.sort(Clinic.compareByName);
            return clinicList;
        }
        return clinicList;
    }
}
