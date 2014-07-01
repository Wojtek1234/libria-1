package controller.book;

import model.entity.Book;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public class BooksTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private final List<Book> bookList;

	public BooksTableModel( List<Book> bookList )
	{
		this.bookList = bookList;
	}

	@Override
	public int getRowCount()
	{
		return this.bookList.size();
	}

	@Override
	public int getColumnCount()
	{
		return 8;
	}

	@Override
	public String getColumnName( int columnIndex )
	{
		switch( columnIndex )
		{
			case 0:
			{
				return "id";
			}
			case 1:
			{
				return "Nazwa";
			}
			case 2:
			{
				return "Autor";
			}
			case 3:
			{
				return "Kategoria";
			}
			case 4:
			{
				return "Pokój";
			}
			case 5:
			{
				return "Dodane przez";
			}
			case 6:
			{
				return "Stworzony";
			}
			case 7:
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
					return this.bookList.get( rowIndex ).getName();
				}
				case 2:
				{
					return this.bookList.get( rowIndex ).getAuthor().getName();
				}
				case 3:
				{
					return this.bookList.get( rowIndex ).getCategory().getName();
				}
				case 4:
				{
					return this.bookList.get( rowIndex ).getRoom().getName();
				}
				case 5:
				{
					return this.bookList.get( rowIndex ).getAccount().getName();
				}
				case 6:
				{
					return this.bookList.get( rowIndex ).getStringCreatedDate();
				}
				case 7:
				{
					return this.bookList.get( rowIndex ).getStringModifiedDate();
				}
				default:
					break;
			}
		}
		return null;
	}

	@Override
	public boolean isCellEditable( int row, int col )
	{
		return col == 1;
	}

	@Override
	public void setValueAt( Object aValue, int rowIndex, int columnIndex )
	{
		Book book = this.bookList.get( rowIndex );
		book.setName( aValue.toString() );
	}

}
