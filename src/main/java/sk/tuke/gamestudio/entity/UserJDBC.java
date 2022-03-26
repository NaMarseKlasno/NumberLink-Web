package sk.tuke.gamestudio.entity;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJDBC implements UserServise {

    private static final String username = "macbookpro";
    private static final String password = "moskva4";
    private static final String url = "jdbc:postgresql://localhost:5433/postgres";

    public static final String INSERT_STATEMENT = "INSERT INTO userTable(player, lastLevel) VALUES (?, ?)";
    public static final String SELECT_STATEMENT = "SELECT player, lastLevel FROM userTable";
    public static final String DELETE_STATEMENT = "DELETE FROM userTable";



    @Override
    public void addUser(User user) {
        try (var connection = DriverManager.getConnection(url, username, password);
             var statement = connection.prepareStatement(INSERT_STATEMENT);
        ) {
            statement.setString(1, user.getUserName());
            statement.setInt(2, user.getLastLevel());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsersList() {
        try (var connection = DriverManager.getConnection(url, username, password);
             var statement = connection.prepareStatement(SELECT_STATEMENT)
        ) {
            try (var rs = statement.executeQuery()) {
                var users = new ArrayList<User>();
                while (rs.next()) {
                    users.add(new User(rs.getString(1), rs.getInt(2)));
                }
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void reset() {
        try (var connection = DriverManager.getConnection(url, username, password);
             var statement = connection.createStatement();
        ) {
            statement.executeUpdate(DELETE_STATEMENT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
