package hust.soict.cybersec.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.cybersec.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	//private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void sortMediaByTitleThenCost() {
        Collections.sort(itemsOrdered, Media.COMPARAE_BY_TITLE_COST);
    }

    public void sortMediaByCostThenTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

	
	//No longer need qtyOrder
	//public  int qtyOrder = 0; //keep track of quantity DigitalVideoDiscs are currently in the cart
	
	//METHOD  (EX 11)
//	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
//		if (qtyOrder>=20) System.out.println("The cart is almost full");
//		else {
//			itemsOrdered[qtyOrder] = disc;
//			qtyOrder++;
//			System.out.println("The disc " +disc.getTitle()  + " has been added");
//		}
//	}
//	
//	
//	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {  //(EX 14.1b)
//		int numOfDiscToAdd = dvdList.length;
//		System.out.println("\nNumber of  disk will be added: " + numOfDiscToAdd);
//		if ((numOfDiscToAdd+qtyOrder) >=20) System.out.println("The cart is almost full");
//		else {
//			for (int i=0; i<numOfDiscToAdd; i++) {
//				itemsOrdered[qtyOrder+i] = dvdList[i];
//				System.out.println("The disc " + dvdList[i].getTitle()  + " has been added");
//			}
//			qtyOrder += numOfDiscToAdd;
//		
//		}
//	}
	

//	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {  //(EX 13)
//		
//		for (int i=0; i<qtyOrder; i++) {  //Find the disc that user want to remove
//			if (itemsOrdered[i] == disc) {
//				//Remove that disc by shifting
//				for (int j=i; j<qtyOrder-1; j++) {
//					itemsOrdered[j] = itemsOrdered[j+1];
//				}
//				itemsOrdered[qtyOrder-1] = null;  //remove the last position
//			}
//		}
//		qtyOrder--;
//		System.out.println("The disc " + disc.getTitle() + " has been removed");
//	}
	
	
	/* You could add more methods to add and remove Book and CompactDisc, but since
DigitalVideoDisc, Book and CompactDisc are all subclasses of type Media, you can simply
change Cart to maintain a collection of Media objects. Thus, you can add a DigitalVideoDisc, or
a Book, or a CompactDisc using the same methods.*/
public void addMedia(Media media) {
	if (itemsOrdered.size() == 20) {
		System.out.println("The cart is almost full");
	}
	else {
		itemsOrdered.add(media);
		System.out.println("The media "+ media.getTitle()  + " has been added to cart");
	}
}
	
public void removeMedia(Media media) {
	if (itemsOrdered.contains(media)) {
		System.out.println("The media " + media.getTitle() + " has been removed from cart");
		itemsOrdered.remove(media);
	}
	else {
		System.out.println("This media is not currently existing in the cart");
	}
}
	
	//Update using id instead of i index when print out after completing EX 16
	public float totalCost() {
		float sum = 0;
		for (Media media : itemsOrdered) {
			sum += media.getCost();
			}
		return sum;
	}

	public void showAllCartInfo() {
		System.out.println();
		System.out.println("******************************CART*******************************");
		System.out.println("Order Items: ");
		for (Media media : itemsOrdered) {
			//Display the title, cost
			System.out.println(media.toString());
		}
		
		
		System.out.println("Total cost: " + totalCost());
		System.out.println("*****************************************************************");
	}

	//Getter and Setter
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

    
	
	public void filterMediaInCartById(int id) {
			System.out.println();
			System.out.println("Results match with id: "+ id);
			int check_how_many_results = 0;
			for (int i=0; i < itemsOrdered.size(); i++) {
				if (itemsOrdered.get(i).getId() == id) {
					System.out.println(itemsOrdered.get(i).toString());
					check_how_many_results+=1;
				}		
			}
			
			if (check_how_many_results==0) System.out.println("No Match Found!!!");
	}

	public void filterMediaInCartByTitle(String title) {
		System.out.println();
		System.out.println("Results match with title: "+ title);
		int check_how_many_results = 0;
		for (int i=0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				System.out.println(itemsOrdered.get(i).toString());
				check_how_many_results+=1;
			}		
		}
		
		if (check_how_many_results==0) System.out.println("No Match Found!!!");
	}


	
}
