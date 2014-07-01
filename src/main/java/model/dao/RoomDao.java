package model.dao;

import model.dao.base.BaseDao;
import model.entity.Room;
import org.springframework.stereotype.Repository;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@Repository
public final class RoomDao extends BaseDao<Room>
{
	public RoomDao( Class<Room> clazz )
	{
		super( clazz );
	}
}
