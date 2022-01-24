package mk.finki.ukim.dians.hospital.repository;

import mk.finki.ukim.dians.hospital.VO.WrapperHospital;
import mk.finki.ukim.dians.hospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Hospitalrepository extends JpaRepository<Hospital, Long> {
    List<Hospital> findByNameIgnoreCaseContains(String text);
}
