package bondsDashboard.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication   
@EnableAutoConfiguration
@EnableJpaRepositories("bondsDashboard.model")
@ComponentScan(basePackages="bondsDashboard")
@EntityScan(basePackages="bondsDashboard.model")
public class BondsDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BondsDashboardApplication.class, args);
	}

}
