package controller;

import model.entity.base.BaseEntity;

import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public class SimpleEntityTableModel<T extends BaseEntity> extends BasicTableModel<T>
{
	private static final long serialVersionUID = 1L;

	public SimpleEntityTableModel( List<T> objectList )
	{
		super( objectList );
	}

	@Override
	public int getColumnCount()
	{
		return 4;
	}

	@Override
	public String getColumnName( int columnIndex )
	{
		switch( columnIndex )
		{
			case 0:
			{
				return "NR";
			}
			case 1:
			{
				return "Nazwa";
			}
			case 2:
			{
				return "Stworzony";
			}
			case 3:
			{
				return "Modyfikowany";
			}
			default:
				break;

		}
		return null;
	}

	@Override
	public Object getValueAt( int rowIndex, int columnIndex )
	{
		{
			for( int i = 0; i < rowIndex + 1; i++ )
			{
				switch( columnIndex )
				{
					case 0:
					{
						return Integer.valueOf( rowIndex + 1 );
					}
					case 1:
					{
						return this.objectList.get( rowIndex ).getName();
					}
					case 2:
					{
						if( this.objectList.get( rowIndex ).getCreated() == null )
						{
							return "--OCZEKUJE--";
						}
						return this.objectList.get( rowIndex ).getStringCreatedDate();
					}
					case 3:
					{
						if( this.objectList.get( rowIndex ).getCreated() == null )
						{
							return "--OCZEKUJE--";
						}
						return this.objectList.get( rowIndex ).getStringModifiedDate();
					}
					default:
						break;
				}
			}
			return null;
		}
	}

	@Override
	public boolean isCellEditable( int row, int col )
	{
		return col == 1;
	}

	@Override
	public void setValueAt( Object aValue, int rowIndex, int columnIndex )
	{
		final T object = this.objectList.get( rowIndex );
		object.setName( aValue.toString() );
	}
}
