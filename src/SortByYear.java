import java.util.Comparator;

public class SortByYear implements Comparator<Car>{
    @Override
    public int compare(Car t1, Car t2) {
        return Integer.compare(t1.getYear(), t2.getYear());

    }
}