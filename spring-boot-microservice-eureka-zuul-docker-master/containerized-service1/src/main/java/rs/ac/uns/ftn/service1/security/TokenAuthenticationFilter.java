package rs.ac.uns.ftn.service1.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import rs.ac.uns.ftn.service1.model.SystemUser;





public class TokenAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authToken=getJwtFromRequest(request);
		System.out.println("Hopa cupa preko okucana "+ authToken);
		if(StringUtils.hasText(authToken)) {
			try {
				SystemUser userDetails=jwtTokenProvider.getSystemUser(authToken);
				System.out.println("mac"+userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("aaa neceee");
				e.printStackTrace();
			}
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String getJwtFromRequest(HttpServletRequest request){
        String token=request.getHeader("Buckuris");
        
        if(StringUtils.hasText(token))
        	return token;
        
//        if(StringUtils.hasText(token) && token.startsWith("Bearer ")){
//            return token.substring(7);
//        }

        return null;
    }

}
