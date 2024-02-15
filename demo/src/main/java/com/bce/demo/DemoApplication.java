package com.bce.demo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	  private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	  
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
    @Autowired
    GreetingService srvc;
    
	@Bean
	  public CommandLineRunner demo(GreetingRepository repository) {
	    return (args) -> {
	    	
	    	//check new service works before by adding a record to see if it comes up
	    	Greeting g1 = new Greeting();
		      long lid = 12;
	    	g1.setSid(lid);
	    	g1.setContent("Happy");
	    	srvc.saveGreeting(g1);
	    	
	      // save a few customers
	    	lid = 1; 	
	      repository.save(new Greeting(lid, "Bauer"));

	      // fetch all customers
	      log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	      for (Greeting greeting : repository.findAll()) {
	        log.info(greeting.toString());
	      }
	      log.info("");

	      // fetch an individual customer by ID
	     Optional<Greeting> greeting = repository.findById(1L);
	      log.info("Customer found with findById(1L):");
	      log.info("--------------------------------");
	      log.info(greeting.toString());
	      log.info("");


	    };
	  }
}
