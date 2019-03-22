import java.util.function.Predicate;

public class FiltrByColour implements Predicate<Car> {

    private final String a;

    public FiltrByColour(String a) {
        this.a = a;
    }

    @Override
    public boolean test(Car o) {
        return o.getColour().equals(a);
    }
}
