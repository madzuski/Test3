package pl.kurs.zadanie01.services;

import pl.kurs.zadanie01.datatypes.Clothing;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Closet implements Iterable<Clothing> {
    private Node head;
    private int size;

    private static class Node {
        Clothing clothing;
        Node next;

        Node(Clothing clothing) {
            this.clothing = clothing;
            this.next = null;
        }
    }

    public Closet() {
        head = null;
        size = 0;
    }

    public void addClothing(Clothing... clothes) {
        for (Clothing clothing : clothes) {
            Node newNode = new Node(clothing);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }
    }

    public List<Clothing> getClothes() {
        List<Clothing> clothes = new ArrayList<>();
        Node current = head;
        while (current != null) {
            clothes.add(current.clothing);
            current = current.next;
        }
        return clothes;
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            head = null;
            size = 0;
            try {
                while (true) {
                    Clothing clothing = (Clothing) ois.readObject();
                    addClothing(clothing);
                }
            } catch (EOFException e) {
                // End of file reached
            }
        }
    }

    @Override
    public java.util.Iterator<Clothing> iterator() {
        return new Iterator();
    }

    private class Iterator implements java.util.Iterator<Clothing> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Clothing next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Clothing clothing = current.clothing;
            current = current.next;
            return clothing;
        }
    }
} 