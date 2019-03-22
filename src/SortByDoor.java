import java.util.Comparator;

public class SortByDoor implements Comparator<Car> {
    @Override
    public int compare(Car t1, Car t2) {
        return Integer.compare(t1.getDoors(), t2.getDoors());
    }
}
