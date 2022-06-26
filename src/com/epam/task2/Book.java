package com.epam.task2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@ToString
public class Book {
    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Book() {
    }

    public List<Book> createBooks(int count){
        List<Book> listOfBooks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Book book = new Book();
            book.setName(RandomStringUtils.randomAlphabetic(3,10));
            book.setPrice((int) (Math.random()*(99+1)-1));
            listOfBooks.add(book);
        }
        return listOfBooks;
    }

    public List<String> getAllBooksName(List<Book> books) {
        List<String> getAll = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            getAll.add(books.get(i).name);
        }
        return getAll;
    }

    public int getAllBooksPrice(List<Book> books){
        int totalPrice=0;
        for (int i = 0; i < books.size(); i++) {
            totalPrice=totalPrice+books.get(i).price;
        }
        return totalPrice;
    }

    public int getHighestPrice(List<Book> books){
        int highestPrice = 0;
        for (int i = 0; i <books.size() ; i++) {
            if (books.get(i).price > highestPrice){
                highestPrice = books.get(i).price;
            }
        }
        return highestPrice;
    }

    public List <Book> getBookWithPriceLessThirty(List<Book> books){
        int maxPrice = 30;
        List <Book> booksUntilThirty = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).price <= maxPrice){
                booksUntilThirty.add(books.get(i));
            }
        }
        return booksUntilThirty;
    }

    public List<Book> getBookWithAInName(List<Book> books){
        String book;
        List<Book> booksWithA = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            book = books.get(i).name;
            if(book.contains("a")||book.contains("A")){
                booksWithA.add(books.get(i));
            }
        }
        return booksWithA;
    }

    public int getNumberOfBooksWhichHaveFiveLetters(List<Book> books){
        int count = 0;
        String book;
        for (int i = 0; i < books.size(); i++) {
            book = books.get(i).name;
            if(book.length() == 5){
                count ++;
            }
        }
        return count;
    }

    private static void sortByNameAndPrice(List<Book> books) {

        Collections.sort(books, new Comparator() {

            public int compare(Object o1, Object o2) {

                String book1Name = ((Book) o1).getName().toLowerCase();
                String book2Name = ((Book) o2).getName().toLowerCase();
                int sComp = book2Name.compareTo(book1Name);

                if (sComp != 0) {
                    return sComp;
                }

                Integer book1Price = ((Book) o1).getPrice();
                Integer book2Price = ((Book) o2).getPrice();
                return book2Price.compareTo(book1Price);
            }});
    }

    public static void main(String[] args) {
        Book book = new Book();
        List<Book> nb = book.createBooks(10);
        System.out.println("All books: "+nb.toString());
        System.out.println("All books name: "+book.getAllBooksName(nb));
        System.out.println("All books price: "+book.getAllBooksPrice(nb));
        System.out.println("Highest book price: "+book.getHighestPrice(nb));
        System.out.println("Books with price until 30ty: "+book.getBookWithPriceLessThirty(nb));
        System.out.println("Books with 'a' in name: "+book.getBookWithAInName(nb));
        System.out.println("Books which have 5 letter in name: "+book.getNumberOfBooksWhichHaveFiveLetters(nb));
        sortByNameAndPrice(nb);
        System.out.println(nb);
        Book book1 = new Book("my Book",5);
        Book book2 = new Book("my Book",5);
        Map<Book,String> map1 = new HashMap<>();
        map1.put(book1,"Korolenko library");
        String libraryName = map1.get(book2);
        System.out.println("libraryName = " + libraryName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
