package de.iisys.drossner.algodat.generics;


public class Book implements Comparable<Book>{
    public String title;
    public int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    @Override
    public int compareTo(Book o) {
        return this.pages - o.pages;
    }
}
