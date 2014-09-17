package entity;


import java.awt.*;
import java.util.*;
import java.util.List;

public class ObservationContainer {

    private static final int X_LIMIT = 1050;

    public static final long Y_LIMIT = 710;

    private List<Observation> observations;

    public ObservationContainer(int observationsCount) {
        observations = new LinkedList<Observation>();
        generateObservations(observationsCount);
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public List<Cluster> createRandomEmptyClusters(int clusterCount) {
        List<Cluster> clusters = new ArrayList<Cluster>();

        for(int i = 0; i < clusterCount; i++) {
            clusters.add(new Cluster(getRandomObservation(), getRandomColor()));
        }
        return clusters;
    }

    private Color getRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        return new Color(r, g, b);
    }


    private Observation getRandomObservation() {
        Random random = new Random();
        int index =  random.nextInt(observations.size() - 1);
        return observations.get(index);
    }

    private void generateObservations(int observationsCount) {

        while(observations.size() < observationsCount) {
            double x = Math.random() * X_LIMIT;
            double y = Math.random() * Y_LIMIT;
            Observation observation =
                    new Observation(x, y);
            observations.add(observation);
        }

    }




}
