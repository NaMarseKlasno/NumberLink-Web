package main.java.sk.tuke.gamestudio;

import main.java.sk.tuke.gamestudio.core.Field;
import main.java.sk.tuke.gamestudio.consoleui.ConsoleUI;
import main.java.sk.tuke.gamestudio.util.ConnectionManager;
import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        Class<Driver> driverClass = Driver.class;
        try ( var connection = ConnectionManager.open()) {
            System.out.println(connection.getTransactionIsolation());
        }


        Field field = new Field();
        ConsoleUI ui = new ConsoleUI(field);
        ui.play();



    }
}




// commit: 2:45
// push: