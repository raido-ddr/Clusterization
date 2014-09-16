package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Raido_DDR on 16.09.2014.
 */
public class ImageHolder extends JPanel {

    private BufferedImage canvas = null;
    private Graphics2D imgGraphics = null;

    public ImageHolder() {
        int imgWidth = getWidth();
        int imgHeight = getHeight();
        canvas = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        imgGraphics = canvas.createGraphics();
        //imgGraphics.setColor(Color.BLUE);
        //imgGraphics.fillRect(0,  0,  imgWidth, imgHeight);
        setPreferredSize(new Dimension(imgWidth, imgHeight));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        //g2d.setPaint(Color.BLUE);
        g2d.fillRect(0,  0,  width, height);
        g2d.drawImage(canvas, 0, 0, null);
        //drawWindow((Graphics2D) imgGraphics);
    }

    public  BufferedImage getBufferedImage() {
        return canvas;
    }
}
