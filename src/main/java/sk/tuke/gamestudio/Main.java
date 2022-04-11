package sk.tuke.gamestudio;

import sk.tuke.gamestudio.consoleui.ConsoleUI;
import sk.tuke.gamestudio.core.Field;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        Field field = new Field();
        ConsoleUI ui = new ConsoleUI(field);
        ui.play();
    }


}


