package rs.ac.uns.ftn.agent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import megatravel.data.xsd.AccommodationFacility;
import rs.ac.uns.ftn.soap.ReservationClient;

@Configuration
public class WSConfig {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		
		Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
		String[] packagesToScan= {"megatravel.data.xsd"};
		marshaller.setPackagesToScan(packagesToScan);
		return marshaller;
	}

	@Bean
	public ReservationClient resClient(Jaxb2Marshaller marshaller) {
		ReservationClient client=new ReservationClient();
		client.setDefaultUri("http://localhost:2222/ws/)");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
	

}
