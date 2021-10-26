package com.proyectalpha.BackEndProyectAlpha;

import com.proyectalpha.BackEndProyectAlpha.models.Offers;
import com.proyectalpha.BackEndProyectAlpha.models.Technologies;
import com.proyectalpha.BackEndProyectAlpha.repositories.OffersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class BackEndProyectAlphaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BackEndProyectAlphaApplication.class, args);
		OffersRepository repository = context.getBean(OffersRepository.class);


	}

}
