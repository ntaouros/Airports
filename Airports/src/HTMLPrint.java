public class HTMLPrint {
	/**
	 * Returns a string with html elements for a table row 
	 * @param row
	 * @return
	 */
	public static String createRow(String[] row)
	{
		String rowHTML="<tr>";
		for (int i=0;i<row.length;i++)
		{
			rowHTML+="<td>"+row[i]+"</td>";
		}
		rowHTML+="</tr>";
		return rowHTML;
	}
	/**
	 * Returns a string containing html tags for a table
	 * @param columns
	 * @return
	 */
	public static String createTable(String[] columns)
	{
		String table="<table>";
		for (int i=0;i<columns.length;i++)
		{
			table+="<th>"+columns[i]+"</th>";
		}
		return table;
	}
	/**
	 * Prints the </body> and </html> tags
	 * 
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public static String printFooter()
	{
		return "</html></body>";
	}
	
	public static String printStyle()
	{
		return"<style>table {"
				+ "border: 2px solid pink;"
				+ "border-radius: 25px;"
				+ "}"
				+ ".title{"
				+ "font-weight: bold;"
				+ "font-size: 200%;"
				+ "}"
				
				+ "</style>";
	}
}
