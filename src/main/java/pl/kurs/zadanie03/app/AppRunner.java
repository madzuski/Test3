package pl.kurs.zadanie03.app;

import pl.kurs.zadanie02.Main;
import pl.kurs.zadanie03.datatypes.MinMax;
import pl.kurs.zadanie03.services.MinMaxService;

import java.util.Arrays;
import java.util.List;

public class AppRunner {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(12, 425, 343, 2, 94, 345, null);

        MinMax<Integer> minAndMax = MinMaxService.getMinAndMax(numbers);
        System.out.println("minAndMax = " + minAndMax);

    }
}
