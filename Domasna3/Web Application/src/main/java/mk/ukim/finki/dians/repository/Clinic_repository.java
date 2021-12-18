package mk.ukim.finki.dians.repository;



import mk.ukim.finki.dians.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface Clinic_repository extends JpaRepository<Clinic, Long> {
    Optional<Clinic> findByName(String name);

    Optional<Clinic> findById(long id);

    //List<Clinic> findAll();

}
