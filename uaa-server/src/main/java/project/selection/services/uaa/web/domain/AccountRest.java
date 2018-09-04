package project.selection.services.uaa.web.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.BeanUtils;

import project.selection.services.uaa.service.dto.AccountDTO;

@XmlRootElement
public class AccountRest {

	private Long id;

	private String login;

	private String password;

	public AccountRest() {
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

	public AccountDTO to() {
		AccountDTO accountDTO = new AccountDTO();
		BeanUtils.copyProperties(this, accountDTO);
		return accountDTO;
	}

	public static AccountRest from(AccountDTO accountDTO) {
		AccountRest accountRest = new AccountRest();
		BeanUtils.copyProperties(accountDTO, accountRest);
		return accountRest;
	}

}
