package pl.kurs.zadanie_1.datatypes;


import static pl.kurs.zadanie_1.datatypes.Criterion.SIZE;
import static pl.kurs.zadanie_1.datatypes.Criterion.VALUE;

public abstract class Clothing implements Comparable<Clothing> {
    private String name;
    private String size;
    private double price;
    private static Criterion sortCriterion = Criterion.SIZE;

    public Clothing(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public static void setCriteriaSort(Criterion criterion) {
        sortCriterion = criterion;
    }

    private int compareSizes(String size1, String size2) {
        // Handle numeric sizes
        try {
            int num1 = Integer.parseInt(size1);
            int num2 = Integer.parseInt(size2);
            return Integer.compare(num1, num2);
        } catch (NumberFormatException e) {
            // Handle letter sizes (S, M, L, etc.)
            int size1Value = getSizeValue(size1);
            int size2Value = getSizeValue(size2);

            if (size1Value != -1 && size2Value != -1) {
                return Integer.compare(size1Value, size2Value);
            }

            // If only one size is in our predefined order
            if (size1Value != -1) return 1;  // predefined sizes are considered larger
            if (size2Value != -1) return -1;

            // If neither size is in our predefined order, do string comparison
            return size1.compareTo(size2);
        }
    }

    private int getSizeValue(String size) {
        // Convert size to uppercase for case-insensitive comparison
        String upperSize = size.toUpperCase();

        if (upperSize.equals("XXS")) return 0;
        if (upperSize.equals("XS")) return 1;
        if (upperSize.equals("S")) return 2;
        if (upperSize.equals("M")) return 3;
        if (upperSize.equals("L")) return 4;
        if (upperSize.equals("XL")) return 5;
        if (upperSize.equals("XXL")) return 6;
        if (upperSize.equals("XXXL")) return 7;

        return -1; // Size not in predefined order
    }

    @Override
    public int compareTo(Clothing other) {
        switch (sortCriterion) {
            case SIZE:
                return compareSizes(this.size, other.size);
            case VALUE:
                return Double.compare(this.price, other.price);
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}


//package pl.kurs.zadanie_1.datatypes;
//
//public abstract class Clothing implements Comparable<Clothing> {
//    private String name;
//    private String size;
//    private double price;
//    private static Criterion sortCriterion = Criterion.SIZE;
//
//    public Clothing(String name, String size, double price) {
//        this.name = name;
//        this.size = size;
//        this.price = price;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getSize() {
//        return size;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public static void setCriteriaSort(Criterion criterion) {
//        sortCriterion = criterion;
//    }
//
//    private int compareSizes(String size1, String size2) {
//        // Handle numeric sizes
//        try {
//            int num1 = Integer.parseInt(size1);
//            int num2 = Integer.parseInt(size2);
//            return Integer.compare(num1, num2);
//        } catch (NumberFormatException e) {
//            // Handle letter sizes (S, M, L, etc.)
//            String[] sizeOrder = {"XXS", "XS", "S", "M", "L", "XL", "XXL", "XXXL"};
//            int index1 = -1;
//            int index2 = -1;
//
//            for (int i = 0; i < sizeOrder.length; i++) {
//                if (sizeOrder[i].equalsIgnoreCase(size1)) index1 = i;
//                if (sizeOrder[i].equalsIgnoreCase(size2)) index2 = i;
//            }
//
//            // If both sizes are in our predefined order
//            if (index1 != -1 && index2 != -1) {
//                return Integer.compare(index1, index2);
//            }
//
//            // If only one size is in our predefined order
//            if (index1 != -1) return 1;  // predefined sizes are considered larger
//            if (index2 != -1) return -1;
//
//            // If neither size is in our predefined order, do string comparison
//            return size1.compareTo(size2);
//        }
//    }
//
//    @Override
//    public int compareTo(Clothing other) {
//        switch (sortCriterion) {
//            case SIZE:
//                return compareSizes(this.size, other.size);
//            case VALUE:
//                return Double.compare(this.price, other.price);
//            default:
//                return 0;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "pl.kurs.datatypes.Clothing{" +
//                "name='" + name + '\'' +
//                ", size='" + size + '\'' +
//                ", price=" + price +
//                '}';
//    }
//}
