package sk.tuke.gamestudio.entity;

public class User {

    private String userName;
    private int lastLevel;

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
}
