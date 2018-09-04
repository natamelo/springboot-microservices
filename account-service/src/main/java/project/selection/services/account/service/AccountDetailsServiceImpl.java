package project.selection.services.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.selection.services.account.repository.AccountDetailsRepository;
import project.selection.services.account.repository.model.AccountDetails;
import project.selection.services.account.service.dto.AccountDetailsDTO;
import project.selection.services.account.service.dto.AccountDetailsUpdateDTO;
import project.selection.services.account.service.event.AccountDetailsEvent;
import project.selection.services.account.service.event.CreateAccountDetailsEvent;
import project.selection.services.account.service.event.CreatedAccountDetailsEvent;
import project.selection.services.account.service.event.GetAccountDetailsByIdEvent;
import project.selection.services.account.service.event.RemoveAccountDetailsByIdEvent;
import project.selection.services.account.service.event.SearchDetailsEvent;
import project.selection.services.account.service.event.SearchedDetailsEvent;
import project.selection.services.account.service.event.UpdateAccountDetailsEvent;
import project.selection.services.account.service.event.UpdatedAccountDetailsEvent;

@Service
@Transactional
public class AccountDetailsServiceImpl implements AccountDetailsService {

	@Autowired
	AccountDetailsRepository repository;
	
	@Override
	public CreatedAccountDetailsEvent create(CreateAccountDetailsEvent event) {
		AccountDetails accountDetails = event.getAccountDetailsDTO().to();
		AccountDetailsDTO accountDetailsDTO = AccountDetailsDTO.from(repository.save(accountDetails));
		return new CreatedAccountDetailsEvent(accountDetailsDTO);
	}

	@Override
	public UpdatedAccountDetailsEvent update(UpdateAccountDetailsEvent event) {
		AccountDetailsUpdateDTO accountDetailsUpdateDTO = event.getAccountDetailsUpdateDTO();
		AccountDetails accountDetails = repository.getOne(accountDetailsUpdateDTO.getId());
		accountDetails.setName(accountDetailsUpdateDTO.getName());
		accountDetails.setEmail(accountDetailsUpdateDTO.getEmail());
		AccountDetailsDTO accountDetailsDTO = AccountDetailsDTO.from(repository.save(accountDetails));
		return new UpdatedAccountDetailsEvent(accountDetailsDTO);
	}

	@Override
	public AccountDetailsEvent getById(GetAccountDetailsByIdEvent event) {
		AccountDetails accountDetails = repository.getOne(event.getId());
		AccountDetailsDTO accountDetailsDTO = AccountDetailsDTO.from(accountDetails);
		return new AccountDetailsEvent(accountDetailsDTO);
	}

	@Override
	public void removeById(RemoveAccountDetailsByIdEvent event) {
		repository.deleteById(event.getId());
	}

	@Override
	public SearchedDetailsEvent search(SearchDetailsEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
