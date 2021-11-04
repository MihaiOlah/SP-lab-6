package models;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PictureContent {
    private BufferedImage myPicture_;

    public PictureContent(BufferedImage myPicture)
    {
        myPicture_ = myPicture;
    }

    public void DisplayPicture()
    {
        JLabel picLabel = new JLabel(new ImageIcon(myPicture_));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);
        JFrame f = new JFrame();
        f.setSize(new Dimension(myPicture_.getWidth(), myPicture_.getHeight()));
        f.add(jPanel);
        f.setVisible(true);
    }
}
