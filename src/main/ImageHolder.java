package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Raido_DDR on 16.09.2014.
 */
public class ImageHolder extends JPanel {

    public static final int IMG_WIDTH = 1050;
    public static final int IMG_HEIGHT = 710;

    private BufferedImage canvas = null;
    private Graphics2D imgGraphics = null;

    public ImageHolder() {
        canvas = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
        imgGraphics = canvas.createGraphics();
        imgGraphics.setColor(Color.WHITE);
        imgGraphics.fillRect(0,  0,  IMG_WIDTH, IMG_HEIGHT);
        setPreferredSize(new Dimension(IMG_WIDTH, IMG_HEIGHT));
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
