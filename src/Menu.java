import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Menu {
    public static List<Car> cars1 = new ArrayList<Car>(Main.cars);
    public static Scanner scanner = new Scanner(System.in);

    public static Car addCar() {
        Car car = new Car();
        System.out.println("Podaj kolor");
        String colour = scanner.next();
        car.setColour(colour);

        System.out.println("Podaj cene");
        BigDecimal price = scanner.nextBigDecimal();
        car.setPrice(price);

        System.out.println("Podaj liczbe drzwi");
        int doors = scanner.nextInt();
        car.setDoors(doors);

        System.out.println("Podaj marke");
        String mark = scanner.next();
        car.setMark(mark);

        System.out.println("Podaj stanb licznika");
        int odometr = scanner.nextInt();
        car.setOdometer(odometr);

        System.out.println("Podaj rocznik");
        int year = scanner.nextInt();
        car.setYear(year);
        System.out.println("Samochod dodany");
        return car;
    }

    public static void deleteCar() {
        for (int i = 0; i < Main.cars.size(); i++) {
            System.out.println("Numer: " + i + " " + Main.cars.get(i));
        }
        System.out.println("Ktore auto chcesz usunac?");
        int delete = scanner.nextInt();
        Main.cars.remove(delete);
        System.out.println("Samochód usuniety");
        menu1();
    }

    public static void menu1() {
        System.out.println("Witaj w komisie");
        System.out.println("Co chcesz zrobic?");
        System.out.println("1. Dodac nowy samochód");
        System.out.println("2. Wyswietlic liste samochodow");
        System.out.println("3. Usunac sdamochod");
        System.out.println("4. Zakonczyc program");
    }

    public static void menu2() {
        System.out.println("Co chcesz zrobic?");
        System.out.println("1. Posortowac");
        System.out.println("2. Przefiltrowac");
        System.out.println("3. Dodatkowe");
        System.out.println("4. Wyjsc");
    }

    public static void sortMenu() {
        //TODO to trzeba przerobic na jedna metode i dodac do maina.

        System.out.println("1. Po kolorze");
        System.out.println("2. Po cenie");
        System.out.println("3. Po liczbie drzwi");
        System.out.println("4. Po marce");
        System.out.println("5. Po przebiegu");
        System.out.println("6. Po roczniku");
        System.out.println("7. Wyjsc");
        int a = scanner.nextInt();
        do {
            switch (a) {
                case 1:
                    Main.cars.sort(new SortByColour());
                    for (Car car : Main.cars) {
                        System.out.println(car);
                    }
                    break;
                case 2:
                    Main.cars.sort(new SortByPrice());
                    for (Car car : Main.cars) {
                        System.out.println(car);
                    }
                    break;
                case 3:
                    Main.cars.sort(new SortByDoor());
                    for (Car car : Main.cars) {
                        System.out.println(car);
                    }
                    break;
                case 4:
                    Main.cars.sort(new SortByMark());
                    for (Car car : Main.cars) {
                        System.out.println(car);
                    }
                    break;
                case 5:
                    Main.cars.sort(new SortByOdometr());
                    for (Car car : Main.cars) {
                        System.out.println(car);
                    }
                    break;
                case 6:
                    Main.cars.sort(new SortByYear());
                    for (Car car : Main.cars) {
                        System.out.println(car);
                    }
                    break;
            }
        } while (a == 6);
        menu1();
    }

    public static void filtr(Predicate<Car> a) {
        Main.cars.stream()
                .filter(a)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void filTemp(Predicate<Car> a) {
        cars1.stream()
                .filter(a)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


    public static void filtrMenu() {
        System.out.println("Filtrowanie po:");
        System.out.println("1. Po kolorze");
        System.out.println("2. Po liczbie drzwi");
        System.out.println("3. Po marce");
        System.out.println("4. Po roczniku");
        System.out.println("5. Wyjsc");
        int filtr = scanner.nextInt();
        do {
            switch (filtr) {
                case 1:
                    System.out.println("Wpisz kolor");
                    String colour = scanner.next();
                    filtr(new FiltrByColour(colour));
                    break;
                case 2:
                    System.out.println("Wpisz liczbe drzwi");
                    int door = scanner.nextInt();
                    filtr(new FiltrByDoors(door));
                    break;
                case 3:
                    System.out.println("Wpisz marke");
                    String mark = scanner.next();
                    Menu.filtr(new FiltrByMark(mark));
                    break;
                case 4:
                    System.out.println("Wpisz rocznik");
                    int year = scanner.nextInt();
                    Menu.filtr(new FiltrByYear(year));
                    break;
            }
        } while (filtr == 4);
        menu1();
    }

    public static void filtrPlusSort() {


        System.out.println("Po ktroeym polu chcesz sortowac");
        System.out.println("1. Po kolorze");
        System.out.println("2. Po cenie");
        System.out.println("3. Po liczbie drzwi");
        System.out.println("4. Po marce");
        System.out.println("5. Po przebiegu");
        System.out.println("6. Po roczniku");
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                cars1.sort(new SortByColour());
                for (Car car : cars1) {
                    System.out.println(car);
                }
                break;
            case 2:
                cars1.sort(new SortByPrice());
                for (Car car : cars1) {
                    System.out.println(car);
                }
                break;
            case 3:
                cars1.sort(new SortByDoor());
                for (Car car : cars1) {
                    System.out.println(car);
                }
                break;
            case 4:
                cars1.sort(new SortByMark());
                for (Car car : cars1) {
                    System.out.println(car);
                }
                break;
            case 5:
                cars1.sort(new SortByOdometr());
                for (Car car : cars1) {
                    System.out.println(car);
                }
                break;
            case 6:
                cars1.sort(new SortByYear());
                for (Car car : cars1) {
                    System.out.println(car);
                }
                break;
        }
        int filtrTemp;
        do {
            System.out.println("Po ktorym polu chcesz filtrowac");
            System.out.println("1. Po kolorze");
            System.out.println("2. Po liczbie drzwi");
            System.out.println("3. Po marce");
            System.out.println("4. Po roczniku");
            System.out.println("5. Zakoncz filtrowanie");
            filtrTemp = scanner.nextInt();

            switch (filtrTemp) {
                case 1:
                    System.out.println("Wpisz kolor");
                    String colour = scanner.next();
                    filTemp(new FiltrByColour(colour));
                    break;
                case 2:
                    System.out.println("Wpisz liczbe drzwi");
                    int door = scanner.nextInt();
                    filTemp(new FiltrByDoors(door));
                    break;
                case 3:
                    System.out.println("Wpisz marke");
                    String mark = scanner.next();
                    filTemp(new FiltrByMark(mark));
                    break;
                case 4:
                    System.out.println("Wpisz rocznik");
                    int year = scanner.nextInt();
                    filTemp(new FiltrByYear(year));
                    break;
            }
        } while (filtrTemp == 5);
        menu1();
    }


}
