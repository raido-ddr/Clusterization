package main;

import entity.Cluster;
import entity.ObservationContainer;
import logic.strategy.ClusterizationContext;
import logic.strategy.impl.KMeansStrategy;

import java.util.List;


/**
 * Created by Raido_DDR on 9/14/2014.
 */
public class MainRunner {

    public static final int OBSERVATION_COUNT = 10000;
    public static final int CLUSTER_COUNT = 8;

    public static void main(String[] args) {
        ObservationContainer container =
                new ObservationContainer(OBSERVATION_COUNT);

        ClusterizationContext context =
                new ClusterizationContext(new KMeansStrategy());

        List<Cluster> clusters =
                context.executeStrategy(null, container, CLUSTER_COUNT);

        for(Cluster cluster : clusters) {
            System.out.println(cluster.toString());
        }
    }
}
