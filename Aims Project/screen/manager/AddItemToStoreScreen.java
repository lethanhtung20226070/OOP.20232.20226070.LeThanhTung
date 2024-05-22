package hust.soict.cybersec.aims.screen.manager;

import hust.soict.cybersec.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JPanel {

    static Store store;

    public AddItemToStoreScreen(Store store) {
        AddItemToStoreScreen.store = store;

        //Chagne the new Contrain  (from StoreManagerScreen to AssddItemToStoreScreen)
        Container cp = this;
        cp.setLayout(new BorderLayout());
        cp.add(new MenuBar(store), BorderLayout.NORTH);
        cp.add(createInputWindow(), BorderLayout.CENTER);

        //Change

    }

    public abstract JPanel createInputWindow();


}
