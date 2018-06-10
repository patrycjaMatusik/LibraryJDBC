import java.sql.SQLException;
import java.util.Scanner;

public class LibraryUpdate {
    public static void updateBook() throws SQLException, ClassNotFoundException {
        BookDao bookDao = new BookDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj isbn");
        String isbn = scanner.next();
        bookDao.read(bookDao.findBooksId(isbn));
        System.out.println("Podaj tytul");
        String title = scanner.nextLine();
        System.out.println("Podaj autora");
        String author = scanner.next();
        System.out.println("Podaj rok");
        int year = Integer.parseInt(scanner.next());
        Book book = new Book(title, author, year, isbn);
        bookDao.update(book);

    }
}
