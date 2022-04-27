package sk.tuke.gamestudio.service;

import sk.tuke.gamestudio.entity.Person;
import java.util.List;

//@Component
public interface UserService {
    void addUser(Person user);
    List<Person> getUsersList();
    void reset();
    void update(Person user);
    Person getPerson(String name);
}

