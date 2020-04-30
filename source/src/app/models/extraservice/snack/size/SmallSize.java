package app.models.extraservice.snack.size;

public class SmallSize implements SizeState {

    private double tax = 0.2;
    private final String size = "SMALL";

    public SmallSize() {}

    public SmallSize(double tax) {

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