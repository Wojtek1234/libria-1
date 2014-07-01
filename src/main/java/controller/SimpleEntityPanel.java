package controller;

import model.entity.base.BaseEntity;

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
public class SimpleEntityPanel<T extends BaseEntity> extends CRUDPanel<T>
{
	private static final long serialVersionUID = 1L;

	public SimpleEntityPanel( List<T> objectList )
	{
		super( objectList );
	}

	@Override
	protected void init()
	{
		super.init();

		JScrollPane scrollPane = new JScrollPane( this.table );
		this.add( scrollPane, BorderLayout.CENTER );
	}

	@Override
	protected AbstractTableModel createTableModel( List<T> objectList )
	{
		return new SimpleEntityTableModel<>( objectList );
	}

	@Override
	protected JTable createTable( TableModel tableModel )
	{
		return new JTable( tableModel );
	}

	//todo
	@Override
	protected ActionListener addObjectActionListener()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
                //todo
				final Class<T> clazz = (Class<T>)SimpleEntityPanel.this.objectList.get( 0 ).getClass();
				T entity = null;
				try
				{
					entity = SimpleEntityPanel.this.createEntity( clazz );
				}
				catch( IllegalAccessException | InstantiationException e1 )
				{
                    //todo
					e1.printStackTrace();
				}

				assert entity != null;
				entity.setName( SimpleEntityPanel.this.nameTextField.getText() );
				SimpleEntityPanel.this.objectList.add( entity );
                SimpleEntityPanel.this.tableModel.fireTableDataChanged();
			}
		};
	}

	protected T createEntity( Class<T> clazz ) throws IllegalAccessException, InstantiationException
	{
		return clazz.newInstance();
	}

	//todo
	@Override
	protected ActionListener editObjectActionListener()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				throw new NullPointerException();
			}
		};
	}

	//todo
	@Override
	protected ActionListener removeObjectActionListener()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				if( SimpleEntityPanel.this.table.getSelectedRows().length == 1 )
				{
					final int selectedRow = SimpleEntityPanel.this.table.getSelectedRow();
					SimpleEntityPanel.this.objectList.remove( selectedRow );
					SimpleEntityPanel.this.tableModel.fireTableDataChanged();
				}
			}
		};
	}



	@Override
	public List<T> getObjects()
	{
		return this.objectList;
	}
}
