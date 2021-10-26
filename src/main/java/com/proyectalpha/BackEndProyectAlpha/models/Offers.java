package com.proyectalpha.BackEndProyectAlpha.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;
import java.util.Date;

@Entity
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffers;
    private String enterpriseName;
    private String offerName;
    private String responsibility;
    private String requirements;
    private String summary;
    private Tecnologies[] tecnologies;
    private String direction;
    private Integer telephoneNumber;
    private String salary;
    private String modality;
    private Date date;

    public Offers() {
    }

    public Offers(Long idOffers, String enterpriseName, String offerName, String responsibility, String requirements, String summary, Tecnologies[] tecnologies, String direction, Integer telephoneNumber, String salary, String modality, Date date) {
        this.idOffers = idOffers;
        this.enterpriseName = enterpriseName;
        this.offerName = offerName;
        this.responsibility = responsibility;
        this.requirements = requirements;
        this.summary = summary;
        this.tecnologies = tecnologies;
        this.direction = direction;
        this.telephoneNumber = telephoneNumber;
        this.salary = salary;
        this.modality = modality;
        this.date = date;
    }

    public Long getIdOffers() {
        return idOffers;
    }

    public void setIdOffers(Long idOffers) {
        this.idOffers = idOffers;
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

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Tecnologies[] getTecnologies() {
        return tecnologies;
    }

    public void setTecnologies(Tecnologies[] tecnologies) {
        this.tecnologies = tecnologies;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
