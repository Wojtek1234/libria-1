package model.service.base;

import model.dao.CategoryDao;
import model.entity.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@Service
public class CategoryService extends BaseService<Category, CategoryDao>
{
	private CategoryDao categoryDao;

	@Override
	@Transactional
	public Category create( String name )
	{
		return this.categoryDao.save( new Category( name ) );
	}

	@Inject
	public void setCategoryDao( CategoryDao categoryDao )
	{
		this.categoryDao = categoryDao;
	}

	@Override
	public CategoryDao getBaseDao()
	{
		return this.categoryDao;
	}
}
