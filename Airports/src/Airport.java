import java.util.ArrayList;

public class Airport {
	private int id;
	private ArrayList<Runway> runways=new ArrayList<Runway>();
	
	private String ident, type, name, latitude,longitude,elevation,continent,country,region,municipality,scheduledServhce,gps_code,iataCode,localCode,homeLink,wikipediaLink,keywords;
	public Airport(int id, String ident, String type, String name, String latitude, String longitude, String elevation,
			String continent, String country, String region, String municipality, String scheduledServhce,
			String gps_code, String iataCode, String localCode, String homeLink, String wikipediaLink,
			String keywords) {
		this.id = id;
		this.ident = ident;
		this.type = type;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.continent = continent;
		this.country = country;
		this.region = region;
		this.municipality = municipality;
		this.scheduledServhce = scheduledServhce;
		this.gps_code = gps_code;
		this.iataCode = iataCode;
		this.localCode = localCode;
		this.homeLink = homeLink;
		this.wikipediaLink = wikipediaLink;
		this.keywords = keywords;
	}
	public void addRunway(Runway runway)
	{
		this.runways.add(runway);
	}
	public ArrayList<Runway> getRunways() {
		return runways;
	}
	public void setRunways(ArrayList<Runway> runways) {
		this.runways = runways;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getElevation() {
		return elevation;
	}
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public String getScheduledServhce() {
		return scheduledServhce;
	}
	public void setScheduledServhce(String scheduledServhce) {
		this.scheduledServhce = scheduledServhce;
	}
	public String getGps_code() {
		return gps_code;
	}
	public void setGps_code(String gps_code) {
		this.gps_code = gps_code;
	}
	public String getIataCode() {
		return iataCode;
	}
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	public String getHomeLink() {
		return homeLink;
	}
	public void setHomeLink(String homeLink) {
		this.homeLink = homeLink;
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
	
	
}
