package logic.strategy.task;

import entity.Cluster;
import entity.ObservationContainer;
import logic.strategy.ClusterizationContext;
import logic.strategy.impl.KMeansStrategy;
import main.MainForm;

import javax.swing.*;
import java.util.List;


public class ClusterizationTask extends SwingWorker<Void, List<Cluster>> {

    private int clusterCount;

    private int observationCount;

    public ClusterizationTask(int clusterCount, int observationCount) {
        this.clusterCount = clusterCount;
        this.observationCount = observationCount;
    }

    @Override
    protected Void doInBackground() throws Exception {



        ObservationContainer container =
                new ObservationContainer(observationCount);

        ClusterizationContext context =
                new ClusterizationContext(new KMeansStrategy(null, container, clusterCount));


                context.executeStrategy();



        return null;
    }


}
