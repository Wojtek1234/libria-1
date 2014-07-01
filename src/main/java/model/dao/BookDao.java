package model.dao;

import model.dao.base.BaseDao;
import model.entity.Book;
import org.springframework.stereotype.Repository;

/**
 * @author @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@Repository
public final class BookDao extends BaseDao<Book>
{
	public BookDao( Class<Book> clazz )
	{
		super( clazz );
	}

}
