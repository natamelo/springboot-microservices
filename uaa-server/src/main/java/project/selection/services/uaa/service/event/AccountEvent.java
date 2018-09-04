package project.selection.services.uaa.service.event;

import project.selection.services.uaa.service.dto.AccountDTO;

public class AccountEvent {

	private AccountDTO accountDTO;

	public AccountEvent(AccountDTO accountDTO) {
		super();
		this.accountDTO = accountDTO;
	}

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

}
