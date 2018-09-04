package project.selection.services.account.web.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.BeanUtils;

import project.selection.services.account.service.dto.AccountDetailsDTO;

@XmlRootElement
public class AccountDetailsRest {

	private Long id;

	private String name;

	private String login;

	private String email;

	private String password;

	public AccountDetailsRest() {
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

	public static AccountDetailsRest from(AccountDetailsDTO accountDetailsDTO) {
		AccountDetailsRest accountDetailsRest = new AccountDetailsRest();
		BeanUtils.copyProperties(accountDetailsDTO, accountDetailsRest);
		return accountDetailsRest;
	}

}
