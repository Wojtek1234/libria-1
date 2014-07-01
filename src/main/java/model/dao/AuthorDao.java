package model.dao;

import model.dao.base.BaseDao;
import model.entity.Author;
import org.springframework.stereotype.Repository;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@Repository
public final class AuthorDao extends BaseDao<Author>
{
	public AuthorDao( Class<Author> clazz )
	{
		super( clazz );
	}
}
