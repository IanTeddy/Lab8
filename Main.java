// main class 
public class Main {
    public static void main(String[] args) {

        // Library object
        Library library = new Library();

        /* Testing methods that created in Library class */ 
        // search by author method
        System.out.printf("----- Search by <%s> -----%nResult>>> %n" + library.searchByAuthor("F. Scott Fitzgerald"), "F. Scott Fitzgerald");
        System.out.println("");

        //avarage price
        System.out.printf("Avarage price of books: $%.2f%n", library.averageBookPrice());
        System.out.println("");

        // the most expensive book
        System.out.printf("--- The most expensive book ---%n" + library.mostExpensiveBook());
        System.out.println("");

        // the oldest book
        System.out.printf("--- The oldest book ---%n" + library.oldestBook());
        System.out.println("");

        // Display stored list 
        System.out.printf("--- Sorted by Title ---%n");
        library.printBooksSortedByTitle();
        System.out.println("");

        System.out.printf("--- Sorted by Author ---%n");
        library.printBooksSortedByAuthor();
        System.out.println("");

        // adcance challenge
        System.out.println("The most popular ganre is " + library.mostPopularGenre());
        System.out.println("The year with the most published books is " + library.yearWithMostPublishedBooks());
        
    }
}
