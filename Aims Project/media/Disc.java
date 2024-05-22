package hust.soict.cybersec.aims.media;

public abstract class Disc  extends Media{

	private int  length;
	private String director;
	
	//Constructor
	
	//Form: DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87, 19.95f);
	public Disc(String title, String category,  String director, int length, float cost ) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}



	//Getter and Setter
	public int getLength() {
		return length;
	}



	public String getDirector() {
		return director;
	}
	
	
	
}
