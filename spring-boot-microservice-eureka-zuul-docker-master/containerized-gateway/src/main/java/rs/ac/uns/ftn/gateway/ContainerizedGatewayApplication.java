package rs.ac.uns.ftn.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ContainerizedGatewayApplication
{
	
//	@Bean
//	public CorsFilter corsFilter() {
//	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    final CorsConfiguration config = new CorsConfiguration();
//	    config.setAllowCredentials(true);
//	    config.addAllowedOrigin("*");
//	    config.addAllowedHeader("*");
//	    config.addAllowedMethod("OPTIONS");
//	    config.addAllowedMethod("HEAD");
//	    config.addAllowedMethod("GET");
//	    config.addAllowedMethod("PUT");
//	    config.addAllowedMethod("POST");
//	    config.addAllowedMethod("DELETE");
//	    config.addAllowedMethod("PATCH");
//	    source.registerCorsConfiguration("/**", config);
//	    return new CorsFilter(source);
//	}
//	
//	 @Bean
//	 public RestTemplate template() throws Exception{
//		 RestTemplate template = new RestTemplate();
//		 return template;
//	 }
	public static void main(String[] args) {
		SpringApplication.run(ContainerizedGatewayApplication.class, args);
	}
}
