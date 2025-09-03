package pl.kurs.zadanie03.datatypes;

import java.io.Serializable;
import java.util.Objects;

public class MinMax<T extends Comparable<T>> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T min;
    private T max;

    public MinMax(T min, T max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinMax<?> minMax = (MinMax<?>) o;
        return Objects.equals(min, minMax.min) && Objects.equals(max, minMax.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "MinMax{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
