package sk.tuke.gamestudio.entity;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {

    private String userName;
    private int lastLevel;
    private int userID;

    public User(String userName, int lastLevel) {
        this.userName = userName;
        this.lastLevel = lastLevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLastLevel() {
        return lastLevel;
    }

    public void setLastLevel(int lastLevel) {
        this.lastLevel = lastLevel;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
}
