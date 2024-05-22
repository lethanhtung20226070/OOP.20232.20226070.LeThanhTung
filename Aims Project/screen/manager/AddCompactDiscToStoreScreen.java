package hust.soict.cybersec.aims.screen.manager;

import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.store.Store;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    // CompactDisc attributes
    private JTextField title;
    private JTextField category;
    private JTextField cost;
    private JTextField director;
    private JTextField length;
    private JTextField artist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    public JPanel createInputWindow() {
        JPanel centre = new JPanel(new GridLayout(7, 1)); // 7 rows, 1 column
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

        JPanel artistPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        artistPanel.add(new JLabel("Artist: "));
        JTextField artist = new JTextField();
        artist.setPreferredSize(new Dimension(200, 20)); // Set preferred size for the text field
        artistPanel.add(artist);
        centre.add(artistPanel);

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
        JButton addButton = new JButton("Add this CD to store");
        addButton.addActionListener(actionEvent -> {
            // Add the new CD to the store model
            //CompactDisc cd1 = new CompactDisc("TopGun","Action","CTA","TomCruise",0, 24.95f);
            store.addMedia(new CompactDisc(title.getText(), category.getText(),director.getText(), artist.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText())));
            System.out.println("CD added to store");
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(addButton);
        centre.add(buttonPanel);

        return centre;
    }

    // Event handler for the add button
    public class AddCDClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Add the new CD to the store model
            store.addMedia(new CompactDisc(title.getText(), category.getText(), director.getText(), artist.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText())));
            System.out.println("CD added to store");
        }
    }
}