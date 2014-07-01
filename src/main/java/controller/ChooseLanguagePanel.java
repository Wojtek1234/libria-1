package controller;

import javax.swing.JComboBox;
import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public class ChooseLanguagePanel extends ObjectsOwnerPanel<String>
{
	private static final long serialVersionUID = 1L;

	private JComboBox<String> languageComboBox = new JComboBox<>();

	public ChooseLanguagePanel( List<String> objectList )
	{
		super( objectList );
		this.init();
	}

	private void init()
	{
		for( String language : this.getObjects() )
		{
			this.languageComboBox.addItem( language );
		}

		this.add( this.languageComboBox );
	}

	@Override
	public List<String> getObjects()
	{
		return this.objectList;
	}

    @Override
    public void accept()
    {
        this.objectList.clear();
        this.objectList.add( this.languageComboBox.getItemAt( this.languageComboBox.getSelectedIndex() ) );
    }
}
