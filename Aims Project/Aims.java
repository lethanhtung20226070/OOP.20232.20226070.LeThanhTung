package hust.soict.cybersec.aims;

import hust.soict.cybersec.aims.store.Store;
import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Track;

import java.util.Scanner;
import java.util.Collections;

public class Aims {

public static void main(String[] args) {
	Store store = new Store();
	Cart cart = new Cart(); //Empty cart

	//Add some instances of media to the store

		//Some DVDs
	store.addMedia(new DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87, 19.95f));
	store.addMedia(new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas", 87, 24.95f));
	store.addMedia(new DigitalVideoDisc("Oppenheimer","Science Fiction","CTA", 87, 24.95f));
	store.addMedia(new DigitalVideoDisc("Avengers: Endgame", "Action", "Anthony Russo, Joe Russo", 181, 25.99f));
	store.addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.99f));
	store.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 24.99f));


		//Some CDs with tracks
	CompactDisc cd1 = new CompactDisc("TopGun","Action","CTA","TomCruise",0, 24.95f);
	cd1.addTrack(new Track("Episode 1", 5));
	cd1.addTrack(new Track("Episode 2", 10));
	store.addMedia(cd1);
	
	CompactDisc cd2 = new CompactDisc("OOP","Lab","TrangNT","CTA",0, 24.95f);
	cd2.addTrack(new Track("Lab 1", 5));
	cd2.addTrack(new Track("Lab 2", 10));
	cd2.addTrack(new Track("Lab 3", 15));
	store.addMedia(cd2);

		//Some Books
	Book book1 = new Book("DarkNhanTam","Selfhelp", 20.5f);
	book1.addAuthor("Dale Carnegie");
	book1.addAuthor("CTA");
	store.addMedia(book1);

	Book book2 = new Book("CalculusI","LectureMaterail", 20.5f);
	book2.addAuthor("CTA");
	book2.addAuthor("James Stewart");
	store.addMedia(book2);



	System.out.println();
	System.out.println("Welcome to AIMS");
	//Call the main menu
	showMenu(store,cart);
}

	//Main Menu (Level 1)
	public static void showMenu(Store store,Cart cart) {
		while (true) {
			System.out.println("\nMenu Level 1:");
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: 0-1-2-3: ");

			Scanner userInput = new Scanner(System.in);
			int option = userInput.nextInt();
            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
					//First, display all items in the store
					System.out.println("\nAll items in our store");
					store.showAllStoreInfo();
                    storeMenu(store,cart);
                    break;
                case 2:
                    // Add or remove media from store (NOT Cart)
					System.out.println("You want to remove (0) /add (1) from store: ");
					//Ask user if they want to add or remove the media
					int addOrRemove = userInput.nextInt();
					
					
					if (addOrRemove == 0) {
						//Find the index of the media user wants to remove
						int i = find_Index_Of_Media_From_Title_User_Input(store);
						store.removeMedia(store.getItemsInStore().get(i));
					}
					else if (addOrRemove == 1) {
						System.out.println("Add new media: DVD (0), CD (1), Book (2)");
						int which_to_add = userInput.nextInt();
						store.addMedia(FromInputToNewMedia(which_to_add));
					}
					else {
						System.out.println("Invalid option. Please choose again.");
					}
                    break;
                case 3:

					//Display the current cart
					cart.showAllCartInfo();
					//Load the cart menu
                    cartMenu(store, cart);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
					break;
            }
		}

	}

	//Store Menu (Level 2)
	// Option 1 from main menu  
	public static void storeMenu(Store store,Cart cart) {
		while (true) {
			System.out.println("\nMenu Level 2:");
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: 0-1-2-3-4: ");
	
			Scanner userInput= new Scanner(System.in);
			int option = userInput.nextInt();
			switch (option) {
				case 0:
					return; // Go back to the main menu
				case 1:
					//User enters the title of the media they want to see
					int k = find_Index_Of_Media_From_Title_User_Input(store);
					if (k != -1) {
						//Display the media details
						System.out.println(store.getItemsInStore().get(k).toString());
						//Load the media details menu
						mediaDetailsMenu(store,cart,store.getItemsInStore().get(k));
					}
					else {
						System.out.println("No Media in Store matchs this title");
					}
					
					break;
				case 2:
					//Add a media to the cart
					//Find the index of the media user wants to see
					int i = find_Index_Of_Media_From_Title_User_Input(store);
					cart.addMedia(store.getItemsInStore().get(i));
					//Display number of items currently in Cart
					System.out.println("The current cart has " + cart.getItemsOrdered().size() + " items");
					break;
				case 3:
					//Find the index of the media user wants to see
					int j = find_Index_Of_Media_From_Title_User_Input(store);
					if (j != -1) {
						PlayMedia(store.getItemsInStore().get(j));
					}
					else System.out.println("No Media in Store matchs this title");
					
					break;
				case 4:
					//Display the current cart
					cart.showAllCartInfo();
					//Load the cart menu
					cartMenu(store,cart);
					break;
				default:
					System.out.println("Invalid option. Please choose again.");
					break;
			}
		}
	}

	//mediaDetailsMenu (Level 3)
	//Option 1 from storeMenu
	public static  void mediaDetailsMenu(Store store,Cart cart, Media media) {
		while (true) {

			//Load the Media details menu
			System.out.println("\nMenu Level 3:");
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: 0-1-2: ");
	

			Scanner userInput= new Scanner(System.in);
			int option = userInput.nextInt();
			switch (option) {
				case 0:
					return; // Go back to the previous menu
				case 1:
					cart.addMedia(media);
					//display the number of Media in the current car
					System.out.println("The current cart has " + cart.getItemsOrdered().size() + " items");
					break;
				case 2:
					PlayMedia(media);
					break;
				default:
					System.out.println("Invalid option. Please choose again.");
			}
		}
	}

	//Cart Menu (Level 2) but I will classify it as Level 4 for better understanding
	//Option 3 from main menu
	public static void cartMenu(Store store,Cart cart) {
		while (true) {
			System.out.println("\nMenu Level 4:");
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter media in cart");
			System.out.println("2. Sort media in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: 0-1-2-3-4-5: ");
			
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			scanner.nextLine();  // Consume the newline character
			switch (option) {
				case 0:
					return; // Go back to the main menu
				case 1:
					//Filter media in cart by id or by title
					//Ask user to choose the filter type
					System.out.println("Choose the filter type: (1) for id, (2) for title");
					int filterType = scanner.nextInt();
					if (filterType == 1) {
						System.out.println("Enter the id of the media you want to filter: ");
						int id = scanner.nextInt();
						cart.filterMediaInCartById(id);
					}
					else if (filterType == 2) {
						System.out.println("Enter the title of the media you want to filter: ");
						String title = scanner.nextLine();
						cart.filterMediaInCartByTitle(title);
					}
					else {
						System.out.println("Invalid option. Please choose again.");
					}
					break;
				case 2:
					//Sort media in cart by cost or by title
					//Ask user to choose the sort type
					System.out.println("Choose the sort type: (1) for cost, (2) for title");
					int sortType = scanner.nextInt();
					if (sortType == 1) {
						//Sort by title, if title equals then sort by cost using COMPARAE_BY_TITLE_COST for sorting
						Collections.sort(cart.getItemsOrdered(), Media.COMPARAE_BY_TITLE_COST);
						System.out.println("The cart has been sorted by Title then Cost");
						cart.showAllCartInfo();
					}
					else if (sortType == 2) {
						Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
						System.out.println("The cart has been sorted by TCost and Title");
						cart.showAllCartInfo();
					}
					else {
						System.out.println("Invalid option. Please choose again.");
					}
					break;
				case 3:
					//Remove media from cart
					//Find the index of the media user wants to see
					int i = find_Index_Of_Media_From_Title_User_Input(cart);
					cart.removeMedia(cart.getItemsOrdered().get(i));
					break;
				case 4:
					//Play a media;
					//Find the index of the media user wants to see
					int j = find_Index_Of_Media_From_Title_User_Input(cart);
					PlayMedia(cart.getItemsOrdered().get(j));
					break;
				case 5:
					//Place order
					cart.showAllCartInfo();
					System.out.println("The total cost of the cart is: " + cart.totalCost());
					System.out.println("Want to pay for the cart? (y/N)");
					String pay = scanner.nextLine();
					if (pay.equals("y")) {
						System.out.println("Please transfer the money to 25102049999 (MB Bank)");
					}
					else {
						System.out.println("Terminate the transaction. The cart is still there.");
					}

					break;
				default:
					System.out.println("Invalid option. Please choose again.");
			}
		}
	}


	//Some shared methods between Menu levels

	public static int find_Index_Of_Media_From_Title_User_Input(Store store) {
		//Let user enter a media title to see its details
		System.out.println("Enter the title of the media you want to see: ");
		Scanner userInput = new Scanner(System.in);
		String title = userInput.nextLine();

		// Find that media in the store
		int i = 0;  //Use i to get index of the media user searched for
		boolean found = false;
		for (i = 0; i < store.getItemsInStore().size(); i++) {

			//Check if the title exists in the store	
			if (store.getItemsInStore().get(i).getTitle().equals(title)) {
				found = true;
				break;
			}		
		}

		if (found) {
			return i;
		}
		else {
			return -1;
		}
	}

	//Still find Media index from user title input but for Cart, not for Store
	public static int find_Index_Of_Media_From_Title_User_Input(Cart cart) {
		//Let user enter a media title to see its details
		System.out.println("Enter the title of the media you want to see : ");
		Scanner userInput = new Scanner(System.in);
		String title = userInput.nextLine();


		// Find that media in the store
		int i = 0;  //Use i to get index of the media user searched for
		boolean found = false;
		for (i = 0; i < cart.getItemsOrdered().size(); i++) {

			//Check if the title exists in the store	
			if (cart.getItemsOrdered().get(i).getTitle().equals(title)) {
				found = true;
				break;
			}		
		}

		if (found) {
			return i;
		}
		else {
			return -1;
		}
	}

	public static void PlayMedia(Media media) {   //Play method is only available for DVD and CD
		if (media instanceof DigitalVideoDisc) {
			((DigitalVideoDisc) media).play();
		}
		else if (media instanceof CompactDisc) {
			((CompactDisc) media).play();
		}
		else {
			System.out.println("This media is not playable");
		}
		
	}


	public static Media FromInputToNewMedia(int which_to_add) {

		Scanner scanner = new Scanner(System.in);
		if (which_to_add == 0) {
			//DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87, 19.95f)
			System.out.println("For DVD, enter by this format: title, category, director, length, cost   Split by '-' "); 
			String[] dvd = scanner.nextLine().split("-");
			return (Media) new DigitalVideoDisc(dvd[0], dvd[1], dvd[2], Integer.parseInt(dvd[3]), Float.parseFloat(dvd[4]));

		}
		else if (which_to_add == 1) {
			//CompactDisc("TopGun","Action","CTA","TomCruise",0, 24.95f);
			System.out.println("For CD, enter by this format: title, category, director, artist , length, cost Split by '-' ");
			String[] cd = scanner.nextLine().split("-");
			CompactDisc newCD =  new CompactDisc(cd[0], cd[1], cd[2], cd[3], Integer.parseInt(cd[4]), Float.parseFloat(cd[5]));

			//Add Tracks
			System.out.println("Enter the number of tracks: ");
			int n = scanner.nextInt();
			scanner.nextLine();  //Consume the newline character otherwise it will be read in the next loop -> Error
			//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
			for (int i = 0; i < n; i++) {
				System.out.println("Enter by format title-length of the track: ");
				String[] titleAndlength = scanner.nextLine().split("-");
				newCD.addTrack(new Track(titleAndlength[0], Integer.parseInt(titleAndlength[1])));
			}

			return (Media) newCD;  //Since the return type is Media, need Upcasting

		}
		else if (which_to_add == 2) {
			//Book book1 = new Book("DarkNhanTam","Selfhelp", 20.5f);
			// book1.addAuthor("Dale Carnegie");
			// book1.addAuthor("CTA");
			// store.addMedia(book1);
			System.out.println("For Book, enter by this format: title, category, cost Split by '-' ");
			String[] book = scanner.nextLine().split("-");
			Book newBook = new Book(book[0], book[1], Float.parseFloat(book[2]));

			//Add authors
			System.out.println("Enter the number of authors: ");
			int n = scanner.nextInt();
			scanner.nextLine();  //Consume the newline character otherwise it will be read in the next loop -> Error
			for (int i = 0; i < n; i++) {
				System.out.println("Enter the name of the author: ");
				String author = scanner.nextLine();
				newBook.addAuthor(author);
			}

			return (Media) newBook;
		}

		else {
			System.out.println("Can Not Add New Media base on your input");
			return null;
		}
	}
	
}

