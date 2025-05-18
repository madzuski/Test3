package pl.kurs.zadanie_1.app;

import pl.kurs.zadanie_1.datatypes.*;
import pl.kurs.zadanie_1.services.Closet;

import java.io.IOException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // Create a new closet
        Closet closet = new Closet();

        // Create some clothes
        Shirt shirt1 = new Shirt("Blue pl.kurs.datatypes.Shirt", "M", 29.99);
        Shirt shirt2 = new Shirt("Red pl.kurs.datatypes.Shirt", "L", 34.99);
        Jeans jeans1 = new Jeans("Blue pl.kurs.datatypes.Jeans", "S", 49.99);

        // Add clothes to the closet
        closet.addClothing(shirt1);
        closet.addClothing(shirt2, jeans1);

        // Iterate over all clothes
        System.out.println("All clothes in the closet:");
        for (Clothing clothing : closet) {
            System.out.println(clothing);
        }

        // Find the largest clothing by size
        Clothing largest = Collections.max(closet.getClothes());
        System.out.println("\nLargest clothing by size: " + largest);

        // Change sorting criterion to value and find most expensive
        Clothing.setCriteriaSort(Criterion.VALUE);
        Clothing mostExpensive = Collections.max(closet.getClothes());
        System.out.println("Most expensive clothing: " + mostExpensive);

        // Save to file
        try {
            closet.saveToFile("closet.dat");
            System.out.println("\npl.kurs.datatypes.Closet saved to file.");

            // Create a new closet and load from file
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