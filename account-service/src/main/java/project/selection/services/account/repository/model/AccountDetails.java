package project.selection.services.account.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class AccountDetails {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(max = 128)
	private String name;

	@NotNull
	@Size(max = 128)
	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String login;

	@NotNull
	@Size(max = 254)
	@Column(unique = true)
	@Email
	private String email;

	public AccountDetails() {
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

}
