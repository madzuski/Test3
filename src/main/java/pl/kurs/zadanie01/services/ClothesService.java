package pl.kurs.zadanie01.services;

import pl.kurs.zadanie01.datatypes.Clothing;
import pl.kurs.zadanie01.datatypes.Jeans;
import pl.kurs.zadanie01.datatypes.Shirt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClothesService {
    public static void saveClothesToFile(Closet closet, String filename) throws IOException {
        try (
                FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            for (Clothing c : closet) {
                bw.write(c.toSingleCSVLine());
                bw.newLine();
            }
        }
    }

    public static List<Clothing> readClothesFromFile(String filename)  {
        List<Clothing> clothingList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                clothingList.add(createClothingFromString(line));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clothingList;
    }

    public static Clothing createClothingFromString (String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            return null;
        }
        String type = parts[0];
        String name = parts[1];
        Clothing.Size size = Clothing.Size.valueOf(parts[2]);
        double price = Double.parseDouble(parts[3]);

       return switch (type) {
            case "Shirt" -> new Shirt(name, size, price);
            case "Jeans" -> new Jeans(name, size, price);
           default -> null;
        };

    }
}
