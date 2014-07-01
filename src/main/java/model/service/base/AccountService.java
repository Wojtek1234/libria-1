package model.service.base;

import model.dao.AccountDao;
import model.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

@Service
public class AccountService extends BaseService<Account, AccountDao>
{
	private AccountDao accountDao;

	public AccountService()
	{
	}

	@Override
	protected AccountDao getBaseDao()
	{
		return this.accountDao;
	}

	@Override
	@Transactional
	public Account create( String name )
	{
		return this.accountDao.save( new Account( name ) );
	}

	@Inject
	public void setAccountDao( AccountDao accountDao )
	{
		this.accountDao = accountDao;
	}
}
