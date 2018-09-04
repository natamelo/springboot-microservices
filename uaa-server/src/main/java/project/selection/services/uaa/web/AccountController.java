package project.selection.services.uaa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import project.selection.services.uaa.service.AccountService;
import project.selection.services.uaa.service.dto.AccountDTO;
import project.selection.services.uaa.service.event.CreateAccountEvent;
import project.selection.services.uaa.service.event.CreatedAccountEvent;
import project.selection.services.uaa.service.event.RemoveAccountByLogin;
import project.selection.services.uaa.web.domain.AccountRest;

@RestController
// @RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping(value = "/create")
	public ResponseEntity<AccountDTO> create(@RequestBody AccountRest accountRest, UriComponentsBuilder builder) {
		CreateAccountEvent createEvent = new CreateAccountEvent(accountRest.to());
		CreatedAccountEvent createdEvent = accountService.create(createEvent);
		return new ResponseEntity<AccountDTO>(createdEvent.getAccountDTO(), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{login}")
	public ResponseEntity<AccountDTO> removeByLogin(@PathVariable("login") String login) {
		RemoveAccountByLogin removeEvent = new RemoveAccountByLogin(login);
		accountService.removeByLogin(removeEvent);
		return new ResponseEntity<AccountDTO>(HttpStatus.OK);
	}
}
