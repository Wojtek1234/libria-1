package controller;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public class BasicDialog<T> extends JDialog implements ObjectsOwner<T>
{
	private static final long serialVersionUID = 1L;

	private ObjectsOwnerPanel<T> objectsOwnerPanel;
	private boolean accepted;

	public BasicDialog( Frame owner, String title, Dimension dimension, ObjectsOwnerPanel<T> objectsOwnerPanel )
	{
		super( owner, title );
		this.setModal( true );
		this.setSize( dimension );
		this.setLocationRelativeTo( owner );
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.objectsOwnerPanel = objectsOwnerPanel;

		this.init();
	}

	private void init()
	{
		this.setLayout( new BorderLayout() );
		this.getContentPane().add( this.objectsOwnerPanel, BorderLayout.CENTER );

		JPanel buttonsPanel = new JPanel();
		JButton okButton = new JButton( "Ok" );
		okButton.addActionListener( this.acceptAction() );
		this.objectsOwnerPanel.getRootPane().setDefaultButton( okButton );

		JButton cancelButton = new JButton( "Anuluj" );
		cancelButton.addActionListener( this.cancelAction() );

		buttonsPanel.add( okButton );
		buttonsPanel.add( cancelButton );

		this.getContentPane().add( buttonsPanel, BorderLayout.PAGE_END );
	}

	protected void cancel()
	{
		this.accepted = false;
		this.dispose();
	}

	protected void accept()
	{
		this.objectsOwnerPanel.accept();
		this.accepted = true;
		this.dispose();
	}

	private ActionListener cancelAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				BasicDialog.this.cancel();
			}
		};
	}

	private ActionListener acceptAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				BasicDialog.this.accept();
			}
		};
	}

	public boolean isAccepted()
	{
		return this.accepted;
	}

	@Override
	public List<T> getObjects()
	{
		return this.objectsOwnerPanel.getObjects();
	}
}
