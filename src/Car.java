import java.io.Serializable;
import java.math.BigDecimal;

public class Car implements Serializable {
    private String colour;
    private BigDecimal price;
    private int doors;
    private String mark;
    private int odometer;
    private int year;

    public Car() {
    }

    public Car(String colour, BigDecimal price, int doors, String mark, int odometer, int year) {
        this.colour = colour;
        this.price = price;
        this.doors = doors;
        this.mark = mark;
        this.odometer = odometer;
        this.year = year;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "colour='" + colour + '\'' +
                ", price=" + price +
                ", doors=" + doors +
                ", mark='" + mark + '\'' +
                ", odometer=" + odometer +
                ", year=" + year +
                '}';
    }
}