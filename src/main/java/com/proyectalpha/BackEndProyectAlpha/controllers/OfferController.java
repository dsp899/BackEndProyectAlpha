package com.proyectalpha.BackEndProyectAlpha.controllers;

import com.proyectalpha.BackEndProyectAlpha.models.Offer;
import com.proyectalpha.BackEndProyectAlpha.models.Technology;
import com.proyectalpha.BackEndProyectAlpha.repositories.OffersRepository;
import com.proyectalpha.BackEndProyectAlpha.repositories.TechnologyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OfferController {

    private final Logger log = LoggerFactory.getLogger(OfferController.class);
    private TechnologyRepository techRepo;
    private OffersRepository offerRepo;
    //ApplicationContext context;
    //List<Technology> techBeans = new ArrayList<>();

    public OfferController(TechnologyRepository techRepo, OffersRepository offerRepo/*ApplicationContext context*/) {
        System.out.println("Hay contexto"/*context.getBeanDefinitionCount()*/);
        this.techRepo = techRepo;//context.getBean(TechnologyRepository.class);
        this.offerRepo = offerRepo;//context.getBean(OffersRepository.class);
        //this.context = context;
    }

    @GetMapping("/api/offers")
    public List<Offer> findAll(){
        return offerRepo.findAll();
    }

    @GetMapping("/api/offers/{id}")
    public ResponseEntity<Offer> findOneId(@PathVariable Long id){
        Optional<Offer> offerOpt = offerRepo.findById(id);
        if(offerOpt.isPresent()){
            return ResponseEntity.ok(offerOpt.get());
        } else {
            log.warn("The offer not exist");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/offers")
    public ResponseEntity<Offer> create(@RequestBody Offer offer) {
        /*System.out.println("Recibe Http");
        System.out.println(techBeans.isEmpty());
        if(techBeans.isEmpty()){
            System.out.println(offer.getTechnologies().size());
            for(int i = 0; i < offer.getTechnologies().size(); i++){
                techBeans.add(context.getBean(Technology.class));
                techBeans.get(i).setName(offer.getTechnologies().get(i).getName());
                System.out.println(techBeans.get(i).getName());
            }
            offer.deleteTechnologies();
            offer.setTechnologies(techBeans);
        }*/
        if (offer.getId() != null) {
            log.warn("Trying to create a offer with id not null");
            return ResponseEntity.badRequest().build();
        }

        for (Technology technology : offer.getTechnologies()) {
            if (technology.getId() != null) {
                log.warn("Trying to create a offer with id not null");
                return ResponseEntity.badRequest().build();
            }
        }

        return ResponseEntity.ok(offerRepo.save(offer));

    }

    @PutMapping("/api/offers")
    public ResponseEntity<Offer> update(@RequestBody Offer offer){
        if (offer.getId() == null) {
            log.warn("Trying to update a non existent offer");
            return ResponseEntity.badRequest().build();
        }

        else if(!offerRepo.existsById(offer.getId())) {
            log.warn("Trying to update a non existent offer");
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(offerRepo.save(offer));
        }
    }

    @DeleteMapping("/api/offers/{id}")
    public ResponseEntity<Offer> delete(@PathVariable Long id){
        if(!offerRepo.existsById(id)) {
            log.warn("Trying to delete a non existent offer");
            return ResponseEntity.notFound().build();
        }
        else {
            offerRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/api/offers")
    public ResponseEntity<Offer> deleteAll(){
        log.info("REST Request for Deleting all offers");
        offerRepo.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
