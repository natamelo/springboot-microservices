package project.selection.services.account.service.dto;

import org.springframework.beans.BeanUtils;

import project.selection.services.account.repository.model.AccountDetails;

public class AccountDetailsDTO {

	private Long id;

	private String name;

	private String login;

	private String email;

	public AccountDetailsDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static AccountDetailsDTO from(AccountDetails accountDetails) {
		AccountDetailsDTO dto = new AccountDetailsDTO();
		BeanUtils.copyProperties(accountDetails, dto);
		return dto;
	}

	public AccountDetails to() {
		AccountDetails accountDetails = new AccountDetails();
		BeanUtils.copyProperties(this, accountDetails);
		return accountDetails;
	}

}
