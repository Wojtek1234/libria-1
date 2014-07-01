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
@Table( name = "room" )
@SequenceGenerator( name = "seq", sequenceName = "seq_room" )
@AttributeOverrides( { @AttributeOverride( name = "id", column = @Column( name = "room_id" ) ),
		@AttributeOverride( name = "created", column = @Column( name = "room_created" ) ),
		@AttributeOverride( name = "modified", column = @Column( name = "room_modified" ) ) } )
public final class Room extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Column( name = "room_name" )
	private String name;

	@OneToMany( mappedBy = "room" )
	private Set<Book> bookSet = new HashSet<>();

	public Room()
	{
	}

	public Room( String name )
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
		if( !(object instanceof Room) )
			return false;
		final Room room = (Room)object;
		return room.getName().equals( this.name ) && room.getId().equals( this.getId() )
				&& room.getCreated().equals( this.getCreated() ) && room.getModified().equals( this.getModified() );
	}

	@Override
	public final int hashCode()
	{
		int result;
		result = 21;
		result = 36 * result + this.getId().intValue();
		return result;
	}

	@Override
	public final String toString()
	{
		return String.format( "%1$s %2$s %2$s %3$s", this.getId(), this.getName(), this.getCreated(),
				this.getModified() );
	}
}
