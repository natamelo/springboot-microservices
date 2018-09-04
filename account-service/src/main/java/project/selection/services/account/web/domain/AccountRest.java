package project.selection.services.account.web.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.BeanUtils;

import project.selection.services.account.service.dto.AccountDetailsDTO;

@XmlRootElement
public class AccountRest {

	private String login;

	private String password;

	public AccountRest() {
		super();
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

	public AccountDetailsDTO to() {
		AccountDetailsDTO accountDetailsDTO = new AccountDetailsDTO();
		BeanUtils.copyProperties(this, accountDetailsDTO);
		return accountDetailsDTO;
	}

	public static AccountRest from(AccountDetailsDTO accountDetailsDTO) {
		AccountRest accountDetailsRest = new AccountRest();
		BeanUtils.copyProperties(accountDetailsDTO, accountDetailsRest);
		return accountDetailsRest;
	}

}
