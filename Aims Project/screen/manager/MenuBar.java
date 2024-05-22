package hust.soict.cybersec.aims.screen.manager;

import hust.soict.cybersec.aims.store.Store;

import javax.swing.*;
import java.awt.*;


//Create a MenuBar, can be called from every screen that needs a menu bar
//This menu bar also contains the event listener for the menu items (e.g. Add Book, Add CD, Add DVD)
//The event listener will change the content of the JFrame to the input form for adding a book, CD, or DVD
public class MenuBar extends JMenuBar {

    static Store store; //Menubar still needs to know the store since menuItems in the menu bar will
    // change the content of the JFrame

    public MenuBar(Store store) {
        MenuBar.store = store;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(createMenu());
    }

    private JMenu createMenu() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            //Remove all current content from the JFrame
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.getContentPane().removeAll();
            //Add new StoreManagerScreen ContentPanel to the JFrame
            //topFrame.getContentPane().add(new StoreManagerScreen(store));
            //Just new ContentPane cp like in StoreManagerScreen(store) not whole StoreManagerScreen in the topFrame
            topFrame.getContentPane().add(StoreManagerScreen.creatContentPaneOfStoreManagerScreen());
            //Assign the ContentPane of StoreManagerScreen to the new JFrame

            //Refresh the JFrame
            topFrame.revalidate();
            topFrame.repaint();
        });
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            // Remove the current content from the JFrame
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.getContentPane().removeAll();
            // Add the input form to the JFrame
            topFrame.getContentPane().add(new AddBookToStoreScreen(store));
            // Refresh the JFrame
            topFrame.revalidate();
            topFrame.repaint();
        });
        smUpdateStore.add(addBook);

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            // Remove the current content from the JFrame
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.getContentPane().removeAll();
            // Add the input form to the JFrame
            topFrame.getContentPane().add(new AddCompactDiscToStoreScreen(store));
            // Refresh the JFrame
            topFrame.revalidate();
            topFrame.repaint();
        });
        smUpdateStore.add(addCD);



        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            // Remove the current content from the JFrame
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.getContentPane().removeAll();
            // Add the input form to the JFrame
            topFrame.getContentPane().add(new AddDigitalVideoDiscToStoreScreen(store));
            // Refresh the JFrame
            topFrame.revalidate();
            topFrame.repaint();
        });
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        return menu;
    }
}