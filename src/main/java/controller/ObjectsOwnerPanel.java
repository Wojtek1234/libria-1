package controller;

import javax.swing.JPanel;
import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public abstract class ObjectsOwnerPanel<T> extends JPanel implements ObjectsOwner<T>
{
	private static final long serialVersionUID = 1L;
	protected final List<T> objectList;

	public ObjectsOwnerPanel( List<T> objectList )
	{
		this.objectList = objectList;
	}

	public void accept()
	{
	}

	@Override
	public List<T> getObjects()
	{
		return this.objectList;
	}
}
