package model.service;

import model.service.base.AccountService;
import model.service.base.AuthorService;
import model.service.base.CategoryService;
import model.service.base.RoomService;

import javax.inject.Inject;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public final class LibriaServiceBean
{
	private BookService bookService;
	private AuthorService authorService;
	private CategoryService categoryService;
	private AccountService accountService;
    private RoomService roomService;

    public BookService getBookService()
    {
        return this.bookService;
    }

	@Inject
	public void setBookService( BookService bookService )
	{
		this.bookService = bookService;
	}
	public AuthorService getAuthorService()
	{
		return this.authorService;
	}

    @Inject
	public void setAuthorService( AuthorService authorService )
	{
		this.authorService = authorService;
	}
	public CategoryService getCategoryService()
	{
		return this.categoryService;
	}

    @Inject
	public void setCategoryService( CategoryService categoryService )
	{
		this.categoryService = categoryService;
	}
	public AccountService getAccountService()
	{
		return this.accountService;
	}

    @Inject
	public void setAccountService( AccountService accountService )
	{
		this.accountService = accountService;
	}

    public RoomService getRoomService()
    {
        return this.roomService;
    }

    @Inject
    public void setRoomService(RoomService roomService)
    {
        this.roomService = roomService;
    }
}
