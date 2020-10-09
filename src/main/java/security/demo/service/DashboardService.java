package security.demo.service;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

	public void securityTest(){
		Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		Object credentials = authentication.getCredentials();
		Collection<? extends GrantedAuthority>  grantedAuthorities = authentication.getAuthorities();
	}
}
