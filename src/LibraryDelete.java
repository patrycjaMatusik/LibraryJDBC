import java.sql.SQLException;
import java.util.Scanner;

public class LibraryDelete {

    public static void deleteBook() throws SQLException, ClassNotFoundException {
        BookDao bookDao = new BookDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj isbn");
        String isbn = scanner.next();
        bookDao.deleteByISBN(isbn);
    }
}
