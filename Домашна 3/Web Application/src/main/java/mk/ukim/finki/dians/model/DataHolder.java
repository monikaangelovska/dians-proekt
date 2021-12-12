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
        pharmacy.setLon( 21.4226797);
        pharmacy.setLat( 41.9984708);
        pharmacy.setId((long)(Math.random()*1000));
        pharmacies.add(pharmacy);

        pharmacy=new Pharmacy();
        pharmacy.setName("Apteka Biofit");
        pharmacy.setLon( 21.4295599);
        pharmacy.setLat( 41.9835895);
        pharmacy.setId((long)(Math.random()*1000));
        pharmacies.add(pharmacy);

        pharmacy=new Pharmacy();
        pharmacy.setName("Uni Medical");
        pharmacy.setLon( 21.4219509);
        pharmacy.setLat( 41.9919776);
        pharmacy.setId((long)(Math.random()*1000));
        pharmacies.add(pharmacy);

        pharmacy=new Pharmacy();
        pharmacy.setName("Apteka Remedium Lek");
        pharmacy.setLon( 21.4053418);
        pharmacy.setLat( 42.0026568);
        pharmacy.setId((long)(Math.random()*1000));
        pharmacies.add(pharmacy);

        Hospital hospital=new Hospital();
        hospital.setName("Adrialab");
        hospital.setLon(21.4346369);
        hospital.setLat( 41.9869370);
        hospital.setId((long)(Math.random()*1000));
        hospitals.add(hospital);

        Veterinary veterinary=new Veterinary();
        veterinary.setName("Veterinarna Bolnica");
        veterinary.setLon( 21.4594860);
        veterinary.setLat( 42.0032592);
        veterinary.setId((long)(Math.random()*1000));
        veterinaries.add(veterinary);

        Clinic clinic=new Clinic();
        clinic.setName("Avicena Laboratorija");
        clinic.setLon(21.4042016);
        clinic.setLat(41.9975719);
        clinic.setId((long)(Math.random()*1000));
        clinics.add(clinic);
    }

}
