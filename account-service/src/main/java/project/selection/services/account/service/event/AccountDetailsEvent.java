package project.selection.services.account.service.event;

import project.selection.services.account.service.dto.AccountDetailsDTO;

public class AccountDetailsEvent {

	private AccountDetailsDTO accountDetailsDTO;

	public AccountDetailsEvent(AccountDetailsDTO accountDetailsDTO) {
		super();
		this.accountDetailsDTO = accountDetailsDTO;
	}

	public AccountDetailsDTO getAccountDetailsDTO() {
		return accountDetailsDTO;
	}

	public void setAccountDetailsDTO(AccountDetailsDTO accountDetailsDTO) {
		this.accountDetailsDTO = accountDetailsDTO;
	}

}
