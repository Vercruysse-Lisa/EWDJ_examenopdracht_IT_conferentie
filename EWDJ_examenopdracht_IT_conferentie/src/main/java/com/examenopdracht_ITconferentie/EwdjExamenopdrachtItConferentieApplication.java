package com.examenopdracht_ITconferentie;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import validator.LokaalValidator;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("domain")
public class EwdjExamenopdrachtItConferentieApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(EwdjExamenopdrachtItConferentieApplication.class, args);	
	}

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
	   registry.addRedirectViewController("/", "/conferentieOverzicht");
    }
	
	@Bean
	LokaalValidator lokaalValidator() {
		return new LokaalValidator();
	}
	
	/*
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.forLanguageTag("nl"));
	    return slr;
	}
	*/
	
}
