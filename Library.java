/* Create a Library class that includes a List of Book objects. Populate the list with at least 15-20 book objects with varied author names, publication years, prices, and genres. */

// Library class

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {

    // create the list with 15 books
    List<Book> books = new ArrayList<>();

    // Constructor
    public Library() {

        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 12.99, "Fiction"));
        books.add(new Book("1984", "George Orwell", 1949, 10.99, "Science Fiction"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 11.50, "Fiction"));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813, 9.99, "Romance"));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 13.25, "Fiction"));
        books.add(new Book("To the Lighthouse", "Virginia Woolf", 1927, 8.75, "Modernist"));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 14.99, "Fantasy"));
        books.add(new Book("Moby Dick", "Herman Melville", 1851, 15.50, "Adventure"));
        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997, 16.99, "Fantasy"));
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 20.50, "Fantasy"));
        books.add(new Book("Frankenstein", "Mary Shelley", 1818, 10.99, "Gothic"));
        books.add(new Book("The Road", "Cormac McCarthy", 2006, 11.25, "Post-Apocalyptic"));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932, 12.99, "Science Fiction"));
        books.add(new Book("The Hunger Games", "Suzanne Collins", 2008, 9.75, "Dystopian"));
        books.add(new Book("The Da Vinci Code", "Dan Brown", 2003, 13.99, "Mystery"));
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, 11.99, "Science Fiction"));
        books.add(new Book("The Hunger Games", "Suzanne Collins", 2008, 14.25, "Dystopian"));
        books.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", 2005, 13.50, "Mystery"));
        books.add(new Book("Gone with the Wind", "Margaret Mitchell", 1936, 17.99, "Historical Fiction"));
        books.add(new Book("The Diary of a Young Girl", "Anne Frank", 1947, 9.75, "Memoir"));
        books.add(new Book("The Kite Runner", "Khaled Hosseini", 2003, 12.99, "Fiction"));
        books.add(new Book("The Help", "Kathryn Stockett", 2009, 10.50, "Historical Fiction"));
        books.add(new Book("The Chronicles of Narnia", "C.S. Lewis", 1950, 20.50, "Fantasy"));
        books.add(new Book("The Picture of Dorian Gray", "Oscar Wilde", 1890, 8.99, "Gothic"));
        books.add(new Book("The Road Less Traveled", "M. Scott Peck", 1978, 9.25, "Self-Help"));

    }

    /* 
     *  Exercise 3: Searching the Library
     */
    // 1. searchByAuthor(String author): Returns a list of books by the given author.
    public List<Book> searchByAuthor(String author) {
        List<Book> authorList = books.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
        return authorList;
    }

    //2. searchByYear(int year): Returns a list of books published in the given year.
    public List<Book> searchByYear(int year) {
        List<Book> pubclishedYearList = books.stream().filter(book -> book.getYearOfPublication() == year).collect(Collectors.toList());
        return pubclishedYearList;
    }

    //3. searchByTitle(String title): Returns a list of books that contain the given keyword in their title.
    public List<Book> searchByTitle(String title){
        List<Book> titleList = books.stream().filter(book -> book.getTitle().contains(title)).collect(Collectors.toList());
        return titleList;
    }

    //4. searchByGenre(String genre): Returns a list of books that belong to the given genre.
    public List<Book> searchByGenre(String genre) {
        List<Book> genreList = books.stream().filter(book -> book.getGanre().equals(genre)).collect(Collectors.toList());
        return genreList;
    }


    /* 
        Exercise 4: Aggregation Operations 
     */
     //1. averageBookPrice(): Returns the average price of books in the library.
     public double averageBookPrice(){
        // 1) convert price(double) into Double by using mapToDouble().    
        // 2) identity(0.0)  used as the identity element for the sum operation
        double total = books.stream().mapToDouble(Book::getPrice).reduce(0.0, Double::sum);

        double average = total / books.size();
        return average;
    }
    

    // 2. mostExpensiveBook(): Returns the most expensive book in the library.
    public Optional<Book> mostExpensiveBook(){
        // stream.max(Comparator....) method return the maximum element of the stream
        return  books.stream().max(Comparator.comparingDouble(Book::getPrice));
    }

    // 3. cheapestBook(): Returns the least expensive book in the library.
    public Optional<Book> cheapestBook(){
        // stream.min() method return minimim element 
        return books.stream().min(Comparator.comparingDouble(Book::getPrice));
    }

    // 4. oldestBook(): Returns the oldest book (based on the year of publication) in the library.
    public Optional<Book> oldestBook(){
        return books.stream().min(Comparator.comparingInt(Book::getYearOfPublication));
    }

    // 5. recentBooks(int years): Returns a list of books that were published in the last years.
    public List<Book> recentBooks(int years){
        return books.stream().filter(book -> book.getYearOfPublication() == years-1).collect(Collectors.toList());
    }

    /*
     *  Exercise 5: Sorting and Printing Books
     */
    // 1. printBooksSortedByTitle(): Sorts the books in the library by title and prints them.
    public void printBooksSortedByTitle(){
        books.stream()
        .sorted(Comparator.comparing(Book::getTitle))
        .forEach(System.out::println);
    }

    // 2. printBooksSortedByAuthor(): Sorts the books in the library by author and prints them.
    public void printBooksSortedByAuthor(){
        books.stream()
        .sorted(Comparator.comparing(Book::getAuthor))
        .forEach(System.out::println);
    }

    // 3. printBooksSortedByPublicationYear(): Sorts the books in the library by year of publication and prints them.
    public void printBooksSortedByPublicationYear(){
        books.stream()
        .sorted(Comparator.comparing(Book::getYearOfPublication))
        .forEach(System.out::println);
    }

    /*
     *  Exercise 6: Advanced Queries
     */

     // 1. authorWithMostBooks(): Finds the author who has written the most books in the library.
     public String authorWithMostBooks(){

        // Collectors.groupingBy -> group the books by author, Collectors.counting() -> count occurrences
        // collect elements into a Map
        Map<String, Long> authorBookCount = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));

        // *Map.Entry interface has key and value
        // converts the map into a Map.Entry (Key: author, Value: the count of same author's books) 
        Optional<Map.Entry<String, Long>> maxEntry = authorBookCount.entrySet()    
                            .stream().max(Map.Entry.comparingByValue());   //finds the entry with the maximum count
        return maxEntry.map(Map.Entry::getKey).orElse(null); // returns the author with the most books,
    }


    // 2. mostPopularGenre(): Determines the most common genre in the library.
    public String mostPopularGenre(){
        Map<String, Long> ganreCount = books.stream()
                .collect(Collectors.groupingBy(Book::getGanre, Collectors.counting()));

        // Key: ganre, Value: the count of ganres) 
        Optional<Map.Entry<String, Long>> maxEntry = ganreCount.entrySet()    
                            .stream().max(Map.Entry.comparingByValue());   
        return maxEntry.map(Map.Entry::getKey).orElse(null); 
    }

    // 3. yearWithMostPublishedBooks(): Finds the year with the most published books in the library.
    public int yearWithMostPublishedBooks(){
       Map<Integer, Long> yearBookCount = books.stream()
                    .collect(Collectors.groupingBy(Book::getYearOfPublication, Collectors.counting()));

        Optional<Map.Entry<Integer, Long>> maxEntry = yearBookCount.entrySet()
                            .stream().max(Map.Entry.comparingByValue());

        return maxEntry.map(Map.Entry::getKey).orElse(0);
    }
}

