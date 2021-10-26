package com.proyectalpha.BackEndProyectAlpha.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String enterpriseName;
    private String offerName;
    private String responsibility;
    private String requeriments;
    private String summary;

    @ManyToMany
    @JoinTable(name="Offers_has_Technologies"
            ,joinColumns = @JoinColumn(name="offers_id")
            ,inverseJoinColumns = @JoinColumn(name="tecnologies_id")
    )
    private Set<Technologies> tecnologies;

    @JoinColumn(name="configuration_id",unique = true)
    @OneToMany(cascade=CascadeType.ALL)
    private Configuration configuration;

    public Offers() {
    }

    public Offers(Long id, String enterpriseName, String offerName, String responsibility, String requeriments, String summary, Set<Technologies> tecnologies, Configuration configuration) {
        this.id = id;
        this.enterpriseName = enterpriseName;
        this.offerName = offerName;
        this.responsibility = responsibility;
        this.requeriments = requeriments;
        this.summary = summary;
        this.tecnologies = tecnologies;
        this.configuration = configuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getRequeriments() {
        return requeriments;
    }

    public void setRequeriments(String requeriments) {
        this.requeriments = requeriments;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Set<Technologies> getTecnologies() {
        return tecnologies;
    }

    public void setTecnologies(Set<Technologies> tecnologies) {
        this.tecnologies = tecnologies;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offers offers = (Offers) o;
        return id.equals(offers.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


