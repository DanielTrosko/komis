import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static List<Car> cars = new ArrayList<Car>();
    public static Scanner scanner = new Scanner(System.in);
    private static int CESAR_STEP = 0; //9

    public static void main(String[] args) {
        System.out.println("Podaj step by odszyfrowac");
        CESAR_STEP = scanner.nextInt();
        try {
            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            cars = (ArrayList<Car>) oi.readObject();
            for (int i = 0; i < cars.size(); i++) {
                String Mark = CesarCrypt.encodeCesar(cars.get(i).getMark(), CESAR_STEP);
                cars.get(i).setMark(Mark);
                String colour = CesarCrypt.encodeCesar(cars.get(i).getColour(), CESAR_STEP);
                cars.get(i).setColour(colour);
            }
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        int select = 0;

        Menu.menu1();
        select = scanner.nextInt();
        switch (select) {
            case 1:
                try {
                    String addCar;
                    do {
                        cars.add(Menu.addCar());
                        System.out.println("Chcesz dodac kolejne auto? (tak/nie)");
                        addCar = scanner.next();
                    } while (addCar.equals("tak"));
                    Menu.menu1();
                } catch (Exception A) {
                    System.out.println("Zle podany parametr");
                }
                break;
            case 2:
                for (Car car : cars) {
                    System.out.println(car);
                }
                System.out.println();
                Menu.menu2();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        //sortowanie
                        try {
                            Menu.sortMenu();
                        } catch (Exception A) {
                            System.out.println("Zle podany parametr");
                        }

                        break;
                    case 2:
                        //filtrowanie
                        try {
                            Menu.filtrMenu();
                        } catch (Exception A) {
                            System.out.println("Zle podany parametr");
                        }

                        break;
                    case 3:
                        //dodatkowe
                        try {
                            Menu.filtrPlusSort();
                        } catch (Exception A) {
                            System.out.println("Zle podany paramtr");
                        }
                        break;
                }
                break;
            case 3:
                try {
                    Menu.deleteCar();
                } catch (Exception A) {
                    System.out.println("Zle podany parametr");
                }

                break;
        }

        try {

            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            System.out.println("Podaj step by zaszyfrowac");
            CESAR_STEP = scanner.nextInt();
            for (int i = 0; i < cars.size(); i++) {
                String Mark = CesarCrypt.decodeCesar(cars.get(i).getMark(), CESAR_STEP);
                cars.get(i).setMark(Mark);
                String colour = CesarCrypt.decodeCesar(cars.get(i).getColour(), CESAR_STEP);
                cars.get(i).setColour(colour);
            }


            o.writeObject(cars);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

        System.out.println("Bye Bye");
        System.out.println("Plik zaszyfrowany zapamietaj step: " + CESAR_STEP);
    }
}
