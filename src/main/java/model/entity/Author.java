package model.entity;

import model.entity.base.BaseEntity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

@Entity
@Table( name = "author" )
@SequenceGenerator( name = "seq", sequenceName = "seq_author" )
@AttributeOverrides( { @AttributeOverride( name = "id", column = @Column( name = "author_id" ) ),
		@AttributeOverride( name = "created", column = @Column( name = "author_created" ) ),
		@AttributeOverride( name = "modified", column = @Column( name = "author_modified" ) ) } )
public final class Author extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Column( name = "author_name" )
	private String name;

	@OneToMany( mappedBy = "author" )
	private Set<Book> bookSet = new HashSet<>();

	public Author()
	{
	}

	public Author( String name )
	{
		this.name = name;
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

	public final Set<Book> getBookSet()
	{
		return this.bookSet;
	}

	public final void setBookSet( Set<Book> bookSet )
	{
		this.bookSet = bookSet;
	}

	@Override
	public final boolean equals( Object object )
	{
		if( !(object instanceof Author) )
			return false;
		final Author author = (Author)object;

		return author.getName().equals( this.name ) && author.getId() != null && this.getId() != null
				&& author.getId().equals( this.getId() ) && author.getCreated() != null && this.getCreated() != null
				&& author.getCreated().equals( this.getCreated() ) && author.getModified() != null
				&& this.getModified() != null && author.getModified().equals( this.getModified() );
	}

	@Override
	public final int hashCode()
	{
		int result;
		result = 19;
		result = 33 * result + this.getId().intValue();
		return result;
	}

	@Override
	public final String toString()
	{
		return String.format( "%1$s %2$s %2$s %3$s", this.getId(), this.getName(), this.getCreated(),
				this.getModified() );
	}
}
