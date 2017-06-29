
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OnStart implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
    	
		CSVReader.readCSV("https://s3-eu-west-1.amazonaws.com/lunatechassessments/countries.csv","Country");
		CSVReader.readCSV("https://s3-eu-west-1.amazonaws.com/lunatechassessments/airports.csv","Airport");
		CSVReader.readCSV("https://s3-eu-west-1.amazonaws.com/lunatechassessments/runways.csv","Runway");
    }
    public void contextDestroyed(ServletContextEvent event) {
        // Do your thing during webapp's shutdown.
    }
}


