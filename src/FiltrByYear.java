import java.util.function.Predicate;

public class FiltrByYear implements Predicate<Car> {
    private final int a;

    public FiltrByYear(int a) {
        this.a = a;
    }

    @Override
    public boolean test(Car car) {
        return car.getYear() == (a);
    }
}
