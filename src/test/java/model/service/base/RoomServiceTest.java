package model.service.base;

import model.dao.RoomDao;
import model.entity.Room;

import javax.inject.Inject;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

public class RoomServiceTest extends AbstractBaseServiceTest<Room, RoomDao, RoomService>
{
	@Inject
	private RoomService roomService;

	@Override
	public RoomService getBaseService()
	{
		return this.roomService;
	}
}
