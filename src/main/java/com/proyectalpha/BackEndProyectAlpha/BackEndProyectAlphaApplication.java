package com.proyectalpha.BackEndProyectAlpha;

import com.proyectalpha.BackEndProyectAlpha.models.Offers;
import com.proyectalpha.BackEndProyectAlpha.models.Tecnologies;
import com.proyectalpha.BackEndProyectAlpha.repositories.OffersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class BackEndProyectAlphaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BackEndProyectAlphaApplication.class, args);
		OffersRepository repository = context.getBean(OffersRepository.class);

		Tecnologies spring = new Tecnologies(null, "spring");
		Tecnologies[] array = {spring};



		Offers demoOffer;
		demoOffer = new Offers(null, "demoEnterprise", "demoOfferName", "TextAreaOffer", "TexAreaOffer", "TextAreaOffer", array, "direction", 666666666, "30k", "remoto", new Date());


		System.out.println(repository.findAll().size());
	}

}
