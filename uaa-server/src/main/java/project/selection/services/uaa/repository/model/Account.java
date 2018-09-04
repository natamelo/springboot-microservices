package project.selection.services.uaa.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(max = 128)
	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String login;

	@NotNull
	@NotEmpty
	@Size(max = 254)
	private String password;

	public Account() {
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

}
