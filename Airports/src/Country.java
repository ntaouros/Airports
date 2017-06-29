import java.util.ArrayList;

public class Country {
	private int id;
	private String code,name, continent,wikipediaLink,keywords;
	private ArrayList<Airport> airports=new ArrayList<Airport>();
	
	public Country(int id, String code, String name, String continent, String wikipediaLink, String keywords) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.wikipediaLink = wikipediaLink;
		this.keywords = keywords;
	}
	public ArrayList<Airport> getAirports() {
		return airports;
	}
	public void setAirports(ArrayList<Airport> airports) {
		this.airports = airports;
	}
	public void addAirport(Airport airport)
	{
		this.airports.add(airport);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getWikipediaLink() {
		return wikipediaLink;
	}
	public void setWikipediaLink(String wikipediaLink) {
		this.wikipediaLink = wikipediaLink;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getNumOfAirports()
	{
		return this.airports.size();
	}
	
}
