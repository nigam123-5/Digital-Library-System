import java.util.*;

class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private String availability;

    public Book(String bookId, String title, String author, String genre, String availability) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Availability: " + availability;
    }
}

class LibraryManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBook(String query) {
        for (Book book : books) {
            if (book.getBookId().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query)) {
                return book;
            }
        }
        return null;
    }

    public boolean updateBook(String bookId, String title, String author, String availability) {
        Book book = searchBook(bookId);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setAvailability(availability);
            System.out.println("Book updated successfully.");
            return true;
        }
        System.out.println("Book not found.");
        return false;
    }

    public boolean deleteBook(String bookId) {
        Book book = searchBook(bookId);
        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted successfully.");
            return true;
        }
        System.out.println("Book not found.");
        return false;
    }
}

public class LibraryApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability (Available/Checked Out): ");
                    String availability = scanner.nextLine();
                    libraryManager.addBook(new Book(bookId, title, author, genre, availability));
                    break;
                case 2:
                    libraryManager.viewAllBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID or Title to search: ");
                    String query = scanner.nextLine();
                    Book foundBook = libraryManager.searchBook(query);
                    if (foundBook != null) {
                        System.out.println("Book Found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter New Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter New Availability (Available/Checked Out): ");
                    String newAvailability = scanner.nextLine();
                    libraryManager.updateBook(updateId, newTitle, newAuthor, newAvailability);
                    break;
                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    String deleteId = scanner.nextLine();
                    libraryManager.deleteBook(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
