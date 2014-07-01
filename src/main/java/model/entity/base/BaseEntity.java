package model.entity.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@MappedSuperclass
public abstract class BaseEntity extends IdentifiedEntity implements Serializable, Cloneable, NameIdentifier
{
	/* serial version UID */
	private static final long serialVersionUID = 1L;

	@Column( nullable = false )
	@Temporal( TemporalType.TIMESTAMP )
	private Date created;
	@Column( nullable = false )
	@Temporal( TemporalType.TIMESTAMP )
	private Date modified;

	public final Date getCreated()
	{
		return this.created;
	}

	public final void setCreated( Date created )
	{
		this.created = created;
	}

	public final Date getModified()
	{
		return this.modified;
	}

	public final void setModified( Date modified )
	{
		this.modified = modified;
	}

	public final String getStringCreatedDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat( "dd MMM yyyy  HH:mm:ss" );
		return sdf.format( this.created );
	}

	public final String getStringModifiedDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat( "dd MMM yyyy  HH:mm:ss" );
		return sdf.format( this.modified );
	}

}
