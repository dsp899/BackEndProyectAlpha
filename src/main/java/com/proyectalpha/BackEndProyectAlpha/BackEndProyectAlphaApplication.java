package com.proyectalpha.BackEndProyectAlpha;

import com.proyectalpha.BackEndProyectAlpha.models.Offer;
import com.proyectalpha.BackEndProyectAlpha.models.Technology;
import com.proyectalpha.BackEndProyectAlpha.repositories.OffersRepository;
import com.proyectalpha.BackEndProyectAlpha.repositories.TechnologyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BackEndProyectAlphaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BackEndProyectAlphaApplication.class, args);
		OffersRepository offerRepository = context.getBean(OffersRepository.class);
		TechnologyRepository techRepository = context.getBean(TechnologyRepository.class);

		//Configuration demoConfig = new Configuration(null, "demoSalary", "remoto", new Date(), "demoLocation");
		Technology demoTech = new Technology(null, "javascript");
		Technology demoTech1 = new Technology(null, "react");


		System.out.println("Id technology created" + demoTech.getId());
		Offer demoOffers = new Offer(null, "demoEnterprise", "demoOffer", "demoResponsibility", "demoRequeriments", "demoSummary", "demoSalary", "demoModality", new Date(), "demoLocation");
		Offer demoOffers1 = new Offer(null, "demoEnterprise1", "demoOffer1", "demoResponsibility1", "demoRequeriments1", "demoSummary1", "demoSalary1", "demoModality1", new Date(), "demoLocation1");

		//offerRepository.save(demoOffers);
		//techRepository.save(demoTech);
		//techRepository.save(demoTech1);
		/*
		//SE UTILIZA EL OFFER REPOSITORY
		System.out.println(offerRepository.findAll().size());
		demoOffers.addTechnologies(demoTech);
		demoOffers.addTechnologies(demoTech1);
		demoOffers1.addTechnologies(demoTech);
		demoOffers1.addTechnologies(demoTech1);
		offerRepository.save(demoOffers);
		offerRepository.save(demoOffers1);
		System.out.println(offerRepository.findAll().size());
		*/

		//SE UTILIZA EL TECHNOLOGY REPOSITORY
		System.out.println(techRepository.findAll().size());
		demoTech.addOffers(demoOffers);
		demoTech.addOffers(demoOffers1);
		demoTech1.addOffers(demoOffers);
		demoTech1.addOffers(demoOffers1);
		techRepository.save(demoTech);
		techRepository.save(demoTech1);

		//resultados obtenidos
		List<Technology> listTechnolgies = techRepository.findAll();
		for(Technology techIter : listTechnolgies){
			for(Offer offerIter : techIter.getOffers()){
				System.out.println(techIter.getName() + " " + offerIter.getOfferName());
			}
		}

		//resultados obtenidos
		List<Offer> listOffers = offerRepository.findAll();
		for(Offer offerIter : listOffers){
			for(Technology techIter : offerIter.getTechnologies()){
				System.out.println(offerIter.getOfferName() + " " + techIter.getName());
			}
		}
		System.out.println(techRepository.findAll().size());


	}

}
