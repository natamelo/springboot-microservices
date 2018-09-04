package project.selection.services.uaa.service.event;

import project.selection.services.uaa.service.dto.AccountDTO;

public class CreateAccountEvent extends AccountEvent {

	public CreateAccountEvent(AccountDTO accountDTO) {
		super(accountDTO);
	}

}
