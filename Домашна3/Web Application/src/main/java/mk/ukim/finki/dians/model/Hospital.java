package mk.ukim.finki.dians.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    private Long id_hospital;
    private Double lon;
    private Double lat;
    private String name;
    private String namemk;
    private String opening_hours;
    private String drive_through;
    private String building;
    private String email;
    private String phone;
    private String website;
    private String wheelchair;
    public Hospital() {
    }

    public void setNamemk(String namemk) {
        this.namemk = namemk;
    }

    public String getNamemk() {return namemk;}

    public Long getId() {
        return id_hospital;
    }

    public void setId(Long id) {
        this.id_hospital = id;
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

    public String getWebSite() {
        return website;
    }

    public void setWebSite(String webSite) {
        this.website = webSite;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriveThrough() {
        return drive_through;
    }

    public void setDriveThrough(String driveThrough) {
        this.drive_through = driveThrough;
    }

    public String getOpenHours() {
        return opening_hours;
    }

    public void setOpenHours(String openHours) {
        this.opening_hours = openHours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(String wheelchair) {
        this.wheelchair = wheelchair;
    }

}