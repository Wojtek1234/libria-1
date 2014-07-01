package model.service.base;

import model.dao.base.BaseDao;
import model.entity.base.BaseEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath:/test/beanConfiguration-test.xml" } )
@TransactionConfiguration( defaultRollback = false )
@Transactional
public abstract class AbstractBaseServiceTest<E extends BaseEntity, D extends BaseDao<E>, S extends BaseService<E, D>>
		implements BaseServiceTest
{

	public static final String TEST_ENTITY_NAME = "entity";

	protected abstract S getBaseService();

	@Before
	public void setUp()
	{
		this.createEntity(  TEST_ENTITY_NAME );
	}

	@Override
	@Test
	public void testCreateEntity()
	{
		final E entity = this.getBaseService().getByName( TEST_ENTITY_NAME );
		assertThat( entity.getName(), equalTo( TEST_ENTITY_NAME ) );
	}

	public E createEntity( String name )
	{
		return this.getBaseService().create( name );
	}

	@Override
	@Test
	public void testGetById()
	{
		final E entity = this.getBaseService().getAll().get( 0 );
		final E accountById = this.getBaseService().getById( entity.getId() );
		assertThat( entity.getId(), equalTo( accountById.getId() ) );
	}

	@Override
	@Test
	public void testGetByName()
	{
		final E entity = this.getBaseService().getByName( TEST_ENTITY_NAME );
		assertThat( entity.getName(), equalTo( TEST_ENTITY_NAME ) );
	}

	@After
	public void tearDown()
	{
		this.getBaseService().removeAll();
	}
}
