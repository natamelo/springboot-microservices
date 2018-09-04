package project.selection.services.account.service.event;

import project.selection.services.account.service.dto.AccountDetailsDTO;

public class CreatedAccountDetailsEvent extends AccountDetailsEvent {

	public CreatedAccountDetailsEvent(AccountDetailsDTO accountDetailsDTO) {
		super(accountDetailsDTO);
	}

}
