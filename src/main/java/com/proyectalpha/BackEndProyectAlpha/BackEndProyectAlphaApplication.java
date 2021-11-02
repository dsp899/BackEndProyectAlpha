package com.proyectalpha.BackEndProyectAlpha;

import com.proyectalpha.BackEndProyectAlpha.models.Offer;
import com.proyectalpha.BackEndProyectAlpha.models.Technology;
import com.proyectalpha.BackEndProyectAlpha.repositories.OffersRepository;
import com.proyectalpha.BackEndProyectAlpha.repositories.TechnologyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.*;

@SpringBootApplication
public class BackEndProyectAlphaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BackEndProyectAlphaApplication.class, args);
		TechnologyRepository techRepository = context.getBean(TechnologyRepository.class);
		OffersRepository offerRepository = context.getBean(OffersRepository.class);
		Technology techBean = context.getBean(Technology.class);
		Technology techBean1 = context.getBean(Technology.class);
		List<Technology> techBeans = new ArrayList<>();
		techBeans.add(techBean);
		techBeans.add(techBean1);

		techBean.setName("javascript");

		techBean1.setName("react");

		//Configuration demoConfig = new Configuration(null, "demoSalary", "remoto", new Date(), "demoLocation");
		//Technology demoTech = new Technology(null, "javascript");
		Technology demoTech1 = new Technology(null, "react");
		Technology demoTechNew = new Technology(null, "javascript");

		Offer demoOffers = new Offer(null, "demoEnterprise", "demoOffer", "demoResponsibility", "demoRequeriments", "demoSummary", "demoSalary", "demoModality", new Date(), "demoLocation");
		Offer demoOffers1 = new Offer(null, "demoEnterprise1", "demoOffer1", "demoResponsibility1", "demoRequeriments1", "demoSummary1", "demoSalary1", "demoModality1", new Date(), "demoLocation1");
		Offer demoOffersNew = new Offer(null, "demoEnterpriseNew", "demoOfferNew", "demoResponsibilityNew", "demoRequerimentsNew", "demoSummaryNew", "demoSalaryNew", "demoModalityNew", new Date(), "demoLocationNew");

		demoOffers.addTechnologies(techBean);
		demoOffers1.addTechnologies(techBean);
		demoOffers1.addTechnologies(techBean1);
		demoOffersNew.addTechnologies(demoTechNew);
		demoOffersNew.deleteTechnologies();
		for(int i = 0; i < techBeans.size(); i++) {
			demoOffersNew.addTechnologies(techBeans.get(i));
		}

		offerRepository.save(demoOffers);
		offerRepository.save(demoOffers1);
		offerRepository.save(demoOffersNew);

		System.out.println(offerRepository.findAll().size());
		System.out.println("Llega nueva oferta");

		/*List<Technology> technologiesCopia = demoOffersNew.getTechnologies();
		//demoOffersNew.deleteTechnologies();
		System.out.println("Nº Beans: "+techBeans.size());
		System.out.println("Nº Technologies: "+technologies.size());
		for(int i = 0; i < techBeans.size(); i++){
			if(techBeans.get(i).getName().equals(technologies.get(0).getName())){
				demoOffersNew.addTechnologies(techBeans.get(i));

			}
		}*/
		offerRepository.save(demoOffersNew);

	}

}
