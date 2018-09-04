package project.selection.services.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	UAAServiceProxy uaaService;
	
	@GetMapping("/test")
	public String teste() {
		return "OK";
	}

	@PostMapping("/torada")
	public String torada(@RequestParam("access_token") String accessToken) {
		String entra = uaaService.entra(accessToken);
		return "OK: " + entra;
	}

}
