package AimsProjectPacket;

public class TestPassingparameter {

	public static void main(String[] args) {
		DigitalVideoDisc jungDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungDVD,cinderellaDVD);
		System.out.println("jungle dvd title: " + jungDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungDVD,cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungDVD.getTitle());

	}
	
	public static void swap(Object o1, Object o2) {
		Object tmpObject = o1;
		o1 = o2;
		o2 = tmpObject;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title  ) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
