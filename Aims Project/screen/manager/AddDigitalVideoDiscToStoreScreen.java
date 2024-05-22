package hust.soict.cybersec.aims.screen.manager;

import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.store.Store;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    // DigitalVideoDisc attributes
    private JTextField title;
    private JTextField category;
    private JTextField cost;
    private JTextField director;
    private JTextField length;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    public JPanel createInputWindow() {
        JPanel centre = new JPanel(new GridLayout(6, 1)); // 6 rows, 1 column
        centre.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add 10 pixels of padding on all sides

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(new JLabel("Title: "));
        JTextField title = new JTextField();
        title.setPreferredSize(new Dimension(200, 20)); // Set preferred size for the text field
        titlePanel.add(title);
        centre.add(titlePanel);

        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        categoryPanel.add(new JLabel("Category: "));
        JTextField category = new JTextField();
        category.setPreferredSize(new Dimension(200, 20)); // Set preferred size for the text field
        categoryPanel.add(category);
        centre.add(categoryPanel);

        JPanel directorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        directorPanel.add(new JLabel("Director: "));
        JTextField director = new JTextField();
        director.setPreferredSize(new Dimension(200, 20)); // Set preferred size for the text field
        directorPanel.add(director);
        centre.add(directorPanel);

        JPanel lengthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lengthPanel.add(new JLabel("Length: "));
        JTextField length = new JTextField();
        length.setPreferredSize(new Dimension(200, 20)); // Set preferred size for the text field
        lengthPanel.add(length);
        centre.add(lengthPanel);


        JPanel costPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        costPanel.add(new JLabel("Cost: "));
        JTextField cost = new JTextField();
        cost.setPreferredSize(new Dimension(200, 20)); // Set preferred size for the text field
        costPanel.add(cost);
        centre.add(costPanel);

        // Add the add button
        JButton addButton = new JButton("Add this DVD to store");
        addButton.addActionListener(actionEvent -> {
            // Add the new DVD to the store model
            //store.addMedia(new DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87, 19.95f));
            store.addMedia(new DigitalVideoDisc(title.getText(), category.getText(), director.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText())));
            System.out.println("DVD added to store");
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(addButton);
        centre.add(buttonPanel);

        return centre;
    }

    // Event handler for the add button
    public class AddDVDClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Add the new DVD to the store model
            store.addMedia(new DigitalVideoDisc(title.getText(), category.getText(), director.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText())));
            System.out.println("DVD added to store");
        }
    }
}