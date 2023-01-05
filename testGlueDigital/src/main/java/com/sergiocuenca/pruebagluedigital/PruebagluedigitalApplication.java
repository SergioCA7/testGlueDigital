package com.sergiocuenca.pruebagluedigital;

import com.sergiocuenca.controller.GeneralOrderController;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sergiocuenca"})
public class PruebagluedigitalApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(PruebagluedigitalApplication.class, args);
	}

}
