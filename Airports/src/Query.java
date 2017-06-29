import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Query extends HttpServlet {


	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException, IOException
	{
		String code=req.getParameter("code");
		String name= req.getParameter("name");
		

		ArrayList<Country> countries=CSVReader.countries;
		resp.getWriter().println(HTMLPrint.printStyle());
		resp.getWriter().println("<html>");
	


		resp.getWriter().println("<body>");
		resp.getWriter().println("<a href=\"http://localhost:8080/Airports/\">Back </a> <br>");

		//codeInput variable to check if the user has used the code input. If so the name input is ingored.
		boolean codeInput=true;
		if (code.trim().equals("")&&name.trim().equals("")) 
		{
	        resp.sendRedirect("http://localhost:8080/Airports/");
			return;
		}
		if(code.trim().equals(""))
		{
			codeInput=false;
		}

		//condition variable depends on whether the user used the code input or the name
		boolean condition;
		ArrayList<Country> matchedCountries=new ArrayList<Country>();
		for (Country country:countries)
		{
			condition=country.getName().equalsIgnoreCase(name);
			if(codeInput)
			{
				condition=country.getCode().equalsIgnoreCase(code);
			}else
			{
				//If there is a match, the current country is stored.
				if (country.getName().matches("(?i)"+name +".*"))
				{
					matchedCountries.add(country);
				}
			}
			if  (condition)
			{
				printTable(country,resp);
				return;
			}
		}
		
		//If there is more than one matched country, Print the country with the most airports from the matched list
		if (matchedCountries.size()>0)
		{
			Country maxCountry=((Collection<Country>) matchedCountries).stream().parallel().max(Comparator.comparing(Country::getNumOfAirports)).get();
			printTable(maxCountry,resp);
			resp.getWriter().println(HTMLPrint.printFooter());
			return;
		}
		
		//This section is only accessible when no match found with the given input.
		if (codeInput)
		{
			resp.getWriter().println("Country with code "+code+" not found");
		}else
		{
			resp.getWriter().println("Country "+name+" not found");
		}
		resp.getWriter().println(HTMLPrint.printFooter());


	}
	/**
	 * Prints an HTML table with the runways of each airport from the given country
	 * 
	 * 
	 * @param country
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public static void printTable(Country country,HttpServletResponse resp)throws ServletException, IOException
	{
		resp.getWriter().println("Showing Airports For "+country.getName());
		
		resp.getWriter().println(HTMLPrint.createTable(new String[]{"Airport","Runway","Heading","Surface","Lighted"}));
		for (Airport airport:country.getAirports())
		{
			resp.getWriter().println("<tr>");
			resp.getWriter().println("<td rowspan=\""+airport.getRunways().size() +"\">"+airport.getName()+"</td>");
			boolean firstLine=true;
			for (Runway runway:airport.getRunways())
			{
				if (!firstLine)
				{
					
					resp.getWriter().println("<tr><td>"+runway.getId()+" </td><td>"+runway.getHeHeading()+" </td><td>"+runway.getSurface()+" </td><td>"+runway.getLighted()+" </td></tr>");
				}else
				{
					resp.getWriter().println("<td>"+runway.getId()+" </td><td>"+runway.getHeHeading()+" </td><td>"+runway.getSurface()+" </td><td>"+runway.getLighted()+" </td></tr>");
					firstLine=false;
				}
			}
		}
		resp.getWriter().println("</table >");
		resp.getWriter().println(HTMLPrint.printFooter());
		
	}
	
	
}
