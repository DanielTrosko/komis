import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Car> cos = new ArrayList<Car>();
        Car car1 = new Car("niebieski", new BigDecimal(23200), 5, "Ford", 250600, 2007);
        Car car2 = new Car("czerwony", new BigDecimal(22900), 4, "Fiat", 190400, 2015);
        Car car3 = new Car("niebieski", new BigDecimal(33800), 3, "Bmw", 189500, 2007);
        Car car4 = new Car("zielony", new BigDecimal(13600), 4, "Fiat", 320600, 2019);
        Car car5 = new Car("czarny", new BigDecimal(160300), 5, "Skoda", 240600, 2007);
        cos.add(car1);
        cos.add(car2);
        cos.add(car3);
        cos.add(car4);
        cos.add(car5);


        for (int i = 0; i < cos.size(); i++) {
            System.out.println(cos.get(i));
        }
        Car car6 = new Car("malinowy", new BigDecimal(25000), 5, "Suzuki", 2500, 1991);
        cos.add(car6);
        System.out.println("dodany car");

        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(cos);

            o.close();
            f.close();

            for (int i = 0; i < cos.size(); i++) {
                System.out.println(cos.get(i));
            }
            System.out.println("Kolejna");

            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
//            Person pr1 = (Person) oi.readObject();
//            Person pr2 = (Person) oi.readObject();
            List<Car> p = new ArrayList<Car>();
            p = (ArrayList<Car>) oi.readObject();
//            System.out.println(pr1.toString());
//            System.out.println(pr2.toString());
            for (int i = 0; i < p.size(); i++) {
                System.out.println(p.get(i));
            }

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
