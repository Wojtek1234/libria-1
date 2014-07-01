package model.service.base;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

@Service
public interface SimpleService<T>
{
	T create( String name );

	List<T> getAll();

	T getById( Long id );

	T getByName( String name );

	void refresh( List<T> entityList );

	void remove( T entity );

	boolean contains( T entity );
}
