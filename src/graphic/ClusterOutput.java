package graphic;

import entity.Cluster;

import java.util.Collections;
import java.util.List;

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
