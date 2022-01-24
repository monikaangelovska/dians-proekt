package mk.ukim.finki.dians.VO;

import mk.ukim.finki.dians.model.Clinic;

public class WrapperClinic {
    Clinic clinic;

    public WrapperClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Clinic getClinic() {
        return clinic;
    }
}
