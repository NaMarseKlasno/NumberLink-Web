package main.java.sk.tuke.gamestudio;

import main.java.sk.tuke.gamestudio.core.Field;
import main.java.sk.tuke.gamestudio.consoleui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        ConsoleUI ui = new ConsoleUI(field);
        ui.play();
    }
}
// 2:37