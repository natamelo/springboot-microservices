package project.selection.services.uaa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.selection.services.uaa.repository.AccountRepository;
import project.selection.services.uaa.repository.model.Account;
import project.selection.services.uaa.service.dto.AccountDTO;
import project.selection.services.uaa.service.event.AccountEvent;
import project.selection.services.uaa.service.event.CreateAccountEvent;
import project.selection.services.uaa.service.event.CreatedAccountEvent;
import project.selection.services.uaa.service.event.GetAccountByLoginAndPasswordEvent;
import project.selection.services.uaa.service.event.RemoveAccountByLogin;
import project.selection.services.uaa.service.exception.NotFoundException;
import project.selection.services.uaa.service.exception.NotFoundRunTimeException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository repository;

	@Override
	public CreatedAccountEvent create(CreateAccountEvent event) {
		Account account = event.getAccountDTO().to();
		AccountDTO accountDTO = AccountDTO.from(repository.save(account));
		return new CreatedAccountEvent(accountDTO);
	}

	@Override
	public AccountEvent findByLoginAndPassword(GetAccountByLoginAndPasswordEvent event) throws NotFoundException {
		AccountDTO accountDTO = event.getAccountDTO();
		Optional<Account> optional = repository.findOneByLoginAndPassword(accountDTO.getLogin(),
				accountDTO.getPassword());
		Account account = optional.orElseThrow(() -> new NotFoundException("Account not found!"));
		return new AccountEvent(AccountDTO.from(account));
	}

	@Override
	public void removeByLogin(RemoveAccountByLogin event) {
		Optional<Account> optional = repository.findOneByLogin(event.getLogin());
		Account account = optional.orElseThrow(() -> new NotFoundRunTimeException("Account not found!"));
		repository.deleteById(account.getId());
	}

}
