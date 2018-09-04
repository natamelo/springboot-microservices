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
import project.selection.services.uaa.service.event.AccountEvent;
import project.selection.services.uaa.service.event.GetAccountByLoginAndPasswordEvent;

public class AuthProvider implements AuthenticationProvider {

	@Autowired
	AccountService accountService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String login = authentication.getName();
		Object credentials = authentication.getCredentials();

		String password = credentials.toString();

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setLogin(login);
		accountDTO.setPassword(password);

		GetAccountByLoginAndPasswordEvent event = new GetAccountByLoginAndPasswordEvent(accountDTO);
		AccountEvent accountEvent = accountService.findByLoginAndPassword(event);

		if (accountEvent.getAccountDTO() == null) {
			throw new BadCredentialsException("Authentication failed!");
		}

		Authentication auth = new UsernamePasswordAuthenticationToken(login, password,
				new LinkedList<GrantedAuthority>());

		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
