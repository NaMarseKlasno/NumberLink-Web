package sk.tuke.gamestudio;

import sk.tuke.gamestudio.consoleui.ConsoleUI;
import sk.tuke.gamestudio.core.Field;
import org.postgresql.Driver;
import sk.tuke.gamestudio.util.ConnectionManager;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
//        Class<Driver> driverClass = Driver.class;
//        try ( var connection = ConnectionManager.open()) {
//            System.out.println("Connected to db");
//        }

        Field field = new Field();
        ConsoleUI ui = new ConsoleUI(field);
        ui.play();
    }
}