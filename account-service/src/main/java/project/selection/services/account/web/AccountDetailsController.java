package project.selection.services.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import project.selection.services.account.service.AccountDetailsService;
import project.selection.services.account.service.dto.AccountDetailsDTO;
import project.selection.services.account.service.dto.AccountDetailsUpdateDTO;
import project.selection.services.account.service.event.AccountDetailsEvent;
import project.selection.services.account.service.event.CreateAccountDetailsEvent;
import project.selection.services.account.service.event.CreatedAccountDetailsEvent;
import project.selection.services.account.service.event.GetAccountDetailsByIdEvent;
import project.selection.services.account.service.event.RemoveAccountDetailsByIdEvent;
import project.selection.services.account.service.event.UpdateAccountDetailsEvent;
import project.selection.services.account.service.event.UpdatedAccountDetailsEvent;
import project.selection.services.account.web.domain.AccountDetailsRest;
import project.selection.services.account.web.domain.AccountDetailsUpdateRest;

@RestController
@RequestMapping("/accounts")
public class AccountDetailsController {

	@Autowired
	AccountDetailsService accountDetailsService;

	@Autowired
	UAAServiceProxy uaaService;

	@PostMapping
	public ResponseEntity<AccountDetailsDTO> create(@RequestBody AccountDetailsRest accountDetailsRest,
			UriComponentsBuilder builder) {
		CreateAccountDetailsEvent createEvent = new CreateAccountDetailsEvent(accountDetailsRest.to());
		CreatedAccountDetailsEvent createdEvent = accountDetailsService.create(createEvent);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/accounts/{id}")
				.buildAndExpand(String.valueOf(createdEvent.getAccountDetailsDTO().getId())).toUri());

		return new ResponseEntity<AccountDetailsDTO>(createdEvent.getAccountDetailsDTO(), headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AccountDetailsDTO> getById(@PathVariable("id") Long id) {
		GetAccountDetailsByIdEvent getByIdEvent = new GetAccountDetailsByIdEvent(id);
		AccountDetailsEvent accountEvent = accountDetailsService.getById(getByIdEvent);
		return new ResponseEntity<AccountDetailsDTO>(accountEvent.getAccountDetailsDTO(), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AccountDetailsDTO> update(@PathVariable("id") Long id,
			@RequestBody AccountDetailsUpdateRest accountDetailsUpdateRest) {
		AccountDetailsUpdateDTO accountDetailsUpdateDTO = accountDetailsUpdateRest.to();
		accountDetailsUpdateDTO.setId(id);
		UpdateAccountDetailsEvent updateEvent = new UpdateAccountDetailsEvent(accountDetailsUpdateDTO);
		UpdatedAccountDetailsEvent updatedEvent = accountDetailsService.update(updateEvent);
		return new ResponseEntity<AccountDetailsDTO>(updatedEvent.getAccountDetailsDTO(), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AccountDetailsDTO> removeById(@PathVariable("id") Long id) {
		RemoveAccountDetailsByIdEvent removeByIdEvent = new RemoveAccountDetailsByIdEvent(id);
		accountDetailsService.removeById(removeByIdEvent);
		return new ResponseEntity<AccountDetailsDTO>(HttpStatus.OK);
	}

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
