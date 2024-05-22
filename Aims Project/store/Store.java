package hust.soict.cybersec.aims.store;
import hust.soict.cybersec.aims.media.Media;
import java.util.ArrayList;



public class Store {
	
	ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsInStore.size() == 20) {
			System.out.println("The store is almost full");
		}
		else {
			itemsInStore.add(media);
			System.out.println("The media "+ media.getTitle()  + " has been added to store");
		}
	}
		
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("The media " + media.getTitle() + " has been removed from store");
			itemsInStore.remove(media);
		}
		else {
			System.out.println("This media is not currently existing in the store");
		}
	}
	
	
	public void showAllStoreInfo() {
		System.out.println();
		for (Media media : itemsInStore) {
			System.out.println(media.toString());
		}
	}
	

	//Getter and Setter
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	



}
