import java.sql.SQLException;
import java.util.Scanner;

public class LibraryUpdate {
    public static void updateBook() throws SQLException, ClassNotFoundException {
        BookDao bookDao = new BookDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj isbn");
        String isbn = scanner.next();
        Book bookToUpdate = bookDao.readByISBN(isbn);
        if(bookToUpdate != null) {
            System.out.println("Podaj tytul");
            String title = scanner.next();
            System.out.println("Podaj autora");
            String author = scanner.next();
            System.out.println("Podaj rok");
            int year = Integer.parseInt(scanner.next());
            Book book = new Book(bookToUpdate.getId(), title, author, year, isbn);
            bookDao.update(book);
        }else {
            System.out.println("Książka o podanym numerze ISBN nie istenieje w bazie");
        }

    }
}
