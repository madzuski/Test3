package pl.kurs.zadanie_1.datatypes;

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
            String[] sizeOrder = {"XXS", "XS", "S", "M", "L", "XL", "XXL", "XXXL"};
            int index1 = -1;
            int index2 = -1;

            for (int i = 0; i < sizeOrder.length; i++) {
                if (sizeOrder[i].equalsIgnoreCase(size1)) index1 = i;
                if (sizeOrder[i].equalsIgnoreCase(size2)) index2 = i;
            }

            // If both sizes are in our predefined order
            if (index1 != -1 && index2 != -1) {
                return Integer.compare(index1, index2);
            }

            // If only one size is in our predefined order
            if (index1 != -1) return 1;  // predefined sizes are considered larger
            if (index2 != -1) return -1;

            // If neither size is in our predefined order, do string comparison
            return size1.compareTo(size2);
        }
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
        return "pl.kurs.datatypes.Clothing{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
