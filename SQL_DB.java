import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQL_DB {
    private static final String DB_URL = "jdbc:sqlite:database.db";

    public static final List<String> RetrieveAuthors(){
        // String url = "jdbc:sqlite:/db/database.db";
        String query = "SELECT name FROM authors";
        List<String> authorNames = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String authorName = resultSet.getString("name");
                authorNames.add(authorName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authorNames;
    }

    public static int findAuthorId(String name) {
        int authorId = -1;
        try {
            Connection connection = DriverManager.getConnection(DB_URL);
            String query = "SELECT id FROM authors WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                authorId = resultSet.getInt("id");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorId;
    }


    public static final List<String> RetrieveBooks(int author_id){
        String query = "SELECT name FROM books WHERE author_id = ?";
        List<String> bookNames = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, author_id);
            ResultSet resultSet = statement.executeQuery(); 
            while (resultSet.next()) {
                String bookName = resultSet.getString("name");
                bookNames.add(bookName);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookNames;
    }

    public static final int FindTotal(String book_name){
        String query = "SELECT total FROM books WHERE name = ?";
        int total = 0;
        try {
            Connection connection = DriverManager.getConnection(DB_URL);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, book_name);
            ResultSet resultSet = statement.executeQuery(); 
            while (resultSet.next()) {
                total = resultSet.getInt("total");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static final int FindAvailable(String book_name){
        String query = "SELECT available FROM books WHERE name = ?";
        int available = 0;
        try {
            Connection connection = DriverManager.getConnection(DB_URL);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, book_name);
            ResultSet resultSet = statement.executeQuery(); 
            while (resultSet.next()) {
                available = resultSet.getInt("available");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return available;
    }
 
}
