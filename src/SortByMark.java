import java.util.Comparator;

public class SortByMark implements Comparator<Car> {
    @Override
    public int compare(Car t1, Car t2) {
        return t1.getMark().compareTo(t2.getMark());
    }
}
