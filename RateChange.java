import java.time.LocalDateTime;

public class RateChange {
    private int rateChangeID;
    private double oldRate;
    private double newRate;
    private LocalDateTime date;
    private Dispatcher dispatcher;

    public RateChange(int rateChangeID, double oldRate, double newRate, Dispatcher dispatcher) {
        this.rateChangeID = rateChangeID;
        this.oldRate = oldRate;
        this.newRate = newRate;
        this.dispatcher = dispatcher;
        this.date = LocalDateTime.now();
    }

    public int getRateChangeID() { return rateChangeID; }
}
