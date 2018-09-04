package project.selection.services.account.service.event;

import project.selection.services.account.service.dto.AccountDetailsUpdateDTO;

public class UpdateAccountDetailsEvent {

	private AccountDetailsUpdateDTO accountDetailsUpdateDTO;

	public UpdateAccountDetailsEvent(AccountDetailsUpdateDTO accountDetailsUpdateDTO) {
		super();
		this.accountDetailsUpdateDTO = accountDetailsUpdateDTO;
	}

	public AccountDetailsUpdateDTO getAccountDetailsUpdateDTO() {
		return accountDetailsUpdateDTO;
	}

	public void setAccountDetailsUpdateDTO(AccountDetailsUpdateDTO accountDetailsUpdateDTO) {
		this.accountDetailsUpdateDTO = accountDetailsUpdateDTO;
	}

}
