package logic.strategy.impl;

import entity.Cluster;
import entity.Observation;
import entity.ObservationContainer;
import graphic.ClusterOutput;
import graphic.GraphicOutput;
import logic.strategy.ClusterizationStrategy;

import javax.swing.*;
import java.util.List;

public class KMeansStrategy extends ClusterizationStrategy  {

    private List<Cluster> clusters;

    private ObservationContainer container;

    private int clusterCount;

    private GraphicOutput output =
            GraphicOutput.getInstance();

    public KMeansStrategy(List<Cluster> clusters,
            ObservationContainer container, int clusterCount) {
        this.clusters = clusters;
        this.container = container;
        this.clusterCount = clusterCount;
    }


    public List<Cluster> performClusterization(List<Cluster> clusters,
            ObservationContainer container, int clusterCount) {

        if(clusters == null) {
            clusters = container.createRandomEmptyClusters(clusterCount);
        }

        new Thread(new ClusterOutput(clusters)).start();

        int  i = 0;
        do {
            resetClusters(clusters);
            for (Observation observation : container.getObservations()) {
                assignCluster(clusters, observation);
            }

            new Thread(new ClusterOutput(clusters)).start();

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


    @Override
    protected List<Cluster> doInBackground() throws Exception {

        if(clusters == null) {
            clusters = container.createRandomEmptyClusters(clusterCount);
        }

        //new Thread(new ClusterOutput(clusters)).start();
        publish(clusters);

        int  i = 0;
        do {
            resetClusters(clusters);
            for (Observation observation : container.getObservations()) {
                assignCluster(clusters, observation);
            }

            //new Thread(new ClusterOutput(clusters)).start();
            publish(clusters);

            System.out.println("Iteration " + i++);

        } while (! isOptimal(clusters));

        return clusters;
    }

    @Override
    protected void process(List<List<Cluster>> chunks) {
        output.clearImage();
        output.drawClusters(chunks.get(0));
    }

    @Override
    protected void done() {
        for(Cluster cluster : clusters) {
            System.out.println(cluster.toString());
        }
    }
}
