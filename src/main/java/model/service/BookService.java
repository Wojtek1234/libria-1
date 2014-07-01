package model.service;

import model.dao.BookDao;
import model.entity.Account;
import model.entity.Author;
import model.entity.Book;
import model.entity.Category;
import model.entity.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@Service
public class BookService
{
	private BookDao bookDao;

	@Transactional
	public Book create( String name, Account account, Author author, Category category, Room room )
	{
		return this.bookDao.save( new Book( name, account, author, category, room ) );
	}

	public List<Book> getAll()
	{
		return this.bookDao.getAll();
	}

	public Book getById( Long id )
	{
		return this.bookDao.getById( id );
	}

	@Transactional
	public void removeById( long id )
	{
		this.bookDao.removeById( id );
	}

	@Transactional
	public void remove( Book book )
	{
		this.bookDao.remove( book );
	}

	@Inject
	public void setBookDao( BookDao bookDao )
	{
		this.bookDao = bookDao;
	}

	@Transactional
	public void refresh( List<Book> entityList )
	{
		for( Book entity : entityList )
		{
			this.bookDao.update( entity );
		}

		final List<Book> dbEntityList = this.bookDao.getAll();
		for( Book dbEntity : dbEntityList )
		{
			if( !entityList.contains( dbEntity ) )
			{
				this.bookDao.remove( dbEntity );
			}
		}
	}
}
