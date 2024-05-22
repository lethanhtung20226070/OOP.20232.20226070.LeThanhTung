package hust.soict.cybersec.aims.media;

import java.util.Comparator;

import hust.soict.cybersec.aims.cart.MediaComaratorByCostTitle;
import hust.soict.cybersec.aims.cart.MediaComparatorByTitleCost;



public abstract class Media {

	private  int id;
	private String title;
	private String category;
	private float cost;

	public static final  Comparator<Media> COMPARAE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComaratorByCostTitle();
	
	public Media(String title, String category, float cost) {
		super();
		this.id = 0;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	//Methods
	
	/*
	 * <<Contains code structure>>
	 * public boolean contains(Object o) {
    // Iterate through each element in the ArrayList
    for (int i = 0; i < size; i++) {
        // Get the element at index i
        Object element = elementData[i];
        
        // Check if the element is equal to the target object using equals()
        if (element == null) {
            if (o == null) {
                return true; // Both are null, consider as equal
            }
        } else if (element.equals(o)) {
            return true; // Found a matching element
        }
    }
    return false; // Element not found in the ArrayList
}


Ref: https://stackoverflow.com/questions/53576836/using-contains-method-in-java

in your Teacher class you should override equals method and define for the program what is your strategy for the equality of two objects. Then you can perfectly use contains method.

Take note a better solution is to use Set.
*/
	

    @Override
    public boolean equals(Object obj) {
 
        // If the object is compared with itself then return true  
        if (obj == this) {
            return true;
        }
 
        /* Check if obj is an instance of Media or not */
        if (!(obj instanceof Media)) {
            return false;
        }
         
        // typecast obj to Media so that we can compare data members 
        Media other = (Media) obj;
         
        // Compare titles for equality
        return this.title.equals(other.title);
    }
    
    
    public String toString() {
    	//TODO ...........
    	return "Please override this :))";
    }
	
	


	//Getter and Setter
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}
	
	

}
