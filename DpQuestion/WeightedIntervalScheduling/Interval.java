package algorithm.DpQuestion.WeightedIntervalScheduling;

public class Interval {
    private int number;
    private int startTime;
    private int endTime;
    private int weight;

    public Interval(int number, int startTime, int endTime, int weight) {
        this.number = number;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
