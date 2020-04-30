package app.models.extraservice.snack.size;

public class LargeSize implements SizeState {

    private double tax = 0.7;
    private final String size = "LARGE";

    public LargeSize() {}

    public LargeSize(double tax) {

        this.tax = tax;
    }

    public void setTax(double tax) {

        this.tax = tax;
    }

    @Override 
    public double getTax() {

        return this.tax;
    }

    @Override
    public String getSize() {

        return this.size;
    }
}