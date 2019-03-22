import java.util.Comparator;

public class SortByColour implements Comparator<Car> {
    @Override
    public int compare(Car t1, Car t2) {
        return t1.getColour().compareTo(t2.getColour());
    }
}
