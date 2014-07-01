package model.entity.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@MappedSuperclass
public abstract class IdentifiedEntity implements Identifier
{
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq" )
	private Long id;

	@Override
    public final Long getId()
	{
		return this.id;
	}

	@Override
    public final void setId( Long id )
	{
		this.id = id;
	}

}
