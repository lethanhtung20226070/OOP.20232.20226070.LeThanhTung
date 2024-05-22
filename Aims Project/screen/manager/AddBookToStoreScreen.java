package hust.soict.cybersec.aims.screen.manager;

import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.store.Store;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    //Book attributes
    private JTextField title;
    private JTextField category;
    private JTextField cost;
    //Temporary ignore the author attribute of the book

    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    public JPanel createInputWindow() {
        JPanel centre = new JPanel(new GridLayout(4, 1)); // 4 rows, 1 column
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

        JPanel costPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        costPanel.add(new JLabel("Cost: "));
        JTextField cost = new JTextField();
        cost.setPreferredSize(new Dimension(200, 20)); // Set preferred size for the text field
        costPanel.add(cost);
        centre.add(costPanel);

        //Add the add button
        JButton addButton = new JButton("Add this book to store");
        addButton.addActionListener(actionEvent -> {
            //Add the new book to the store model
            store.addMedia(new Book(title.getText(), category.getText(), Float.parseFloat(cost.getText())));
            System.out.println("Book added to store");
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(addButton);
        centre.add(buttonPanel);

        return centre;
    }

    //Event handler for the add button
    public class AddBookClickListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Add the new book to the store model
            store.addMedia(new Book(title.getText(), category.getText(), Float.parseFloat(cost.getText())));
            System.out.println("Book added to store");
        }
    }
}