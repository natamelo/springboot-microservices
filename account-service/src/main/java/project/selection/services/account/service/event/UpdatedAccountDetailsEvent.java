package project.selection.services.account.service.event;

import project.selection.services.account.service.dto.AccountDetailsDTO;

public class UpdatedAccountDetailsEvent extends AccountDetailsEvent {

	public UpdatedAccountDetailsEvent(AccountDetailsDTO accountDetailsDTO) {
		super(accountDetailsDTO);
	}

}
