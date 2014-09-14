package entity;


import java.util.*;

public class ObservationContainer {

    private static final int X_LIMIT = 600;

    public static final long Y_LIMIT = 500;

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
            clusters.add(new Cluster(getRandomObservation()));
        }
        return clusters;
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