package AimsProjectPacket;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	public  int qtyOrder = 0; 
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrder>=20) System.out.println("The cart is almost full");
		else {
			itemsOrdered[qtyOrder] = disc;
			qtyOrder++;
			System.out.println("The disc " +disc.getTitle()  + " has been added");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) { 
		int numOfDiscToAdd = dvdList.length;
		System.out.println("\nNumber of  disk will be added: " + numOfDiscToAdd);
		if ((numOfDiscToAdd+qtyOrder) >=20) System.out.println("The cart is almost full");
		else {
			for (int i=0; i<numOfDiscToAdd; i++) {
				itemsOrdered[qtyOrder+i] = dvdList[i];
				System.out.println("The disc " + dvdList[i].getTitle()  + " has been added");
			}
			qtyOrder += numOfDiscToAdd;
		
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) { 
		int numOfDiscToAdd = 2;
		System.out.println("\nNumber of  disk will be added: " + numOfDiscToAdd);
		if ((numOfDiscToAdd+qtyOrder) >=20) System.out.println("The cart is almost full");
		else {
			itemsOrdered[qtyOrder] = dvd1;
			itemsOrdered[qtyOrder+1] = dvd2;
			qtyOrder += numOfDiscToAdd;
		
		}
	}
	
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {  
		
		for (int i=0; i<qtyOrder; i++) { 
			if (itemsOrdered[i] == disc) {

				for (int j=i; j<qtyOrder-1; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrder-1] = null;  
			}
		}
		qtyOrder--;
		System.out.println("The disc " + disc.getTitle() + " has been removed");
	}

	public float totalCost() {
		float sum = 0;
		System.out.println("Number of discs: "  + qtyOrder);
		for (int i=0; i<qtyOrder; i++) {
			
			System.out.println(itemsOrdered[i].getId() +" "+ itemsOrdered[i].getTitle() +" "+ itemsOrdered[i].getCost());
			
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
}

