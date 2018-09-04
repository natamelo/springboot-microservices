package project.selection.services.uaa.service.event;

public class RemoveAccountByLogin {

	private String login;

	public RemoveAccountByLogin(String login) {
		super();
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
