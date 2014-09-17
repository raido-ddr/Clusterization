package logic.strategy.impl;

import entity.Cluster;
import entity.Observation;
import entity.ObservationContainer;
import graphic.ClusterDrawer;
import graphic.GraphicOutput;
import logic.strategy.ClusterizationStrategy;

import java.util.List;

public class KMeansStrategy implements ClusterizationStrategy {

    @Override
    public List<Cluster> performClusterization(List<Cluster> clusters,
            ObservationContainer container, int clusterCount) {

        if(clusters == null) {
            clusters = container.createRandomEmptyClusters(clusterCount);
        }

        new Thread(new ClusterDrawer(clusters)).start();

        int  i = 0;
        do {
            resetClusters(clusters);
            for (Observation observation : container.getObservations()) {
                assignCluster(clusters, observation);
            }

            new Thread(new ClusterDrawer(clusters)).start();

            System.out.println("Iteration " + i++);

        } while (! isOptimal(clusters));

        return clusters;

    }

    private void resetClusters(List<Cluster> clusters) {
        for(Cluster cluster : clusters) {
            cluster.clearObservations();
        }
    }

    private void assignCluster(List<Cluster> clusters, Observation observation) {
        double minDistance = Double.MAX_VALUE;
        Cluster closestCluster = null;

        for(Cluster cluster : clusters) {
            double distance = observation.calculateDistanceTo(cluster.getMean());
            if(distance < minDistance) {
                minDistance = distance;
                closestCluster = cluster;
            }
        }

        closestCluster.addPoint(observation);
    }

    private boolean isOptimal(List<Cluster> clusters) {

        boolean isClusterizationOptimal = true;

        //clusters.parallelStream().forEach(c -> c.adjustMeanByDeviation());

        for(Cluster cluster : clusters) {
            if(cluster.adjustMeanByDeviation()) {
                isClusterizationOptimal = false;
            }
        }

        return isClusterizationOptimal;
    }




}
