package logic.strategy;

import entity.Cluster;
import entity.Observation;
import entity.ObservationContainer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ClusterizationStrategy
        extends SwingWorker<List<Cluster>, List<Cluster>> {

    /*List<Cluster> performClusterization(List<Cluster> clusters,
            ObservationContainer container, int clusterCount);*/

}
