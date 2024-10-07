package learning.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.max;

public class StreamsDemo {
    /**
     * DIFFERENT OPERATIONS ON Stream:
     * 1. Intermediate Operations
     * 2. Terminate Operations
     *
     * @Important_methods_of_intermediate_operations -
     * 1.map(Function) 2.filter(Predicate) 3.sorted(Comparator)
     * 4.flatMap(Function) 5.distinct() 6.peek(Consumer)
     */
    public void streamsIntermediateMethods() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        List<Integer> squaredEvenNumbers = numbers.stream()
                .filter(no -> no%2 == 0)
                .map(no -> no*no)
                .collect(Collectors.toList());

        Integer sum = numbers.stream()
                        .reduce(0, (no1, no2) -> no1 + no2);

        System.out.println(squaredEvenNumbers);


    }

    List<Book> books = Arrays.asList(
            new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99, 1925, "Fiction"),
            new Book("Moby Dick", "Herman Melville", 8.99, 1851, "Fiction"),
            new Book("A Brief History of Time", "Stephen Hawking", 15.99, 1988, "Science"),
            new Book("The Road", "Cormac McCarthy", 12.99, 2006, "Fiction"),
            new Book("The Selfish Gene", "Richard Dawkins", 11.99, 1976, "Science"),
            new Book("The Hobbit", "J.R.R. Tolkien", 9.99, 1937, "Fantasy"),
            new Book("The Catcher in the Rye", "J.D. Salinger", 10.49, 1951, "Fiction")
    );

    public void practiceStreams() {
        System.out.println(sortBooksByPrice());
    }

    private List<Book> filterBookByGenre(String genre) {
        return books.stream().filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
    }

    private Optional<Book> getTheMostExpensiveBook() {
//        Book mostExpensiveBook = books.stream().reduce(new Book(), (a, b) -> {
//            if(a.getPrice() > b.getPrice()) {
//                return a;
//            }
//            else {
//                return b;
//            }
//        });
//
//        return Optional.of(mostExpensiveBook);

        Optional<Book> expensiveBook = books.stream()
                .max((book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice()));

        return expensiveBook;
    }

    private List<String> getBookTitles() {
        List<String> titles = books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());

        return titles;
    }

    private double calculateAvgPrice() {
        double avgPrice = books.stream()
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0.0);
        return avgPrice;
    }

    private long countBooksBeforeYear(int year) {
        return books.stream()
                .mapToLong(Book::getYear)
                .filter(years -> years > year)
                .count();
    }

    private Set<String> findUniqueGenres() {
        return books.stream()
                .map(Book::getGenre)
                .distinct()
                .collect(Collectors.toSet());
    }

    private List<Book> sortBooksByPrice() {
        return books.stream()
                .sorted((book1, book2) -> (int)(book1.getPrice() - book2.getPrice()))
                .collect(Collectors.toList());
    }

    boolean anyBookUnderTenDollers() {
        List<Book> booksUnderTenDollers = books.stream()
                .filter(book -> book.getPrice() < 10)
                .collect(Collectors.toList());

        return !booksUnderTenDollers.isEmpty();
    }

    Optional<Book> findFirstBookByAuthor(String author) {
        Optional<Book> firstBookByAuthor = books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .findFirst();

        return firstBookByAuthor;
    }

    double priceOfAllBooks() {
        return books.stream()
                .mapToDouble(Book::getPrice)
                .reduce(0, (price1, price2) -> price1 + price2);
    }


}
