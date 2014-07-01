package controller.book;

import controller.CRUDPanel;
import model.entity.Book;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */

public class BooksPanel extends CRUDPanel<Book>
{
	private static final long serialVersionUID = 1L;

	public BooksPanel( List<Book> booksList )
	{
		super( booksList );
	}

	@Override
	protected final void init()
	{
		super.init();

		JScrollPane scrollPane = new JScrollPane( this.table );
		this.add( scrollPane, BorderLayout.CENTER );
	}

	@Override
	protected final AbstractTableModel createTableModel( List<Book> bookList )
	{
		return new BooksTableModel( bookList );
	}

	@Override
	protected final JTable createTable( TableModel tableModel )
	{
		return new JTable( this.tableModel );
	}

	@Override
	protected final ActionListener addObjectActionListener()
	{
		return null; //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	protected final ActionListener editObjectActionListener()
	{
		return null; //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	protected final ActionListener removeObjectActionListener()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				if( BooksPanel.this.table.getSelectedRows().length == 1 )
				{
					final int selectedRow = BooksPanel.this.table.getSelectedRow();
                    BooksPanel.this.objectList.remove(selectedRow);
					BooksPanel.this.tableModel.fireTableDataChanged();
				}
			}
		};
	}

	@Override
	public List<Book> getObjects()
	{
		return this.objectList;
	}
}
