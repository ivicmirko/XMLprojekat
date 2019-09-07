package rs.ac.uns.ftn.service1.security;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import rs.ac.uns.ftn.service1.model.Authority;
import rs.ac.uns.ftn.service1.model.SystemUser;
import rs.ac.uns.ftn.service1.repository.UserRepository;


@Component
public class JwtTokenProvider {
	
	@Value("jwtAuthSecretKey")
	private String SECRET;
	
	@Value("864000")
	private int expiresIn;
	
	@Value("Authorization")
	private String AUTH_HEADER;
	
	@Autowired
	private TimeProvider timeProvider;
	
	@Autowired
	private UserRepository userRepository;
	
	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
	
	 public String generateToken(Authentication authentication){

	        SystemUser systemUser=(SystemUser) authentication.getPrincipal();
	        
	        System.out.println("Uzo principe"+systemUser.getUsername());
	        
	        Map<String,Object> additionalInfo=new HashMap<>();

	        additionalInfo.put("username",systemUser.getUsername());
	        additionalInfo.put("authorities",systemUser.getAuthorities().stream()
	    			.map(GrantedAuthority::getAuthority)
	    			.collect(Collectors.toList()));


	        return Jwts.builder()
	                .setClaims(additionalInfo)
	                .setSubject(systemUser.getId().toString())
	                .setIssuedAt(timeProvider.now())
	                .setExpiration(timeProvider.expiresDate(expiresIn))
	                .setHeaderParam("typ","JWT")
	                .signWith(SIGNATURE_ALGORITHM,SECRET)
	                .compact();
	    }

	    public String getIdFromClaims(Claims claims){
	        return claims.getSubject();
	    }

	    public String getUsernameFromClaims(Claims claims){
	        return (String) claims.get("username");
	    }

	    

	    public Claims getClaimsFromToken(String token) throws Exception{

	        return Jwts.parser()
	                .setSigningKey(SECRET)
	                .parseClaimsJws(token)
	                .getBody();

	    }

	    public SystemUser getSystemUser(String jwtToken){
	        try {
	            Claims claims=getClaimsFromToken(jwtToken);
	            //SystemUser user=userRepository.findOneById(Long.parseLong(getIdFromClaims(claims)));
	            //List<Authority> aut=getAuthoritiesFromClaims(claims).stream().map(Authority::new).collect(Collectors.toList());
	            return new SystemUser(Long.parseLong(getIdFromClaims(claims)),getUsernameFromClaims(claims),getAuthoritiesFromClaims(claims));
//	            return user;
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
	    @SuppressWarnings("unchecked")
	    public List<GrantedAuthority> getAuthoritiesFromClaims(Claims claims){
//	    	return (List<Authority>) claims.get("authorities");
	    	List<String> authorities = (List<String>) claims.get("authorities");			
			return authorities.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	    }
	
}
