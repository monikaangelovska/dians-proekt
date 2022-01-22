package mk.ukim.finki.dians.clinics.repository;

import mk.ukim.finki.dians.clinics.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Clinic_repository extends JpaRepository<Clinic, Long> {


    List<Clinic> findByNameIgnoreCaseContains(String text);


}