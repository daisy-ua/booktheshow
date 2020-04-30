package app.models.extraservice.snack.size;

public class MediumSize implements SizeState {

    private double tax = 0.5;
    private final String size = "MEDIUM";

    public MediumSize() {}

    public MediumSize(double tax) {

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