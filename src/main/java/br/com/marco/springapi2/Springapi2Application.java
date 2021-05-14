package br.com.marco.springapi2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springapi2Application implements CommandLineRunner{

public static final Logger LOG = LoggerFactory.getLogger(Springapi2Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Springapi2Application.class, args);
	}

	public void run(String... args) throws Exception {
		LOG.info("PROGRAMA ESTÁ INICIADO COM SUCESSO");
	}

}
