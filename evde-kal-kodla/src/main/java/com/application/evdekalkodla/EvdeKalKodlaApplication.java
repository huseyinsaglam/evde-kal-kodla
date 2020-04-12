package com.application.evdekalkodla;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EvdeKalKodlaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvdeKalKodlaApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper()
	{
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return new ModelMapper();
	}

}
