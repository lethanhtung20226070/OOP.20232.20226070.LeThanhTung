package hust.soict.cybersec.aims.screen.manager;

import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private static Store store;


    public StoreManagerScreen(Store store) {
        StoreManagerScreen.store = store;

        Container cp = creatContentPaneOfStoreManagerScreen();
        setContentPane(cp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //create the content panel
    //We want to separate the creat the JFrame and the content panel since we want to keep only a singe JFrame
    // on whole application, just change the content panel
    public static Container creatContentPaneOfStoreManagerScreen() {
        Container cp = new Container();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        return cp;
    }

    //Create the north of the screen UI
    static JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        System.out.println("Create North");

        //Create a menu bar
        north.add(new MenuBar(store));
        north.add(createHeader());
        return north;
    }


    static JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Aims");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        System.out.println("Header Created");
        return header;
    }

    //Create the center of the screen UI
    static JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            //MediaStore is the represent GUI elements for a Media
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }


    public static void main(String[] args) {

        //Create a new store
        Store store = new Store();
        //Add some pre media to the store
        //Add items to store
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Oppenheimer", "Science Fiction", "CTA", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Avengers: Endgame", "Action", "Anthony Russo, Joe Russo", 181, 25.99f));
        store.addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.99f));
        store.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 24.99f));


        //Some CDs with tracks
        CompactDisc cd1 = new CompactDisc("TopGun", "Action", "CTA", "TomCruise", 0, 24.95f);
        cd1.addTrack(new Track("Episode 1", 5));
        cd1.addTrack(new Track("Episode 2", 10));
        store.addMedia(cd1);

        CompactDisc cd2 = new CompactDisc("OOP", "Lab", "TrangNT", "CTA", 0, 24.95f);
        cd2.addTrack(new Track("Lab 1", 5));
        cd2.addTrack(new Track("Lab 2", 10));
        cd2.addTrack(new Track("Lab 3", 15));
        store.addMedia(cd2);

        //Some Books
        Book book1 = new Book("DarkNhanTam", "Selfhelp", 20.5f);
        book1.addAuthor("Dale Carnegie");
        book1.addAuthor("CTA");
        store.addMedia(book1);
        //Run the main window
        new StoreManagerScreen(store);
    }

}
