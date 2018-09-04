package project.selection.services.account.web.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.BeanUtils;

import project.selection.services.account.service.dto.AccountDetailsUpdateDTO;

@XmlRootElement
public class AccountDetailsUpdateRest {

	private String name;

	private String email;

	public AccountDetailsUpdateRest() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AccountDetailsUpdateDTO to() {
		AccountDetailsUpdateDTO accountDetailsDTO = new AccountDetailsUpdateDTO();
		BeanUtils.copyProperties(this, accountDetailsDTO);
		return accountDetailsDTO;
	}

}
