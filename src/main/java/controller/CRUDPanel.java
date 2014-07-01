package controller;

import commons.Messages;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public abstract class CRUDPanel<T> extends ObjectsOwnerPanel<T>
{
	private static final long serialVersionUID = 1L;
	protected final JTable table;
	protected final AbstractTableModel tableModel;
	protected final JTextField nameTextField;

	public CRUDPanel( List<T> objectList )
	{
		super( objectList );
		this.tableModel = this.createTableModel( this.objectList );
		this.table = this.createTable( this.tableModel );
		this.nameTextField = new JTextField( 20 );
		this.init();
	}

	protected void init()
	{
		this.setLayout( new BorderLayout() );
		JPanel controlButtonsPanel = new JPanel();

		this.createControlButtonsPanel( controlButtonsPanel );

		this.add( controlButtonsPanel, BorderLayout.PAGE_START );
	}

	protected void createControlButtonsPanel( JPanel controlButtonsPanel )
	{
		JLabel nameTextFieldLabel = new JLabel( Messages.getMessage( "name" ) );

		controlButtonsPanel.add( nameTextFieldLabel );
		controlButtonsPanel.add( this.nameTextField );

		JButton addButton = new JButton( Messages.getMessage( "dodaj" ) );
		addButton.addActionListener( this.addObjectActionListener() );
		JButton editButton = new JButton( Messages.getMessage( "edit" ) );
		editButton.addActionListener( this.editObjectActionListener() );
		JButton removeButton = new JButton( Messages.getMessage( "delete" ) );
		removeButton.addActionListener( this.removeObjectActionListener() );

		controlButtonsPanel.add( addButton );
		controlButtonsPanel.add( editButton );
		controlButtonsPanel.add( removeButton );

	}

	protected abstract JTable createTable( TableModel tableModel );

	protected abstract AbstractTableModel createTableModel( List<T> objectList );

	protected abstract ActionListener removeObjectActionListener();

	protected abstract ActionListener editObjectActionListener();

	protected abstract ActionListener addObjectActionListener();

}
