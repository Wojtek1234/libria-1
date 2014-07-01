package model.entity;

import model.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

@Entity
@Table( name = "book" )
@SequenceGenerator( name = "seq", sequenceName = "seq_book" )
@AttributeOverrides( { @AttributeOverride( name = "id", column = @Column( name = "book_id" ) ),
		@AttributeOverride( name = "created", column = @Column( name = "book_created" ) ),
		@AttributeOverride( name = "modified", column = @Column( name = "book_modified" ) ) } )
public final class Book extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@ManyToOne( targetEntity = Account.class, cascade = CascadeType.MERGE)
	@JoinColumn( name = "book_account_id" )
	private Account account;

	@ManyToOne( targetEntity = Author.class )
	@JoinColumn( name = "book_author_id" )
	private Author author;

	@ManyToOne( targetEntity = Category.class )
	@JoinColumn( name = "book_category_id" )
	private Category category;

	@ManyToOne( targetEntity = Room.class )
	@JoinColumn( name = "book_room_id" )
	private Room room;

	@Column( name = "book_name" )
	private String name;

	public Book()
	{
	}

	public Book( String name, Account account, Author author, Category category, Room room )
	{
		this.name = name;
		this.account = account;
		this.author = author;
		this.category = category;
		this.room = room;
	}

	public final Account getAccount()
	{
		return this.account;
	}

	public final void setAccount( Account account )
	{
		this.account = account;
	}

	public final Author getAuthor()
	{
		return this.author;
	}

	public final void setAuthor( Author author )
	{
		this.author = author;
	}

	public final Category getCategory()
	{
		return this.category;
	}

	public final void setCategory( Category category )
	{
		this.category = category;
	}

	@Override
	public final String getName()
	{
		return this.name;
	}

	@Override
	public final void setName( String name )
	{
		this.name = name;
	}

	public final Room getRoom()
	{
		return this.room;
	}

	public final void setRoom( Room room )
	{
		this.room = room;
	}

	@Override
	public final boolean equals( Object object )
	{
		if( !(object instanceof Book) )
			return false;
		final Book book = (Book)object;
		return book.getName().equals( this.name ) && book.getId().equals( this.getId() )
				&& book.getAccount().equals( this.getAccount() ) && book.getAuthor().equals( this.getAuthor() )
				&& book.getCategory().equals( this.getCategory() ) && book.getRoom().equals( this.getRoom() )
				&& book.getCreated().equals( this.getCreated() ) && book.getModified().equals( this.getModified() );
	}

	@Override
	public final int hashCode()
	{
		int result;
		result = 20;
		result = 34 * result + this.getId().intValue();
		return result;
	}

	@Override
	public final String toString()
	{
		return String.format( "%1$s %2$s %2$s %3$s", this.getId(), this.getName(), this.getCreated(),
				this.getModified() );
	}
}
