package logic.strategy;

import entity.Cluster;
import entity.Observation;
import entity.ObservationContainer;

import java.util.ArrayList;
import java.util.List;

public interface ClusterizationStrategy {

    List<Cluster> performClusterization(List<Cluster> clusters,
            ObservationContainer container, int clusterCount);
}
