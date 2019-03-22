import java.math.BigDecimal;
import java.util.Comparator;

public class SortByPrice implements Comparator<Car> {
    @Override
    public int compare(Car t1, Car t2) {
        return t1.getPrice().compareTo(t2.getPrice());
    }
}