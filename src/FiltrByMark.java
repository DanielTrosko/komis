import java.util.function.Predicate;

public class FiltrByMark implements Predicate<Car> {
    private final String a;

    public FiltrByMark(String a) {
        this.a = a;
    }

    @Override
    public boolean test(Car car) {
        return car.getMark().equals(a);
    }
}
