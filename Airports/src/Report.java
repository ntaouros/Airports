import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Report extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException, IOException
	{
		ArrayList<Country> countries=CSVReader.countries;

		//Sorting countries list based on airports
		Collections.sort(countries, new Comparator<Country>() {
			public int compare(Country o2, Country o1) {
	            return o1.getAirports().size() - o2.getAirports().size();
	        }
	    });
		resp.getWriter().println(HTMLPrint.printStyle());

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<a href=\"http://localhost:8080/Airports/\">Back </a> <br>");
		resp.getWriter().println("<div class=\"title\">Countries with the most airports </div><br>");

		
		resp.getWriter().println(HTMLPrint.createTable(new String[]{"Country","#Airports"}));
		//reversedTable variable for the coutnries with the least airports
		String reversedTable=HTMLPrint.createTable(new String[]{"Country","#Airports"});
		//Printing top 10 countries with the most airports.
		for (int i=0; i<10;i++)
		{
			resp.getWriter().println(HTMLPrint.createRow(new String[]{countries.get(i).getName(),""+countries.get(i).getAirports().size()}));
			reversedTable+=HTMLPrint.createRow(new String[]{countries.get(countries.size()-i-1).getName(),""+countries.get(countries.size()-i-1).getAirports().size()});
			
		}
		resp.getWriter().println("</table >");

		reversedTable+="</table > <br> <br> <br>";
		resp.getWriter().println("<div class=\"title\">Countries with the least airports </div><br>");
		resp.getWriter().println(reversedTable);
		resp.getWriter().println("<br><div class=\"title\">Types of runway surface per country</div><br>");
		resp.getWriter().println(HTMLPrint.createTable(new String[]{"Country","Surface Types"}));
		//Printing type of Runways per country
		for (Country country : countries)
		{
			Set<String> surfaces= country.getAirports().stream().flatMap(x->x.getRunways().stream().map(y->y.getSurface())).collect(Collectors.toSet());
			resp.getWriter().println(HTMLPrint.createRow(new String[]{country.getName(),Arrays.toString(surfaces.toArray(new String [surfaces.size()]))}));
			
		}
		resp.getWriter().println("</table >");
		//Collecting all runway IDentification
		List <String> runwayTypes=countries.stream().flatMap(x -> x.getAirports().stream()).flatMap(y-> y.getRunways().stream().map(z->z.getLeIdent())).collect(Collectors.toList());
		Map<String, Long> counts =
				runwayTypes.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		//Sorting 
		List<Map.Entry<String, Long>> list =
	                new LinkedList<Map.Entry<String, Long>>(counts.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o2,
                               Map.Entry<String, Long> o1) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
		resp.getWriter().println("<div class=\"title\">Most common runway identifications</div> <br>");
		resp.getWriter().println(HTMLPrint.createTable(new String[]{"Runway Identification","#"}));
		int i=0;
		for (Map.Entry<String, Long> entry : list)
		{
			if(i++>10)break;
		    System.out.println(entry.getKey() + "-" + entry.getValue());
			resp.getWriter().println(HTMLPrint.createRow(new String[]{""+entry.getKey(),""+entry.getValue()}));
			
		}
		
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
	}
	//TODO Create class for printing and shit replace query's methods
	//TODO Create CSS 

	
}
