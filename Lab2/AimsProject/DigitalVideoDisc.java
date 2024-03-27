package AimsProjectPacket;

public class DigitalVideoDisc {

	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	private int id; 
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.id  = nbDigitalVideoDiscs.getNbDigitalVideoDiscs();  //Assign nbDigitalVideoDiscs to id
		nbDigitalVideoDiscs.setNbDigitalVideoDiscs();; //increase nbDigitalVideoDiscs by one each time new object created form this class
		
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id  = nbDigitalVideoDiscs.getNbDigitalVideoDiscs();  
		nbDigitalVideoDiscs.setNbDigitalVideoDiscs();
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id  = nbDigitalVideoDiscs.getNbDigitalVideoDiscs();  
		nbDigitalVideoDiscs.setNbDigitalVideoDiscs();
	}


	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id  = nbDigitalVideoDiscs.getNbDigitalVideoDiscs();  
		nbDigitalVideoDiscs.setNbDigitalVideoDiscs();
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
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}

	public class nbDigitalVideoDiscs {
		private static int nbDigitalVideoDiscs = 0;

		public static int getNbDigitalVideoDiscs() {
			return nbDigitalVideoDiscs;
		}

		public static void setNbDigitalVideoDiscs() {
			nbDigitalVideoDiscs +=1;
		}
	}
}
