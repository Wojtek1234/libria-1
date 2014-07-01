package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public final class Messages
{
	private static final Log logger = LogFactory.getLog( Messages.class );

	private static final Map<Locale, Map<String, String>> messageMap = new HashMap<>();
	private static Locale currentLocale = Locale.getDefault();

	protected static Locale getCurrentLocale()
	{
		return currentLocale;
	}

	public static void init( Locale currentLocale ) throws IOException
	{
		Messages.currentLocale = currentLocale;
		initMessages( currentLocale );
	}

	private static void initMessages( Locale locale ) throws IOException
	{
		Properties prop = new Properties();

		try (InputStream input = new FileInputStream( new File( "src/main/resources/properties/messages/messages_"
				+ locale.getLanguage() + ".properties" ) ))
		{
			prop.load( input );
			Map<String, String> messagesMap = new HashMap<>();
			for( String propertyName : prop.stringPropertyNames() )
			{
				messagesMap.put( propertyName, prop.getProperty( propertyName ) );
			}
			messageMap.put( locale, messagesMap );

		}
		catch( IOException e )
		{
			logger.error( e );
			throw e;
		}

	}

	public static String getMessage( String code )
	{
		return getMessage( currentLocale, code );
	}

	//TODO create test which check does all messages exist in different langauges properties
	private static String getMessage( Locale locale, String code )
	{
		final String message = messageMap.get( locale ).get( code );
		if( message == null )
		{
			String info = "There is no corresponding message";
			logger.info( info );
			throw new NullPointerException( info );
		}
		return messageMap.get( locale ).get( code );
	}
}
