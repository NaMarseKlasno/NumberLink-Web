package sk.tuke.gamestudio.service;

import org.junit.Test;

import static org.junit.Assert.*;
import sk.tuke.gamestudio.entity.User;
import sk.tuke.gamestudio.entity.UserJDBC;


public class UserServiceTest {

    private UserJDBC userJDBC = new UserJDBC();

    @Test
    public void testAddUser() {
        userJDBC.addUser(new User("Kukla", 10));

        var list = userJDBC.getUsersList();
        assertEquals(1, list.size());
        assertEquals("Kukla", list.get(0).getUserName());
        assertEquals(10, list.get(0).getLastLevel());
    }

    @Test
    public void testAddUser_2() {
        userJDBC.addUser(new User("Kukla1",5));
        userJDBC.addUser(new User("Kukla2",4));
        userJDBC.addUser(new User("Kukla3",3));
        userJDBC.addUser(new User("Kukla4",6));

        var list = userJDBC.getUsersList();
        assertEquals(4, list.size());
        assertEquals("Kukla1", list.get(0).getUserName());
        assertEquals("Kukla2", list.get(1).getUserName());
        assertEquals("Kukla3", list.get(2).getUserName());
        assertEquals("Kukla4", list.get(3).getUserName());
        assertEquals(5, list.get(0).getLastLevel());
        assertEquals(4, list.get(1).getLastLevel());
        assertEquals(3, list.get(2).getLastLevel());
        assertEquals(6, list.get(3).getLastLevel());
    }


    @Test
    public void testGetUsersList() {
        userJDBC.addUser(new User("Kukla1",5));
        userJDBC.addUser(new User("Kukla2",4));
        userJDBC.addUser(new User("Kukla3",3));
        userJDBC.addUser(new User("Kukla4",6));

        var Users = userJDBC.getUsersList();

        assertEquals(4, Users.size());

        assertEquals("Kukla1", Users.get(0).getUserName());
        assertEquals(5, Users.get(0).getLastLevel());

        assertEquals("Kukla2", Users.get(0).getUserName());
        assertEquals(4, Users.get(0).getLastLevel());

        assertEquals("Kukla3", Users.get(0).getUserName());
        assertEquals(3, Users.get(0).getLastLevel());

        assertEquals("Kukla4", Users.get(0).getUserName());
        assertEquals(6, Users.get(0).getLastLevel());
    }
}
