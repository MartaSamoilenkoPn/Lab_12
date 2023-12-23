package task1;

public class Tray {
    private final int denom;
    private Tray next;
    private int count;

    public Tray(int denom) {
        this.denom = denom;
        this.count = 0;
    }
    public Tray setNext(Tray tray) {
        this.next = tray;
        return this;
    }

    public void process(int amount) {
        int dispCount = amount / denom;
        int remaining = amount % denom;

        if (next != null) {
            next.process(remaining);
        } else if (remaining > 0) {
            throw new IllegalArgumentException("Cannot fill the requested amount");
        }

        count += dispCount;
        System.out.println("Take " + dispCount + " of denomination " + denom);
    }

    public int getDenominationCount(int denominationToGet) {
        if (denominationToGet == denom) {
            return count;
        } else if (next != null) {
            return next.getDenominationCount(denominationToGet);
        } else {
            throw new IllegalArgumentException("Denomination is not found in the chain");
        }
    }
}
