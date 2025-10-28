package VideoGameOrganizer;

public class VideoGame {

	private String name;
	private String platform;
	private int year;
	private String genre;
	private String publisher;
	private double NASales;
	private double JPSales;
	private double EuSales;
	private double GSales;
	
	
	public VideoGame(String name, String platform, int year, String genre, String publisher, double NASales, double EuSales, double JPSales,
			double GSales) {
		
		this.name = name;
		this.platform = platform;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
		this.NASales = NASales;
		this.JPSales = JPSales;
		this.EuSales = EuSales;
		this.GSales = GSales;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPlatform() {
		return platform;
	}


	public void setPlatform(String platform) {
		this.platform = platform;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public double getNASales() {
		return NASales;
	}


	public void setNASales(double nASales) {
		NASales = nASales;
	}


	public double getJPNSales() {
		return JPSales;
	}


	public void setJPNSales(double jPNSales) {
		JPSales = jPNSales;
	}


	public double getEuSales() {
		return EuSales;
	}


	public void setEuSales(double euSales) {
		EuSales = euSales;
	}


	public double getGSales() {
		return GSales;
	}


	public void setGSales(double gSales) {
		GSales = gSales;
	}


	
	
}
