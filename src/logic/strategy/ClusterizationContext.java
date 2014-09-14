package logic.strategy;

import entity.Cluster;
import entity.Observation;
import entity.ObservationContainer;

import java.util.List;
import java.util.Stack;


/**
 * Created by Raido_DDR on 9/14/2014.
 */
public class ClusterizationContext {

    private ClusterizationStrategy strategy;

    public ClusterizationContext(ClusterizationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ClusterizationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Cluster> executeStrategy(List<Cluster> clusters,
            ObservationContainer container, int clusterCount) {

        return strategy.performClusterization(clusters, container, clusterCount);
    }


}
