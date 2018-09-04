package project.selection.services.uaa.service.event;

import project.selection.services.uaa.service.dto.AccountDTO;

public class GetAccountByLoginAndPasswordEvent extends AccountEvent {

	public GetAccountByLoginAndPasswordEvent(AccountDTO accountDTO) {
		super(accountDTO);
	}

}
