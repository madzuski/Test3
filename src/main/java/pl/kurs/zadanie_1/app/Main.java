package pl.kurs.zadanie_1.app;

import pl.kurs.zadanie_1.datatypes.*;
import pl.kurs.zadanie_1.datatypes.Closet;
import pl.kurs.zadanie_1.services.Clothing;

import java.io.IOException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Closet closet = new Closet();

        Shirt shirt1 = new Shirt("Blue Shirt", "M", 29.99);
        Shirt shirt2 = new Shirt("Red Shirt", "L", 34.99);
        Jeans jeans1 = new Jeans("Blue Jeans", "S", 49.99);

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

        try {
            closet.saveToFile("closet.dat");
            System.out.println("\nCloset saved to file.");

            Closet newCloset = new Closet();
            newCloset.loadFromFile("closet.dat");
            System.out.println("\nLoaded clothes from file:");
            for (Clothing clothing : newCloset) {
                System.out.println(clothing);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error handling file operations: " + e.getMessage());
        }
    }
} 