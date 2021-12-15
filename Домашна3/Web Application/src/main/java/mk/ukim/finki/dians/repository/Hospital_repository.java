package mk.ukim.finki.dians.repository;



import mk.ukim.finki.dians.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface Hospital_repository extends JpaRepository<Hospital, Long> {
    Optional<Hospital> findByName(String name);

    Optional<Hospital> findById(long id);

    //List<Clinic> findAll();

}
