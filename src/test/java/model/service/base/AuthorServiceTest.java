package model.service.base;

import model.dao.AuthorDao;
import model.entity.Author;

import javax.inject.Inject;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

public class AuthorServiceTest extends AbstractBaseServiceTest<Author, AuthorDao, AuthorService>
{
	@Inject
	private AuthorService authorService;

	@Override
	public AuthorService getBaseService()
	{
		return this.authorService;
	}
}
