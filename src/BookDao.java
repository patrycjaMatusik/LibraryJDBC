import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private static final String URL = "jdbc:mysql://localhost:3306/library?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "LubiePlacki321";
    private Connection connection;

    public BookDao() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Book book) {
        final String query = "insert into books(title, author, year, isbn) values(?, ?, ?, ?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, book.getTitle());
            prepStmt.setString(2, book.getAuthor());
            prepStmt.setInt(3, book.getYear());
            prepStmt.setString(4, book.getIsbn());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public Book read(long id) {
        final String sql = "select id, title, author, year, isbn from books where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setLong(1, id);
            ResultSet result = prepStmt.executeQuery();
            if (result.next()) {
                Book book = new Book();
                book.setId(result.getLong("id"));
                book.setTitle(result.getString("title"));
                book.setAuthor(result.getString("author"));
                book.setYear(result.getInt("year"));
                book.setIsbn(result.getString("isbn"));
                return book;
            }
        } catch (SQLException e) {
            System.out.println("Could not get book");
        }
        return null;
    }

    public void update(Book book) {
        final String sql = "update books set title=?, author=?, year=?, isbn=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, book.getTitle());
            prepStmt.setString(2, book.getAuthor());
            prepStmt.setInt(3, book.getYear());
            prepStmt.setString(4, book.getIsbn());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update book");
        }
    }

    public void delete(long id) {
        final String sql = "delete from books where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setLong(1, id);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not delete row");
        }
    }

    public long findBooksId(String isbn){
        final String sql = "select id from books where isbn=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, isbn);
            ResultSet result = prepStmt.executeQuery();
            return result.getLong("id");
        } catch (SQLException e) {
            System.out.println("Could not find book");
            return 0;
        }
    }

    public List<Book> readAll() {
        final String sql = "select id, title, author, year, isbn from books";
        List<Book> allBooks = new ArrayList<>();
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            ResultSet result = prepStmt.executeQuery();
            while (result.next() != false) {
                Book book = new Book();
                book.setId(result.getLong("id"));
                book.setTitle(result.getString("title"));
                book.setAuthor(result.getString("author"));
                book.setYear(result.getInt("year"));
                book.setIsbn(result.getString("isbn"));
                allBooks.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Could not get books");
        }
        return allBooks;
    }


}
