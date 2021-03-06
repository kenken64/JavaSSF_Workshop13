package sg.edu.nus.workshop13;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static sg.edu.nus.workshop13.util.IOUtil.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Workshop13Application {
	private static final Logger logger 
		= LoggerFactory.getLogger(Workshop13Application.class);
	
	
	public static final String DATA_DIR = "dataDir";
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Workshop13Application.class);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		// Get data directory from the program argument
		List<String> optsval = appArgs.getOptionValues("dataDir");
		// create the directory
		if(optsval != null){
			createDir((String)optsval.get(0));
		}else{
			// if cannot find any dataDir argument from the program
			// args then abort the program
			logger.warn("No data directory is provided!");
			System.exit(1);
		}
			
		app.run(args);
	}

}
