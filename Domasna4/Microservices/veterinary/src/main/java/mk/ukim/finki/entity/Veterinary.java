package mk.ukim.finki.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Comparator;

@Data
@Entity
@Table(name = "veterinaries")
public class Veterinary {
    @Id
    private Long id_veterinary;
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
    public static Comparator<Veterinary> compareByName = (Veterinary o1, Veterinary o2) -> o1.getName().compareTo(o2.getName());

        public Veterinary() {
        }

        public String getNamemk() {
            return namemk;
        }

        public Long getId() {
            return id_veterinary;
        }

        public void setId(Long id) {
            this.id_veterinary = id;
        }

        public Double getLon() {
            return lon;
        }

        public Double getLat() {
            return lat;
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

        public String getPhone() {
            return phone;
        }

        public String getDriveThrough() {
            return drive_through;
        }

        public String getOpenHours() {
            return opening_hours;
        }

        public String getEmail() {
            return email;
        }

        public String getBuilding() {
            return building;
        }

        public String getWheelchair() {
            return wheelchair;
        }
    }