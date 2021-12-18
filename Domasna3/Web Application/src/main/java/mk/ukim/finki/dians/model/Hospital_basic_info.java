package mk.ukim.finki.dians.model;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Immutable
@Table(name = "bolnici_basic_info")
public class Hospital_basic_info {
    @Id
    private Long id_clinic;
    private Double lon;
    private Double lat;
    private String name;


    public Hospital_basic_info() {
    }


    public Long getId() {
        return id_clinic;
    }

    public void setId(Long id) {
        this.id_clinic = id;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
