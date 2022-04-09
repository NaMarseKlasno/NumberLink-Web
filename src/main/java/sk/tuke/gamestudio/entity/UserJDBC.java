package sk.tuke.gamestudio.entity;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJDBC implements UserServise {

    private static final String username = "macbookpro";
    private static final String password = "moskva4";
    private static final String url = "jdbc:postgresql://localhost:5433/postgres";

    public static final String INSERT_STATEMENT = "INSERT INTO usertable (player, lastLevel) VALUES (?, ?)";
    public static final String SELECT_STATEMENT = "SELECT player, lastLevel FROM usertable";
    public static final String DELETE_STATEMENT = "DELETE FROM usertable";



    @Override
    public void addUser(User user) {
        try (var connection = DriverManager.getConnection(url, username, password);
             var statement = connection.prepareStatement(INSERT_STATEMENT);
        ) {
//            statement.setInt(1, -1);
            statement.setString(1, user.getUserName());
            statement.setInt(2, user.getLastLevel());
            statement.executeUpdate();
            user.setUserID(getUserID(user));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getUserID(User user)
    {
        int userID = -1;

        try (var connection = DriverManager.getConnection(url, username, password);
             var statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT id FROM usertable ORDER BY id DESC LIMIT 1");
        ) {
            while(rs.next()) {
                userID = rs.getInt("id");
            }
            System.out.println("================: " + userID);
            return userID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userID;
    }

    @Override
    public List<User> getUsersList() {
        try (var connection = DriverManager.getConnection(url, username, password);
             var statement = connection.prepareStatement(SELECT_STATEMENT)
        ) {
            try (var rs = statement.executeQuery()) {
                var users = new ArrayList<User>();
                while (rs.next()) {
                    users.add(new User(rs.getString(2), rs.getInt(3)));
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

    @Override
    public void update(User user)
    {
        try (var connection = DriverManager.getConnection(url, username, password);
             var pstmt = connection.prepareStatement("UPDATE usertable SET lastLevel = " + user.getLastLevel() + " WHERE id = " + user.getUserID());
        ) {
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}








