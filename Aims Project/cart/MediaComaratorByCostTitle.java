package hust.soict.cybersec.aims.cart;

import java.util.Comparator;

import hust.soict.cybersec.aims.media.Media;

public class MediaComaratorByCostTitle implements Comparator<Media>{
    @Override

    //Override compare used in sort() method of collection
    public int compare(Media arg0, Media arg1) {
        /*    If compare(obj1, obj2) returns a negative integer (< 0), then obj1 is considered less than obj2.
    If compare(obj1, obj2) returns a positive integer (> 0), then obj1 is considered greater than obj2.
    If compare(obj1, obj2) returns 0, then obj1 is considered equal to obj2. */
        
    // // Compare strings ignoring case
        int costComparision =  Float.compare(arg0.getCost(), arg1.getCost());
        

        // If titles are the same, compare cost
        if (costComparision == 0) {
            return arg0.getTitle().compareToIgnoreCase(arg1.getTitle()); 
        }

        return costComparision;

        // return Comparator.comparing(Media::getTitle)
        //         .thenComparing(Media::getCost)
        //         .compare(arg0, arg1);
    }
}
