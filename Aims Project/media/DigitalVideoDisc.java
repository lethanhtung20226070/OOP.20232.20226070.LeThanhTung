package hust.soict.cybersec.aims.media;

public class DigitalVideoDisc  extends Disc implements Playable{
	

	private static int nbDigitalVideoDiscs = 1; //Track the number of DVDs created
	

	// Form: DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87, 19.95f);
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		setId(nbDigitalVideoDiscs);  //Assign id equals to number of DVD created
		nbDigitalVideoDiscs++;
	}

	
	
	//Methods
	public String toString() {
		return getId() +". DVD-" + getTitle() +"-"+ getCategory() + "-" +
				getDirector()+'-' + getLength()+ ": " + getCost() + " $";
	}
	
	public boolean isMatchByTitle(String title) {
		if (this.getTitle().equals(title)) return true;
		return false;
	}
	public boolean isMatchById(int id) {
		if (this.getId() == id) return true;
		return false;
	}
	
	
	public String play() {
		return "Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength();
	}

	
}
