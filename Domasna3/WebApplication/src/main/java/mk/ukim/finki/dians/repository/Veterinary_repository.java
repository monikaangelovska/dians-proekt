package mk.ukim.finki.dians.repository;



import mk.ukim.finki.dians.model.Pharmacy;
import mk.ukim.finki.dians.model.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface Veterinary_repository extends JpaRepository<Veterinary, Long> {


    List<Veterinary> findByNameIgnoreCaseContains(String text);

}
