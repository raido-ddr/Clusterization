package logic.strategy.task;

import entity.Cluster;
import entity.ObservationContainer;
import logic.strategy.ClusterizationContext;
import logic.strategy.impl.KMeansStrategy;
import main.MainForm;

import javax.swing.*;
import java.util.List;


public class ClusterizationTask extends SwingWorker<Void, List<Cluster>> {

    private int clusterCount = 0;

    private int observationCount = 0;

    public ClusterizationTask(int clusterCount, int observationCount) {
        this.clusterCount = clusterCount;
        this.observationCount = observationCount;
    }

    @Override
    protected Void doInBackground() throws Exception {

        ClusterizationContext context =
                new ClusterizationContext(new KMeansStrategy());

        ObservationContainer container =
                new ObservationContainer(observationCount);

        List<Cluster> clusters =
                context.executeStrategy(null, container, clusterCount);

        for(Cluster cluster : clusters) {
            System.out.println(cluster.toString());
        }

        return null;
    }


}
