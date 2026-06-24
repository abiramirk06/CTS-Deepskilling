import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author;
    }
}

public class LibraryManagementSystem {

    // Linear Search
    public static Book linearSearch(Book[] books, String target) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(target)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String target) {

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int result = books[mid].title.compareToIgnoreCase(target);

            if (result == 0)
                return books[mid];

            if (result < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {
            new Book(101, "Java", "James Gosling"),
            new Book(102, "Python", "Guido van Rossum"),
            new Book(103, "C Programming", "Dennis Ritchie"),
            new Book(104, "Data Structures", "Mark Allen")
        };

        String searchTitle = "Python";

        Book linearResult = linearSearch(books, searchTitle);

        System.out.println("Linear Search:");
        if (linearResult != null)
            System.out.println(linearResult);
        else
            System.out.println("Book Not Found");

        Arrays.sort(books,
                Comparator.comparing(book -> book.title.toLowerCase()));

        Book binaryResult = binarySearch(books, searchTitle);

        System.out.println("\nBinary Search:");
        if (binaryResult != null)
            System.out.println(binaryResult);
        else
            System.out.println("Book Not Found");
    }
}