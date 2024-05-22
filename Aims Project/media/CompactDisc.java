package hust.soict.cybersec.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc  extends Disc implements Playable {


	private static int nbCompactDiscs = 1; //Track the number of Compact Disc created
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	

	// Form: DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87, 19.95f);
	public CompactDisc(String title, String category, String director, String artist, int length,  float cost, ArrayList<Track> tracks) {
		super(title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
		setId(nbCompactDiscs);  //Assign id equals to number of DVD created
		nbCompactDiscs++;
	}


	//Initial without Track list required
	public CompactDisc(String title, String category, String director, String artist, int length,  float cost) {
		super(title, category, director, length, cost);
		this.artist = artist;
		setId(nbCompactDiscs);  //Assign id equals to number of DVD created
		nbCompactDiscs++;
	}
	




	//Methods
	public void addTrack(Track track) {
		//Check if  a new track already exists in the list
		if (tracks.contains(track)) {
			System.out.println("This track already exists in the list");
		}
		else tracks.add(track);
	}
	
	public void removeTrack(Track track) {
		//Check if author track already exists in the list
		if (tracks.contains(track)) {
			tracks.remove(track);
		}
		else System.out.println("This track does not exist in the list");
	}
	
	public int getLength() {
		int sum = 0;
		for (Track track : tracks) {
			sum += track.getLength();
		}
		return sum;
	}
	
	public String play() {
		StringBuilder CDplayList = new StringBuilder();
		for (Track track : tracks) {
			CDplayList.append(track.play()).append("\n");
		}
		return CDplayList.toString();
	}
	
	public String toString() {

		//Return Tracks list in format (title, length) istead of throwing object address
		String tracksList = "";
		for (Track track : tracks) {
			tracksList += "(" + track.getTitle() + ", " + track.getLength() + ") ";
		}
		return getId() +". CD-" + getTitle() +"-"+ getCategory() + "-" +
				getDirector()+ "-" + getLength()+ "-" +  getArtist() + "-" + tracksList + ": " + getCost() + " $";
	}


	//Getter and Setter
	public String getArtist() {
		return artist;
	}


	public List<Track> getTracks() {
		return tracks;
	}
	
	

}
