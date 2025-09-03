package pl.kurs.zadanie01.app;

import pl.kurs.zadanie01.services.Closet;
import pl.kurs.zadanie01.datatypes.Criterion;
import pl.kurs.zadanie01.datatypes.Jeans;
import pl.kurs.zadanie01.datatypes.Shirt;
import pl.kurs.zadanie01.services.ClothesService;
import pl.kurs.zadanie01.datatypes.Clothing;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


//        Shirt shirt1 = new Shirt("Blue Shirt", Clothing.Size.M, 29.99);
//        Shirt shirt2 = new Shirt("Red Shirt", Clothing.Size.L, 34.99);
//        Jeans jeans1 = new Jeans("Blue Jeans", Clothing.Size.S, 49.99);
//
//        Closet closet = new Closet();
//        closet.addClothing(shirt1);
//        closet.addClothing(shirt2, jeans1);
//
//        System.out.println("All clothes in the closet:");
//        for (Clothing clothing : closet) {
//            System.out.println(clothing);
//        }
//
//        Clothing largest = Collections.max(closet.getClothes());
//        System.out.println("\nLargest clothing by size: " + largest);
//
//        Clothing.setCriteriaSort(Criterion.VALUE);
//        Clothing mostExpensive = Collections.max(closet.getClothes());
//        System.out.println("Most expensive clothing: " + mostExpensive);
//
//
//        ClothesService.saveClothesToFile(closet, "closet.txt");


            List<Clothing> clothing = ClothesService.readClothesFromFile("closet.txt");
            for (Clothing c : clothing) {
                System.out.println(c);
            }

    }
}


//Zadanie 01:
//Stworz klase Szafa, do ktorej mozesz dodawac roznego rodzaju ubrania (koszule, jeasnsy, majtki itp)
//kazde ubranie ma nazwe, rozmiar, cene,
//
//ma dzialac taki kod:
//Szafa szafa = new Szafa(...);
//        szafa.dodajUbranie(...);
//szafa.dodajUbranie(u1, u2);
//szafa.dodajUbranie(u1, u2, u3); // mozna podac dowolna ilosc ubran w metodzie dodawania.
//
//for(Ubranie u : szafa){ iteruje po wszystkich ubraniach w szafie }
//
//Ubranie najwieksze = Collections.max(szafa.getUbrania()); // ma zwrocic najwieksze ubranie
//Ubranie.ustalKryteriumSortowania(Kryterium.WARTOSC);
//Ubranie najdrozsze = Collections.max(szafa.getUbrania()) // teraz po zmianie kryterium sotowania ma zwrocic najdrozsze ubranie.
//
//Stworz mozliwosc zapisania zawartosci szafy do pliku, oraz mozliwosc wczytania jej zawartosci z pliku.
//
//        Uwaga: nie wolno uzywac zadnych kolekcji ani tablic do rozwiazania zadania(!) [za wyjatkiem metody .getUbrania()]
//
//







