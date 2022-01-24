package mk.finki.ukim.dians.hospital.VO;

import mk.finki.ukim.dians.hospital.entity.Hospital;

import java.util.Optional;

public class WrapperHospital {

    Optional<Hospital> hospital;

    public WrapperHospital(Hospital hospital) {
        this.hospital = Optional.of(hospital);
    }

}
