package project.selection.services.account.service;

import project.selection.services.account.service.event.AccountDetailsEvent;
import project.selection.services.account.service.event.CreateAccountDetailsEvent;
import project.selection.services.account.service.event.CreatedAccountDetailsEvent;
import project.selection.services.account.service.event.GetAccountDetailsByIdEvent;
import project.selection.services.account.service.event.GetAccountDetailsByLoginEvent;
import project.selection.services.account.service.event.RemoveAccountDetailsByIdEvent;
import project.selection.services.account.service.event.SearchDetailsEvent;
import project.selection.services.account.service.event.SearchedDetailsEvent;
import project.selection.services.account.service.event.UpdateAccountDetailsEvent;
import project.selection.services.account.service.event.UpdatedAccountDetailsEvent;

public interface AccountDetailsService {

	CreatedAccountDetailsEvent create(CreateAccountDetailsEvent event);

	UpdatedAccountDetailsEvent update(UpdateAccountDetailsEvent event);

	AccountDetailsEvent getById(GetAccountDetailsByIdEvent event);

	void removeById(RemoveAccountDetailsByIdEvent event);

	SearchedDetailsEvent search(SearchDetailsEvent event);
	
	AccountDetailsEvent getByLogin(GetAccountDetailsByLoginEvent event);

}
