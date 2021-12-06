package mk.ukim.finki.dians.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Clinic> clinics=new ArrayList<>();
    public static List<Hospital> hospitals=new ArrayList<>();
    public static List<Veterinary> veterinaries=new ArrayList<>();
    public static List<Pharmacy> pharmacies=new ArrayList<>();

    @PostConstruct
    public void init(){
        Pharmacy pharmacy=new Pharmacy();
        pharmacy.setName("Zegin");
        pharmacy.setId((long)(Math.random()*1000));
        pharmacies.add(pharmacy);
        pharmacy=new Pharmacy();
        pharmacy.setName("Apteka Biofit");
        pharmacy.setId((long)(Math.random()*1000));
        pharmacies.add(pharmacy);
        pharmacy=new Pharmacy();
        pharmacy.setName("Uni Medical");
        pharmacy.setId((long)(Math.random()*1000));
        pharmacies.add(pharmacy);
        pharmacy=new Pharmacy();
        pharmacy.setName("Apteka Remedium Lek");
        pharmacy.setId((long)(Math.random()*1000));
        pharmacies.add(pharmacy);

        Hospital hospital=new Hospital();
        hospital.setName("Adrialab");
        hospital.setId((long)(Math.random()*1000));
        hospitals.add(hospital);

        Veterinary veterinary=new Veterinary();
        veterinary.setName("Veterinarna Bolnica");
        veterinary.setId((long)(Math.random()*1000));
        veterinaries.add(veterinary);

        Clinic clinic=new Clinic();
        clinic.setName("Avicena Laboratorija");
        clinic.setId((long)(Math.random()*1000));
        clinics.add(clinic);
    }

}
