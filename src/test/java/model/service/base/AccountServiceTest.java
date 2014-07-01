package model.service.base;

import model.dao.AccountDao;
import model.entity.Account;

import javax.inject.Inject;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

public class AccountServiceTest extends AbstractBaseServiceTest<Account, AccountDao, AccountService>
{
	@Inject
	private AccountService accountService;

	@Override
	public AccountService getBaseService()
	{
		return this.accountService;
	}
}
