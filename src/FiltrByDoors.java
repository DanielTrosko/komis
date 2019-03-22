import java.util.function.Predicate;

public class FiltrByDoors implements Predicate<Car> {
    private final int a;

    public FiltrByDoors(int a) {
        this.a = a;
    }

    @Override
    public boolean test(Car car) {
        //TODO nie dziala

        return car.getDoors() == (a);
    }
}
