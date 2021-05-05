package com.canteen.Fot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@SpringBootApplication
@RestController
public class FotApplication {

	public static void main(String[] args) {
		SpringApplication.run(FotApplication.class, args);
	}


}
