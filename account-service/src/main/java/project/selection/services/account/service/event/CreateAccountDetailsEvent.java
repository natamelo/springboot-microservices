package project.selection.services.account.service.event;

import project.selection.services.account.service.dto.AccountDetailsDTO;

public class CreateAccountDetailsEvent extends AccountDetailsEvent {

	public CreateAccountDetailsEvent(AccountDetailsDTO accountDetailsDTO) {
		super(accountDetailsDTO);
	}

}
