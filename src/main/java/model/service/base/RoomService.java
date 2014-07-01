package model.service.base;

import model.dao.RoomDao;
import model.entity.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
@Service
public class RoomService extends BaseService<Room, RoomDao>
{
	private RoomDao roomDao;

	@Override
	@Transactional
	public Room create( String name )
	{
		return this.roomDao.save( new Room( name ) );
	}

	@Inject
	public void setRoomDao( RoomDao roomDao )
	{
		this.roomDao = roomDao;
	}

	@Override
	public RoomDao getBaseDao()
	{
		return this.roomDao;
	}
}
