
import java.util.Optional;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static org.apache.logging.log4j.core.util.Loader.getClassLoader;


public class ApplicationProperties {

	private static final Logger logger = LogManager.getLogger(ApplicationProperties.class);
	
	private static final String APPLICATION_PREFIX ="applicaton";
	private static final String APPLICATION_SUFIX ="properties";
	
	private static Properties instance =null;
	
	public static Properties getInstance() {
	
		if (null==instance) {
			instance =	loadPropertiesFile();
		}
		
		return instance;
	}
	
	
	private ApplicationProperties() {
		
	}
	
	private static Properties loadPropertiesFile () {
		String enviromen = Optional.ofNullable(System.getenv("env"))
			.orElse("dev");
		
		String fileName = String.format("%s-%s.%s",APPLICATION_PREFIX,enviromen,APPLICATION_SUFIX);
		
		System.out.println("Fichero porperties "+fileName);
		
		
		logger.info("Properties a cargar Fichero "+fileName);
		
		Properties prop = new Properties();
		
		
		try {
			prop.load(getClassLoader().getResourceAsStream(fileName));
		}catch (IOException e) {
			logger.error("no se pudo cargar el archivo "+fileName+"",e);
			e.printStackTrace();
		}
		
		return prop;
	}
}
