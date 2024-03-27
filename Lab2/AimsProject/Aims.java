package AimsProjectPacket;

public class Aims {

	public static void main(String[] args) {
	
		Cart anOrderCart = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87, 19.95f);
		anOrderCart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2= new DigitalVideoDisc("Start Wars","Science Fiction","George Lucas", 87, 24.95f);
		anOrderCart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		anOrderCart.addDigitalVideoDisc(dvd3);
		
		
		anOrderCart.removeDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Kungfu Panda 4","Animation",20.01f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Oppenheimer","Science Fiction",50.99f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("TopGunMaverick","Action",69.96f);
		

		anOrderCart.addDigitalVideoDisc(dvd4,dvd6);  //Use for EX 14.1b and 14.2

		System.out.println("Total Cost is: " + anOrderCart.totalCost());
	}
}
