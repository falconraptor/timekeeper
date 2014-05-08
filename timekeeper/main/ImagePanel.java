package main;
import java.awt.*;
import javax.swing.*;
public class ImagePanel extends JPanel {
    private Image image;
    ImagePanel(Image imag) {image=imag;}
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
    }
}