package rs.ac.uns.ftn.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ContainerizedAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContainerizedAdminApplication.class, args);
	}
}
