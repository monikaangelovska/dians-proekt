package mk.ukim.finki.dians.VO;

import mk.ukim.finki.dians.model.Clinic;
import mk.ukim.finki.dians.model.Hospital;

public class WrapperHospital {

    Hospital hospital;

    public Hospital getHospital() {
        return hospital;
    }

    public WrapperHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
