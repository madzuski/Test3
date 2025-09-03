package pl.kurs.zadanie02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<File> myJavaFiles = new ArrayList<>();
        findJavaFiles(new File("C:\\Users\\madzuski\\IdeaProjects"), myJavaFiles);

        myJavaFiles.stream()
                .collect(Collectors.groupingBy(x -> getDayOfWeekFromFile(x), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        printSummary(myJavaFiles);

        //wklejony wynik w komentarz:
//        MONDAY->75
//        TUESDAY->147
//        WEDNESDAY->4909
//        THURSDAY->72
//        FRIDAY->35
//        SATURDAY->300
//        SUNDAY->46

    }

    static void printSummary(List<File> list) {
        int[] weekDaysCounters = new int[7];
        for (File f : list) {
            switch (getDayOfWeekFromFile(f)) {
                case MONDAY -> weekDaysCounters[0]++;
                case TUESDAY -> weekDaysCounters[1]++;
                case WEDNESDAY -> weekDaysCounters[2]++;
                case THURSDAY -> weekDaysCounters[3]++;
                case FRIDAY -> weekDaysCounters[4]++;
                case SATURDAY -> weekDaysCounters[5]++;
                case SUNDAY -> weekDaysCounters[6]++;
            }

        }
        DayOfWeek[] weekDaysArray = DayOfWeek.values();
        for (int i = 0; i < DayOfWeek.values().length; i++) {
            System.out.println(weekDaysArray[i] + "->" + weekDaysCounters[i]);
        }

    }

    static void findJavaFiles(File file, List<File> fileList) {

        if (file.isDirectory()) {
            File[] array = file.listFiles();
            for (File f : array) {
                if (f.isDirectory()) {
                    findJavaFiles(f, fileList);
                } else if (f.getName().endsWith(".java")) {
                    fileList.add(f);
                }
            }
        }

    }

    static DayOfWeek getDayOfWeekFromFile(File f) {
        DayOfWeek dayOfWeek = null;
        Path path = Paths.get(f.getAbsolutePath());

        BasicFileAttributes bfa = null;
        try {
            bfa = Files.readAttributes(path, BasicFileAttributes.class);
            dayOfWeek = LocalDate.ofInstant(bfa.creationTime().toInstant(), ZoneId.systemDefault()).getDayOfWeek();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dayOfWeek;
    }
}
