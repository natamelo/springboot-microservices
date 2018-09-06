package project.selection.services.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import project.selection.services.account.repository.model.AccountDetails;

@Repository
public interface AccountDetailsRepository
		extends JpaRepository<AccountDetails, Long>, JpaSpecificationExecutor<AccountDetails> {

	Optional<AccountDetails> findOneByLogin(String login);

}
