package gr.codehub.rsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String address;
    private String region;
    private String email;
    private Date dob;
    private boolean inactive;

    /**
     *Fluent API in order to read properly the xls file
     *because from @Data annotations initialize 0 parameter setters and getters (void)
     */
    public Applicant setFirstNameCustom(String fName) {
        this.firstName = fName;
        return  this;
    }

    public Applicant  setLastNameCustom(String lName) {
        this.lastName = lName;
        return this;
    }

    public Applicant setAddressCustom(String address) {
        this.address = address;
        return this;
    }

    public Applicant setRegionCustom(String region) {
        this.region = region;
        return this;
    }

    public Applicant setEmailCustom(String email) {
        this.email = email;
        return this;
    }
    public Applicant setDobCustom(Date dob) {
        this.dob = dob;
        return this;
    }

    @OneToMany(mappedBy = "applicant")
    private List<ApplicantSkill> applicantSkills;

    @OneToMany(mappedBy = "applicant")
    private List<Match> matches;
}
