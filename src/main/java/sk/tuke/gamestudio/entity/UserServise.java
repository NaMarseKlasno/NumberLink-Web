package sk.tuke.gamestudio.entity;

import java.util.List;

public interface UserServise {
    void addUser(User user);
    List<User> getUsersList();
    void reset();
}

