package pl.kurs.zadanie01.services;


import pl.kurs.zadanie01.datatypes.Closet;
import pl.kurs.zadanie01.datatypes.Criterion;
import pl.kurs.zadanie01.datatypes.Jeans;
import pl.kurs.zadanie01.datatypes.Shirt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Clothing implements Comparable<Clothing> {
    private static Criterion sortCriterion = Criterion.SIZE;
    protected String name;
    protected Size size;
    protected double price;

    public Clothing(String name, Size size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String toCSV() {
        return new StringBuffer()
                .append(this.getClass().getSimpleName())
                .append(",")
                .append(name)
                .append(",")
                .append(size)
                .append(",")
                .append(price)
                .toString();

    }

    public static void saveClothesToFile(Closet clothes, String filename) throws IOException {
        try (
                FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            for (Clothing c : clothes) {
                bw.write(c.toCSV());
                bw.newLine();
            }
        }
    }

    public static List<Clothing> readClothesFromFile(String filename) throws IOException {
        List<Clothing> clothing = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    continue;
                }
                String type = parts[0];
                String name = parts[1];
                Size size = Size.valueOf(parts[2]);
                double price = Double.parseDouble(parts[3]);

                switch (type) {
                    case "Shirt":
                        clothing.add(new Shirt(name, size, price));
                        break;
                    case "Jeans":
                        clothing.add(new Jeans(name, size, price));
                        break;

                }

            }

        } catch (NumberFormatException e) {
            throw new IOException("Error parsing numeric values from file", e);
        }
        return clothing;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public static void setCriteriaSort(Criterion criterion) {
        sortCriterion = criterion;
    }

    private int compareSizes(Size size1, Size size2) {
        return size1.compareTo(size2);

    }


    @Override
    public int compareTo(Clothing other) {
        return switch (sortCriterion) {
            case SIZE -> compareSizes(this.size, other.size);
            case VALUE -> Double.compare(this.price, other.price);
        };
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }

    public enum Size {
        XXS,
        XS,
        S,
        M,
        L,
        XL,
        XXL,
    }
}

