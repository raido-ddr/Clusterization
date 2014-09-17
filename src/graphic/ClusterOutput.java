package graphic;

import entity.Cluster;

import java.util.Collections;
import java.util.List;

/**
 * Created by Raido_DDR on 16.09.2014.
 */
public class ClusterOutput implements Runnable {

    GraphicOutput output = GraphicOutput.getInstance();

    List<Cluster> clusters;

    public ClusterOutput(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    @Override
    public void run() {
        output.clearImage();
        output.drawClusters(clusters);
    }
}