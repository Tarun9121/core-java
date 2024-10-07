package learning.streams;

class Book {
    private String title;
    private String author;
    private double price;
    private int year;
    private String genre;

    public Book(String title, String author, double price, int year, String genre) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }

    public Book() {}

    // Getters
    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ") - " + genre + " - $" + price;
    }
}

