package com.driver;

public class Book {

     private String name;
     private String author;
     private String genre;
     private int id;

     public Book(){

     }

     public Book(String name, String genre, String author) {
          this.name = name;
          this.author = author;
          this.genre = genre;
     }

     public Book(int id, String name, String genre, String author) {
          this.name = name;
          this.author = author;
          this.genre = genre;
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getAuthor() {
          return author;
     }

     public void setAuthor(String author) {
          this.author = author;
     }

     public String getGenre() {
          return genre;
     }

     public void setGenre(String genre) {
          this.genre = genre;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }
}