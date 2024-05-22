package hust.soict.cybersec.aims.screen.manager;

import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private final Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");

            //Enevnt listener for the play button
            playButton.addActionListener(e -> {
                Playable playable = (Playable) media;
                //use JDialog to show the message
                JDialog dialog = new JDialog();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(null);
                dialog.setLayout(new BorderLayout());


                // Add a JLabel to the JDialog to display the message
                JLabel messageLabel = new JLabel(((Playable) media).play());
                messageLabel.setHorizontalAlignment(JLabel.CENTER);
                dialog.add(messageLabel, BorderLayout.CENTER);

                dialog.setVisible(true);
            });
            container.add(playButton);

        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}
