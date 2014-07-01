package model.entity;

import model.entity.base.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

@Entity
@Table( name = "account" )
@SequenceGenerator( name = "seq", sequenceName = "seq_account" )
@AttributeOverrides( { @AttributeOverride( name = "id", column = @Column( name = "account_id" ) ),
		@AttributeOverride( name = "created", column = @Column( name = "account_created" ) ),
		@AttributeOverride( name = "modified", column = @Column( name = "account_modified" ) ) } )
public final class Account extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Column( name = "account_name" )
	private String name;

	@OneToMany( mappedBy = "account", cascade = CascadeType.MERGE)
	private Set<Book> bookSet = new HashSet<>();

	public Account()
	{
		super();
	}

	public Account( String name )
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
		if( !(object instanceof Account) )
			return false;
		final Account account = (Account)object;
		return account.getName().equals( this.name ) && account.getId().equals( this.getId() )
				&& account.getCreated().equals( this.getCreated() )
				&& account.getModified().equals( this.getModified() );
	}

	@Override
	public final int hashCode()
	{
		int result;
		result = 18;
		result = 32 * result + this.getId().intValue();
		return result;
	}

	@Override
	public final String toString()
	{
		return String.format( "%1$s %2$s %2$s %3$s", this.getId(), this.getName(), this.getCreated(),
				this.getModified() );
	}
}
