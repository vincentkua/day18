package nus.iss.day18;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import nus.iss.day18.services.HttpinService;
// import nus.iss.day18.services.WeatherService;

@SpringBootApplication
public class Day18Application implements CommandLineRunner{


	// @Autowired
	// private HttpinService httpBinSvc;

	// @Autowired
	// private WeatherService weatherSvc;



	public static void main(String[] args) {
		SpringApplication.run(Day18Application.class, args);
	}

	@Override
	public void run(String... args){
		// httpBinSvc.get();
		// httpBinSvc.get("chuk", "chuk@gmaill.com");
		// httpBinSvc.post("chuk", "chuk@gmaill.com");
		// httpBinSvc.postAsJson("chuk", "chuk@gmaill.com");
		// weatherSvc.getWeather("Singapore");
	}

}
