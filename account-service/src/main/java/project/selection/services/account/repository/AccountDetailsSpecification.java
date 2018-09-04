package project.selection.services.account.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import project.selection.services.account.repository.model.AccountDetails;

public class AccountDetailsSpecification implements Specification<AccountDetails> {

	private static final long serialVersionUID = -4164626273252089945L;

	@Override
	public Predicate toPredicate(Root<AccountDetails> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		return null;
	}

}
