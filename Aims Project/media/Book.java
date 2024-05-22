package hust.soict.cybersec.aims.media;

import java.util.ArrayList;


public class Book extends Media {

	
	private ArrayList<String> authors = new ArrayList<String>();
	private static int nbBook = 1; //Track the number of book created
	
	//Constructor
	public Book(String title, String category, float cost, ArrayList<String> authors) {
		super(title, category, cost);
		this.authors = authors;
		setId(nbBook);
		nbBook++;
	}
	
	//Initial with no authors required 
	public Book(String title, String category, float cost) {
		super(title, category, cost);
		setId(nbBook);
		nbBook++;
	}

	//methods
	
	@Override
	public String toString() {
		return getId() +". Book-" + getTitle() + "-" + getCategory() + "-" + getAuthors() + ": " + getCost() + " $";
		
	}
		
	public void addAuthor(String authorName) {
		//Check if author name already exists in the list
		if (authors.contains(authorName)) {
			System.out.println("This author already exists in the list");
		}
		else authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		//Check if author name already exists in the list
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		}
		else System.out.println("This author does not exist in the list");
	}

	//Getter and Setter
	public ArrayList<String> getAuthors() {
		return authors;
	}
	
	
	

}
