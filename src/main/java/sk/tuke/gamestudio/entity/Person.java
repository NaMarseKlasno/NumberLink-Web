package sk.tuke.gamestudio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long userID;

    private String userName;
    private int lastLevel;


    public Person(String userName, int lastLevel) {
        this.userName = userName;
        this.lastLevel = lastLevel;
    }

    public Person() {
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

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getUserID() {
        return userID;
    }
}
