package project.selection.services.account.service.event;

public class GetAccountDetailsByLoginEvent {

	private String login;

	public GetAccountDetailsByLoginEvent(String login) {
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
