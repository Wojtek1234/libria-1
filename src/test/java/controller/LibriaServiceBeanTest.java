package controller;

import model.entity.Author;
import model.service.LibriaServiceBean;
import model.service.base.AuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath:/test/beanConfiguration-test.xml" } )
@Transactional
public class LibriaServiceBeanTest extends AbstractJUnit4SpringContextTests
{
	private static final String TEST_NAME = "name";

    //TODO all other beans test
	@Test
	public void testBean()
	{
		LibriaServiceBean libriaServiceBean = (LibriaServiceBean)this.applicationContext.getBean( "libriaServiceBean" );

		AuthorService authorService = libriaServiceBean.getAuthorService();
		authorService.create( TEST_NAME );
		Author author = authorService.getAll().get( 0 );
		assertThat( author.getName(), equalTo( TEST_NAME ) );

		authorService.removeAll();
	}
}
