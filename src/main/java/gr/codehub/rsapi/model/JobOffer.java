package gr.codehub.rsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String company;
    private String title;
    private LocalDate offerDate;
    private String region;
    private boolean isClosed;

    public boolean isClosed() {
        return isClosed;
    }

    public JobOffer setCompanyCust(String company) {
        this.company = company;
        return this;
    }

    public JobOffer setTitleCust(String title) {
        this.title = title;
        return this;
    }

    public JobOffer setRegionCust(String region) {
        this.region = region;
        return this;
    }

    public JobOffer setOfferDatecust(LocalDate offerDate) {
        this.offerDate = offerDate;
        return this;
    }

    @OneToMany(mappedBy = "jobOffer")
    private List<JobOfferSkill> jobOfferSkills ;

    @OneToMany(mappedBy = "jobOffer")
    private List<Match> matches ;



}
