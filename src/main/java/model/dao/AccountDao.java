package model.dao;

import model.dao.base.BaseDao;
import model.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@Repository
public final class AccountDao extends BaseDao<Account>
{
	public AccountDao( Class<Account> clazz )
	{
		super( clazz );
	}

}
