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
@Table( name = "category" )
@SequenceGenerator( name = "seq", sequenceName = "seq_category" )
@AttributeOverrides( { @AttributeOverride( name = "id", column = @Column( name = "category_id" ) ),
		@AttributeOverride( name = "created", column = @Column( name = "category_created" ) ),
		@AttributeOverride( name = "modified", column = @Column( name = "category_modified" ) ) } )
public final class Category extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Column( name = "category_name" )
	private String name;

	@OneToMany( mappedBy = "category" )
	private Set<Book> bookSet = new HashSet<>();

	public Category()
	{
	}

	public Category( String name )
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
		if( !(object instanceof Category) )
			return false;
		final Category category = (Category)object;
		return category.getName().equals( this.name ) && category.getId().equals( this.getId() )
				&& category.getCreated().equals( this.getCreated() )
				&& category.getModified().equals( this.getModified() );
	}

	@Override
	public final int hashCode()
	{
		int result;
		result = 20;
		result = 35 * result + this.getId().intValue();
		return result;
	}

	@Override
	public final String toString()
	{
		return String.format( "%1$s %2$s %2$s %3$s", this.getId(), this.getName(), this.getCreated(),
				this.getModified() );
	}
}
