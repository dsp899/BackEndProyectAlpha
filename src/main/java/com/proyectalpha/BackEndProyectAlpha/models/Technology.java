package com.proyectalpha.BackEndProyectAlpha.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "technologies")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "technologies", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Offer> offers = new HashSet<>();

    public Technology() {
    }

    public Technology(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Offer> getOffers(){
        return offers;
    }

    public void addOffers(Offer offer) {
        offers.add(offer);
        offer.getTechnologies().add(this);
    }


    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technology that = (Technology) o;
        return id.equals(that.id);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
