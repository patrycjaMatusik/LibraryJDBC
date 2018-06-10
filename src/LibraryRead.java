import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryRead {
    public static void readBook() throws SQLException, ClassNotFoundException {
        BookDao bookDao = new BookDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj isbn");
        String isbn = scanner.next();
        bookDao.read(bookDao.findBooksId(isbn));
    }

    public static void readAllBooks() throws SQLException, ClassNotFoundException {
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.readAll();
        for(Book book: books){
            System.out.println(book.toString());
        }
    }
}
