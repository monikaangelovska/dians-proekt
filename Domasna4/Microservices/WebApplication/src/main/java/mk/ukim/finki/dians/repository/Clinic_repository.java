package mk.ukim.finki.dians.repository;



import mk.ukim.finki.dians.model.Clinic;
import mk.ukim.finki.dians.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface Clinic_repository extends JpaRepository<Clinic, Long> {


    List<Clinic> findByNameIgnoreCaseContains(String text);


}
