package project.selection.services.account.service.event;

public class AccountDetailsByIdEvent {

	private Long id;

	public AccountDetailsByIdEvent(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
