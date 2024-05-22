package hust.soict.cybersec.aims.media;



public class Track  implements Playable{
	
	private String title;
	private int length;
	
	//Constructor
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	
	//Method
	public String play() {
        return "Playing track: " + this.getTitle() + "\nTrack length: " + this.getLength();
	}
	
    @Override
    public boolean equals(Object obj) {
 
        // If the object is compared with itself then return true  
        if (obj == this) {
            return true;
        }
 
        /* Check if obj is an instance of Media or not */
        if (!(obj instanceof Track)) {
            return false;
        }
         
        // typecast obj to Media so that we can compare data members 
        Track other = (Track) obj;
         
        // Compare titles for equality
        return this.title.equals(other.title) && this.length == other.length;
    }
	
	
	//Getter and Setter
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	
	
	

}
