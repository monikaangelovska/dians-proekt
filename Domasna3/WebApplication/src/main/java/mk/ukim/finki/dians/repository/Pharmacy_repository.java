package mk.ukim.finki.dians.repository;



import mk.ukim.finki.dians.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface Pharmacy_repository extends JpaRepository<Pharmacy, Long> {


    List<Pharmacy> findByNameIgnoreCaseContains(String text);


}
