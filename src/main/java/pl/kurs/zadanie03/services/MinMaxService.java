package pl.kurs.zadanie03.services;

import pl.kurs.zadanie03.datatypes.MinMax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements){ //(12, 425, 343, 2, 94, 345, null
        List<T> tmpList = new ArrayList<>();
        for (T element : elements) {
            if (element != null) {
                tmpList.add(element);
            }
        }
        Collections.sort(tmpList);
        return new MinMax<>(tmpList.get(0), tmpList.get(tmpList.size() - 1));

    }
}
