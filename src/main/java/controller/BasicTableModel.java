package controller;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public abstract class BasicTableModel<T> extends AbstractTableModel
{
	protected final List<T> objectList;

	private static final long serialVersionUID = 1L;

	protected BasicTableModel( List<T> objectList )
	{
		this.objectList = objectList;
	}

	@Override
	public int getRowCount()
	{
		return this.objectList.size();
	}

	@Override
	abstract public int getColumnCount();

	@Override
	abstract public Object getValueAt( int rowIndex, int columnIndex );
}
