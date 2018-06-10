import java.sql.SQLException;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz opcję: \n1 - Dodaj nowy rekord\n2 - Wyświetl wszystkie książki\n3 - Usuwanie\n4 - Aktualizacja");
        int mode = scanner.nextInt();
        switch (mode) {
            case 1:
                LibrarySave.saveBook();
                System.out.println("\n");
                break;
            case 2:
                LibraryRead.readAllBooks();
                System.out.println("\n");
                break;
            case 3:
                LibraryDelete.deleteBook();
                System.out.println("\n");
                break;
            case 4:
                LibraryUpdate.updateBook();
                System.out.println("\n");
                break;
            default:
                System.out.println("Wybierz opcję z listy.");
        }
        Library.main(new String[]{});
    }
}
