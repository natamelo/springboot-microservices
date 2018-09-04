package project.selection.services.uaa.service.dto;

import org.springframework.beans.BeanUtils;

import project.selection.services.uaa.repository.model.Account;

public class AccountDTO {

	private Long id;

	private String login;

	private String password;

	public AccountDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static AccountDTO from(Account account) {
		AccountDTO dto = new AccountDTO();
		BeanUtils.copyProperties(account, dto);
		return dto;
	}

	public Account to() {
		Account account = new Account();
		BeanUtils.copyProperties(this, account);
		return account;
	}

}
