package model.dao;

import model.dao.base.BaseDao;
import model.entity.Category;
import org.springframework.stereotype.Repository;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@Repository
public final class CategoryDao extends BaseDao<Category>
{
	public CategoryDao( Class<Category> clazz )
	{
		super( clazz );
	}
}
