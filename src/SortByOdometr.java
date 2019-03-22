import java.util.Comparator;

public class SortByOdometr implements Comparator<Car> {
    @Override
    public int compare(Car t1, Car t2) {
        return Integer.compare(t1.getOdometer(), t2.getOdometer());
    }
}
