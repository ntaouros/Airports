import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
public class CSVReader {
	static ArrayList<Country> countries=new ArrayList<Country>();
	static ArrayList<Airport> airports=new ArrayList<Airport>();
	static final String cvsSplitBy = ",";
	//TODO include local files  support as well. In case of apocalypse.
	public static void readCSV(String url,String typeOf)
	{
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(
		    new InputStreamReader(new URL(url).openStream())); 
			boolean firstLine=true;
		    while ((line = br.readLine()) != null) {
		    	if (firstLine)
		    	{
		    		firstLine=false;
		    		continue;
		    	}
				line=line.replaceAll("[,.!?;:]", "$0 ");
		        // use comma as separator
				String[] lineToken = line.split(cvsSplitBy);
				for(int i=0;i<lineToken.length;i++)
				{
					lineToken[i] = lineToken[i].replace("\"", "").trim();
				}
				switch(typeOf)
				{
					case "Country":
	                	countries.add(new Country(Integer.parseInt(lineToken[0]),lineToken[1],lineToken[2],lineToken[3],lineToken[4],lineToken[5]));
	                	break;
					case"Airport":
		            	Airport airprt=new Airport(Integer.parseInt(lineToken[0]),lineToken[1],lineToken[2],lineToken[3],lineToken[4],lineToken[5],lineToken[6],lineToken[7],lineToken[8],lineToken[9],lineToken[10],lineToken[11],lineToken[12],lineToken[13],lineToken[14],lineToken[15],lineToken[16],lineToken[17]);
		            	String airport_country=lineToken[8];
		            	airports.add(airprt);
	                	for (Country country: countries)
		                {
	                		if(country.getCode().trim().equals(airport_country.trim()))
		              	   	{
		              		   country.addAirport(airprt);
		              	   	}
		              	}
					break;
					case"Runway":
						int runway_airport=Integer.parseInt(lineToken[1]);
		            	Runway runwayObj=new Runway(Integer.parseInt(lineToken[0]),Integer.parseInt(lineToken[1]),lineToken[2],lineToken[3],lineToken[4],lineToken[5],lineToken[6],lineToken[7],lineToken[8],lineToken[9],lineToken[10],lineToken[11],lineToken[12],lineToken[13],lineToken[14],lineToken[15],lineToken[16],lineToken[17],lineToken[18],lineToken[19]);
		            	for (Airport airport: airports)
		            	{
		            	   if(airport.getId()==runway_airport)
		            	   {
		            		   airport.addRunway(runwayObj);
		            	   }
		            	}
					break;
				}
			}
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		
		}

	}  
      
}
