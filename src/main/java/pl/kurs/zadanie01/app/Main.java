package pl.kurs.zadanie01.app;

import pl.kurs.zadanie01.datatypes.Closet;
import pl.kurs.zadanie01.datatypes.Criterion;
import pl.kurs.zadanie01.datatypes.Jeans;
import pl.kurs.zadanie01.datatypes.Shirt;
import pl.kurs.zadanie01.services.Clothing;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Closet closet = new Closet();

        Shirt shirt1 = new Shirt("Blue Shirt", Clothing.Size.M, 29.99);
        Shirt shirt2 = new Shirt("Red Shirt", Clothing.Size.L, 34.99);
        Jeans jeans1 = new Jeans("Blue Jeans", Clothing.Size.S, 49.99);

        closet.addClothing(shirt1);
        closet.addClothing(shirt2, jeans1);

        System.out.println("All clothes in the closet:");
        for (Clothing clothing : closet) {
            System.out.println(clothing);
        }

        Clothing largest = Collections.max(closet.getClothes());
        System.out.println("\nLargest clothing by size: " + largest);

        Clothing.setCriteriaSort(Criterion.VALUE);
        Clothing mostExpensive = Collections.max(closet.getClothes());
        System.out.println("Most expensive clothing: " + mostExpensive);


        Clothing.saveClothesToFile(closet,"closet.txt");

            try {
                List<Clothing> clothing = Clothing.readClothesFromFile("closet.txt");
                for (Clothing c : clothing) {
                    System.out.println(c);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);            }


    }
} 