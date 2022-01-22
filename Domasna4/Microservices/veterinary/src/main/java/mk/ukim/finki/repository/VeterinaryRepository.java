package mk.ukim.finki.repository;

import mk.ukim.finki.entity.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface VeterinaryRepository extends JpaRepository<Veterinary, Long> {

    List<Veterinary> findByNameIgnoreCaseContains(String text);
}
