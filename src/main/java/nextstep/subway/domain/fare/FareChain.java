package nextstep.subway.domain.fare;

public abstract class FareChain {

    private static final int OVER_FARE = 100;
    private FareChain nextChain;

    public FareChain setNextChain(FareChain nextChain) {
        this.nextChain = nextChain;
        return nextChain;
    }

    public abstract boolean isOverFare(int distance);

    public abstract int calculateFare(int distance);

    public final int calculate(int distance) {
        if(isOverFare(distance)) {
            return calculateFare(distance);
        }
        if(nextChain != null) {
            return nextChain.calculate(distance);
        }
        return 0;
    }

    public final int calculateOverFare(int distance, int distancePer) {
        return (int) ((Math.ceil((distance - 1) / distancePer) + 1) * OVER_FARE);
    }

}
