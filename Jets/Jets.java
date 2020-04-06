package Jets;

import java.text.DecimalFormat;
import java.text.NumberFormat;

abstract public class Jets {
    private String model;
    private double speed;
    private int range;
    private long price;
    private final double machUnit = 767.269148;

    public Jets(String model, double speed, int range, long price) {
        this.model = model;
        this.speed = speed;
        this.range = range;
        this.price = price;
    }

    public void fly(){
        System.out.println(getModel() + " flies at " + getSpeed() + " mph at a range of " + getRange() +
                ".\nIt would run out of fuel at "  + String.format("%,.2f", (getRange() / getSpeed())) + " hours."
                +"\n**********************************");
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName() + "{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                ", range=" + range +
                ", price=" + price +
                '}';
    }

    public String dataToFile(){
        return "Model: " + model + "\nSpeed: " + speed + "\nRange: " + range + "\nPrice: " + NumberFormat.getCurrencyInstance().format(price);
    }

    public String getModel() {
        return model;
    }

    public double getSpeed() {
        return speed;
    }

    public int getRange() {
        return range;
    }

    public long getPrice() {
        return price;
    }

    public double getMachUnit() {
        return machUnit;
    }
}
