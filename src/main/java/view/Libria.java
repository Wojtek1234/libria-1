package view;

import commons.LibriaComponentMetrics;
import commons.Messages;
import controller.BasicDialog;
import controller.ChooseLanguagePanel;
import controller.ObjectsOwnerPanel;
import controller.SimpleEntityPanel;
import controller.book.BooksPanel;
import model.entity.Account;
import model.entity.Author;
import model.entity.Book;
import model.entity.Category;
import model.entity.Room;
import model.service.BookService;
import model.service.LibriaServiceBean;
import model.service.base.AccountService;
import model.service.base.AuthorService;
import model.service.base.CategoryService;
import model.service.base.RoomService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public class Libria
{
	public static void main( String... args ) throws IOException
	{
		ObjectsOwnerPanel<String> objectsOwnerPanel = new ChooseLanguagePanel( new ArrayList<>( getLanguageSet() ) );
		BasicDialog<String> languageDialog = new BasicDialog<>( null, "Main menu",
				LibriaComponentMetrics.SMALL_DIALOG_DIMENSION, objectsOwnerPanel );

		languageDialog.setVisible( true );

		if( languageDialog.isAccepted() )
		{
			String localeString = languageDialog.getObjects().get( 0 );
			Messages.init( new Locale( localeString, localeString.toUpperCase() ) );

			ApplicationContext context = new ClassPathXmlApplicationContext( "beanConfiguration.xml" );
			LibriaServiceBean libriaServiceBean = (LibriaServiceBean)context.getBean( "libriaServiceBean" );

			final JFrame frame = new JFrame( Messages.getMessage( "libria" ) );
			frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
			frame.setPreferredSize( LibriaComponentMetrics.LARGE_DIALOG_DIMENSION );
			frame.getContentPane().add( new JLabel( Messages.getMessage( "welcome.to.libria" ) ), BorderLayout.NORTH );

			JPanel mainPanel = new JPanel( new GridBagLayout() );
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.weightx = 0.5;
			gridBagConstraints.weighty = 0;
			gridBagConstraints.anchor = GridBagConstraints.CENTER;

			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			JButton bookButton = new JButton( Messages.getMessage( "books" ) );
			bookButton.addActionListener( bookAction( frame, libriaServiceBean ) );
			mainPanel.add( bookButton, gridBagConstraints );

			gridBagConstraints.gridy = 1;
			JButton authorButton = new JButton( Messages.getMessage( "authors" ) );
			authorButton.addActionListener( authorAction( frame, libriaServiceBean ) );
			mainPanel.add( authorButton, gridBagConstraints );

			gridBagConstraints.gridy = 2;
			JButton categoryButton = new JButton( Messages.getMessage( "categories" ) );
			categoryButton.addActionListener( categoryAction( frame, libriaServiceBean ) );
			mainPanel.add( categoryButton, gridBagConstraints );

			gridBagConstraints.gridy = 3;
			JButton roomButton = new JButton( Messages.getMessage( "rooms" ) );
			roomButton.addActionListener( roomAction( frame, libriaServiceBean ) );
			mainPanel.add( roomButton, gridBagConstraints );

			gridBagConstraints.gridy = 4;
			JButton accountButton = new JButton( Messages.getMessage( "users" ) );
			accountButton.addActionListener( accountAction( frame, libriaServiceBean ) );
			mainPanel.add( accountButton, gridBagConstraints );

			frame.getContentPane().add( mainPanel, BorderLayout.CENTER );

			JButton button = new JButton( Messages.getMessage( "close" ) );
			JPanel buttonsPanel = new JPanel( new BorderLayout() );
			buttonsPanel.add( button, BorderLayout.EAST );

			button.addActionListener( closeDialogActionListener( frame ) );

			frame.getContentPane().add( buttonsPanel, BorderLayout.SOUTH );
			frame.pack();
			frame.setVisible( true );

		}
	}

	private static Set<String> getLanguageSet() throws IOException
	{
		Properties prop = new Properties();

		try (InputStream input = new FileInputStream(
				new File( "src/main/resources/properties/languages.properties" ) ))
		{
			prop.load( input );
		}
		catch( IOException e )
		{
			throw e;
		}

		return prop.stringPropertyNames();
	}

	private static ActionListener bookAction( final JFrame frame, final LibriaServiceBean libriaServiceBean )
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				final BookService bookService = libriaServiceBean.getBookService();
				BooksPanel booksPanel = new BooksPanel( bookService.getAll() );

				BasicDialog<Book> basicDialog = new BasicDialog<>( frame, "Panel Książek",
						LibriaComponentMetrics.MEDIUM_DIALOG_DIMENSION, booksPanel );

				basicDialog.setVisible( true );
				if( basicDialog.isAccepted() )
				{
					final List<Book> objects = basicDialog.getObjects();
					bookService.refresh( objects );
				}
			}
		};
	}

	private static ActionListener authorAction( final JFrame frame, final LibriaServiceBean libriaServiceBean )
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				final AuthorService authorService = libriaServiceBean.getAuthorService();
				SimpleEntityPanel<Author> simpleEntityPanel = new SimpleEntityPanel<>( authorService.getAll() );

				BasicDialog<Author> basicDialog = new BasicDialog<>( frame, "Panel Autorów",
						LibriaComponentMetrics.MEDIUM_DIALOG_DIMENSION, simpleEntityPanel );

				basicDialog.setVisible( true );
				if( basicDialog.isAccepted() )
				{
					final List<Author> objects = basicDialog.getObjects();
					authorService.refresh( objects );
				}
			}
		};
	}

	private static ActionListener categoryAction( final JFrame frame, final LibriaServiceBean libriaServiceBean )
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				final CategoryService categoryService = libriaServiceBean.getCategoryService();
				SimpleEntityPanel<Category> simpleEntityPanel = new SimpleEntityPanel<>( categoryService.getAll() );

				BasicDialog<Category> basicDialog = new BasicDialog<>( frame, "Panel Kategorii",
						LibriaComponentMetrics.MEDIUM_DIALOG_DIMENSION, simpleEntityPanel );

				basicDialog.setVisible( true );
				if( basicDialog.isAccepted() )
				{
					final List<Category> objects = basicDialog.getObjects();
					categoryService.refresh( objects );
				}
			}
		};
	}

	private static ActionListener accountAction( final JFrame frame, final LibriaServiceBean libriaServiceBean )
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				final AccountService accountService = libriaServiceBean.getAccountService();
				SimpleEntityPanel<Account> booksPanel = new SimpleEntityPanel<>( accountService.getAll() );

				BasicDialog<Account> basicDialog = new BasicDialog<>( frame, "Panel Użytkownika",
						LibriaComponentMetrics.MEDIUM_DIALOG_DIMENSION, booksPanel );

				basicDialog.setVisible( true );
				if( basicDialog.isAccepted() )
				{
					final List<Account> objects = basicDialog.getObjects();
					accountService.refresh( objects );
				}
			}
		};
	}

	private static ActionListener roomAction( final JFrame frame, final LibriaServiceBean libriaServiceBean )
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				final RoomService roomService = libriaServiceBean.getRoomService();

				SimpleEntityPanel<Room> booksPanel = new SimpleEntityPanel<>( roomService.getAll() );

				BasicDialog<Room> basicDialog = new BasicDialog<>( frame, "Panel Pokoi",
						LibriaComponentMetrics.MEDIUM_DIALOG_DIMENSION, booksPanel );

				basicDialog.setVisible( true );
				if( basicDialog.isAccepted() )
				{
					final List<Room> objects = basicDialog.getObjects();
					roomService.refresh( objects );
				}
			}
		};
	}

	private static ActionListener closeDialogActionListener( final JFrame frame )
	{
		return new ActionListener()
		{

			@Override
			public void actionPerformed( ActionEvent e )
			{
				frame.dispose();
			}
		};
	}
}
