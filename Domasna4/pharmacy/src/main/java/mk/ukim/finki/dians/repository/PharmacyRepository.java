package mk.ukim.finki.dians.repository;

import mk.ukim.finki.dians.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    List<Pharmacy> findByNameIgnoreCaseContains(String text);
}
