package entity;


import java.util.List;

public class Observation {

    private double x;

    private double y;

    private boolean isMean;

    public Observation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isMean() {
        return isMean;
    }

    public void setMean(boolean isMean) {
        this.isMean = isMean;
    }

    public double calculateDistanceTo(Observation observation) {
        double xProjection = Math.abs(observation.getX() - this.getX());
        double yProjection = Math.abs(observation.getY() - this.getY());
        return Math.sqrt(Math.pow(xProjection, 2) + Math.pow(yProjection, 2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append(getX())
                .append(", ")
                .append(getY())
                .append(")\n\r");

        return sb.toString();

    }



}
