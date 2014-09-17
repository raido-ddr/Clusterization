package graphic;

import entity.Cluster;
import entity.Observation;
import main.ImageHolder;
import main.MainForm;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

public class GraphicOutput {

    private static final double MEAN_RADIUS = 12;
    private static final double OBSERVATION_RADIUS = 6;

    private Graphics2D g2d = null;
    private ImageHolder imageHolder = null;
    private BufferedImage bufferedImage;
    private static GraphicOutput instance = null;
    private  int imageWidth = 0;
    private  int imageHeight = 0;

    private GraphicOutput() {
        imageHolder = MainForm.getInstance().getImageHolder();
        bufferedImage = imageHolder.getBufferedImage();
        g2d = bufferedImage.createGraphics();
        imageWidth = bufferedImage.getWidth();
        imageHeight = bufferedImage.getHeight();
    }

    public static GraphicOutput getInstance() {
        if(instance == null) {
            instance = new GraphicOutput();
        }

        return instance;
    }

    public synchronized void drawClusters(List<Cluster> clusters) {

        for(Cluster cluster : clusters) {
            drawCluster(cluster);
            repaintImageHolder();
        }
    }

    private void drawCluster(Cluster cluster) {
        g2d.setColor(cluster.getColor());
        drawMean(cluster.getMean());
        for(Observation observation : cluster.getObservations()) {
            drawObservation(observation);
        }
    }

    private void drawObservation(Observation observation) {
        drawCircle(observation.getX(), observation.getY(), OBSERVATION_RADIUS);
    }

    private void drawMean(Observation mean) {
        drawCircle(mean.getX(), mean.getY(), MEAN_RADIUS);
    }

    private void drawCircle(double x, double y, double radius) {
        double cornerX = x - radius / 2.0;
        double cornerY = y - radius / 2.0;

        Ellipse2D ellipse =
                new Ellipse2D.Double(cornerX, cornerY, radius, radius);


        g2d.fill(ellipse);
    }


    public void test() {

        for(int i = 0; i < 3; i++) {
            g2d.setColor(getRandomColor());
            //g2d.setBackground(Color.ORANGE);
            g2d.drawRect(50, 50, 300, 200);
            repaintImageHolder();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void clearImage() {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        g2d.setPaint(Color.BLACK);
        g2d.fillRect(0,  0,  imageWidth, imageHeight);
        repaintImageHolder();
    }

    public void repaintImageHolder() {
        imageHolder.repaint();
    }

    private Color getRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        return new Color(r, g, b);
    }

}
