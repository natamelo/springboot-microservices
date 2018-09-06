package project.selection.services.uaa.config;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import project.selection.services.uaa.service.AccountService;
import project.selection.services.uaa.service.dto.AccountDTO;
import project.selection.services.uaa.service.event.GetAccountByLoginAndPasswordEvent;
import project.selection.services.uaa.service.exception.NotFoundException;

public class AuthProvider implements AuthenticationProvider {

	@Autowired
	AccountService accountService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Object credentials = authentication.getCredentials();
		String password = credentials.toString();
		String login = authentication.getName();
		
		validateAccount(login, password);

		Authentication auth = new UsernamePasswordAuthenticationToken(login, password,
				new LinkedList<GrantedAuthority>());

		return auth;
	}
	
	private void validateAccount (String login, String password) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setLogin(login);
		accountDTO.setPassword(password);

		GetAccountByLoginAndPasswordEvent event = new GetAccountByLoginAndPasswordEvent(accountDTO);
		
		try {
			accountService.findByLoginAndPassword(event);
		} catch (NotFoundException exception) {
			throw new BadCredentialsException("Authentication failed!");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
