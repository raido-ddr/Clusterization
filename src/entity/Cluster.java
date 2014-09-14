package entity;


import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cluster {

    private List<Observation> observations =
            new ArrayList<Observation>();

    private Observation mean;

    private Color color;

    public Cluster(Observation mean) {
        this.mean = mean;
    }

    public List<Observation> getObservations() {
        return Collections.unmodifiableList(observations);
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public Observation getMean() {
        return mean;
    }

    public void setMean(Observation mean) {
        this.mean = mean;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public void addPoint(Observation observation) {
        observations.add(observation);
    }

    public boolean adjustMeanByDeviation() {

        boolean needsAdjustment = false;

        double minDeviation = Double.MAX_VALUE;

        Observation currentMean = getMean();
        Observation nextMean = currentMean;

        double deviation = 0;
        for(Observation meanCandidate : observations) {
            deviation = calculateDeviation(meanCandidate);

            if(deviation < minDeviation) {
                minDeviation = deviation;
                nextMean = meanCandidate;
            }
        }

        if(! currentMean.equals(nextMean)) {
            if(nextMean == null) {
                System.out.println("mean null");
                System.out.println(deviation);
            }
            setMean(nextMean);
            needsAdjustment = true;
        }

        return needsAdjustment;
    }

    private double calculateDeviation(Observation mean) {
        double distanceSum = 0;
        for(Observation observation : observations) {
            distanceSum += mean.calculateDistanceTo(observation);
        }
        return (distanceSum / observations.size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cluster:\n\r")
                .append("Obs. count: ")
                .append(observations.size())
                .append("\n\r")
                .append("Mean: ")
                .append(getMean())
                .append("\n\r");

       /* for(Observation observation : observations) {
            sb.append(observation.toString())
                    .append("\n\r");
        }*/

        return sb.toString();

    }

    public void clearObservations() {
        observations.clear();
    }
}
