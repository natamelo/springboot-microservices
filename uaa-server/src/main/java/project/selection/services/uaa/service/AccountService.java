package project.selection.services.uaa.service;

import project.selection.services.uaa.service.event.AccountEvent;
import project.selection.services.uaa.service.event.CreateAccountEvent;
import project.selection.services.uaa.service.event.CreatedAccountEvent;
import project.selection.services.uaa.service.event.GetAccountByLoginAndPasswordEvent;
import project.selection.services.uaa.service.event.RemoveAccountByLogin;

public interface AccountService {

	CreatedAccountEvent create(CreateAccountEvent event);

	AccountEvent findByLoginAndPassword (GetAccountByLoginAndPasswordEvent event);

	void removeByLogin(RemoveAccountByLogin event);

}
