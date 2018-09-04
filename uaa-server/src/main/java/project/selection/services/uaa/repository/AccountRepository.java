package project.selection.services.uaa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.selection.services.uaa.repository.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findOneByLoginAndPassword(String login, String password);
	
	Optional<Account> findOneByLogin(String login);

}
