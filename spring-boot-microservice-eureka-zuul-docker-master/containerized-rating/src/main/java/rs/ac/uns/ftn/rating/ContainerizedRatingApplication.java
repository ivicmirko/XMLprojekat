package rs.ac.uns.ftn.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ContainerizedRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContainerizedRatingApplication.class, args);
	}
}
