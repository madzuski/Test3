package pl.kurs.zadanie01.datatypes;


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

    public String toSingleCSVLine() {
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

