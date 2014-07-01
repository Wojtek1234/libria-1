package model.service.base;

import model.dao.AuthorDao;
import model.entity.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@Service
public class AuthorService extends BaseService<Author, AuthorDao>
{
	private AuthorDao authorDao;

	@Override
	@Transactional
	public Author create( String name )
	{
		return this.authorDao.save( new Author( name ) );
	}

	@Inject
	public void setAuthorDao( AuthorDao authorDao )
	{
		this.authorDao = authorDao;
	}

	@Override
	public AuthorDao getBaseDao()
	{
		return this.authorDao;
	}
}
