package model.service.base;

import model.dao.CategoryDao;
import model.entity.Category;

import javax.inject.Inject;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

public class CategoryServiceTest extends AbstractBaseServiceTest<Category, CategoryDao, CategoryService>
{
	@Inject
	private CategoryService categoryService;

	@Override
	public CategoryService getBaseService()
	{
		return this.categoryService;
	}
}
