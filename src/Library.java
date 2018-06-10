import java.sql.SQLException;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz opcję: \n1 - Dodaj nowy rekord\n2 - Wyświetl wszystkie książki\n3 - Usuwanie\n4 - Aktualizacja");
        int mode = Integer.parseInt(scanner.next());
        switch (mode) {
            case 1:
                LibrarySave.saveBook();
                System.out.println("\n");
                Library.main(new String[]{});
                break;
            case 2:
                LibraryRead.readAllBooks();
                System.out.println("\n");
                Library.main(new String[]{});
                break;
            case 3:
                LibraryDelete.deleteBook();
                System.out.println("\n");
                Library.main(new String[]{});
                break;
            case 4:
                LibraryUpdate.updateBook();
                System.out.println("\n");
                Library.main(new String[]{});
                break;
        }
    }
}
