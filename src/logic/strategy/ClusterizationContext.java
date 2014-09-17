package logic.strategy;

import entity.Cluster;
import entity.Observation;
import entity.ObservationContainer;

import javax.swing.*;
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

    public void executeStrategy() {
        strategy.execute();
    }


}
