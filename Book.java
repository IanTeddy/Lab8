// Lab 8: Mei Hirata
// Book class

public class Book {

    /* Create a Book class with the following fields: title (String), author (String), yearOfPublication (int), price (double), and genre (String). */
    private String title;
    private String author;
    private int yearOfPublication;
    private double price;
    private String ganre;

    // Constructor
    public Book(String title, String author, int yearOfPublication, double price, String ganre) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
        this.ganre = ganre;
    }
    
    // getters and setters
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return this.yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGanre() {
        return this.ganre;
    }

    public void setGanre(String ganre) {
        this.ganre = ganre;
    }

    // toString method to present a book's information clearly
    @Override
    public String toString(){
        return String.format("Title: %s%nAuthor: %s%nPublished Year: %d%nPrice: $%.2f%nGenre: %s%n", getTitle(), getAuthor(),getYearOfPublication(), getPrice(), getGanre());
    }
}