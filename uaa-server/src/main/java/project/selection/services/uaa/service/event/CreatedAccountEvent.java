package project.selection.services.uaa.service.event;

import project.selection.services.uaa.service.dto.AccountDTO;

public class CreatedAccountEvent extends AccountEvent {

	public CreatedAccountEvent(AccountDTO accountDTO) {
		super(accountDTO);
	}

}
