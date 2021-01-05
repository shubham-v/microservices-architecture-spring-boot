package demo.architecture.miroservices.spring.boot.services.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceArchitectureDemoUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceArchitectureDemoUserServiceApplication.class, args);
	}

}
