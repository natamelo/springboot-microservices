package project.selection.services.uaa.service;

import project.selection.services.uaa.service.event.AccountEvent;
import project.selection.services.uaa.service.event.CreateAccountEvent;
import project.selection.services.uaa.service.event.CreatedAccountEvent;
import project.selection.services.uaa.service.event.GetAccountByLoginAndPasswordEvent;
import project.selection.services.uaa.service.event.RemoveAccountByLogin;
import project.selection.services.uaa.service.exception.NotFoundException;

public interface AccountService {

	CreatedAccountEvent create(CreateAccountEvent event);

	AccountEvent findByLoginAndPassword (GetAccountByLoginAndPasswordEvent event) throws NotFoundException;

	void removeByLogin(RemoveAccountByLogin event);

}
