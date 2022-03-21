package main.java.sk.tuke.gamestudio.consoleui;

import main.java.sk.tuke.gamestudio.core.Field;
import java.util.Scanner;

public class ConsoleUI {

    private final Field field;
    private final Scanner in = new Scanner(System.in);
    private int currentLvl;

    public ConsoleUI(Field field, int lvl) {
        this.field = field;
        this.currentLvl = lvl;
        field.generate(currentLvl);
    }
    public ConsoleUI(Field field) {
        this.field = field;
        this.currentLvl = 1;
        field.generate(currentLvl);
    }


    public void play() {


        do {
            printDetails();
            printField();
            processInput();

            if (field.isLevelSolved()) {
                this.field.generate(++currentLvl);
            }

        } while (currentLvl<=10);
    }


    private void printField()
    {
        System.out.print("\n  ");
        for (int j=0; j<this.field.getColumnCount(); ++j) {
            System.out.print("  "+(j+1)+" ");
        }

        System.out.print("\n  +");
        for (int j=0; j<this.field.getColumnCount(); ++j) {
            System.out.print("---+");
        } System.out.println();

        for (int i=0; i<this.field.getRowCount(); ++i)
        {
            System.out.print((i+1)+" ");
            for (int j=0; j<this.field.getColumnCount(); ++j)
            {
                if (field.getTiles()[i][j].getContent() == 0) System.out.print("|   ");
                else System.out.print("| " + (field.getTiles()[i][j].getColor() + field.getTiles()[i][j].getContent() + "\u001B[0m") + " ");

            }

            System.out.print("|\n  +");

            for (int j=0; j<this.field.getColumnCount(); ++j) {
                System.out.print("---+");
            } System.out.println();
        } System.out.print("\n");
    }

    private void processInput()
    {
        System.out.print("Enter command: ");

        String line = in.nextLine().toUpperCase();

        if ("E".equals(line)) {
            System.exit(0);
        }

        int x = Integer.parseInt(line.substring(0, 1));
        int y = Integer.parseInt(line.substring(1, 2));

        if (x > 0 && y > 0 && x <= field.getColumnCount() && y <= field.getRowCount()) {
            if (line.charAt(2) != 'W' && line.charAt(2) != 'E' && line.charAt(2) != 'S' && line.charAt(2) != 'N') {
                System.out.println("\u001B[31m"+"Wrong direction!"+"\u001B[0m");
                return;
            }
            String str = line.substring(3);
            if (!str.matches("[-+]?\\d+")) {
                System.out.println("\u001B[31m"+ "Command failed!"+"\u001B[0m");
                return;
            }

            if (!field.connectTiles(x, y, line.charAt(2), Integer.parseInt(str))) {
                System.out.println("\u001B[31m"+ "Command failed! (connectTiles)"+"\u001B[0m");
                return;
            }
        }

        else {
            System.out.println("\u001B[31m"+ "Command failed!"+"\u001B[0m");
        }

        System.out.println();
    }

    private void printDetails () {
        System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│\u001B[36m" + " W - West (◁) | N - North (△)"  + "\u001B[0m" + "     example: '" +"\u001B[31m"+ "13W2" +"\u001B[0m"+ "' → '" +"\u001B[31m"+ "13" +"\u001B[0m"+ "' is x/y coordinate, '" +"\u001B[31m"+ "2" +"\u001B[0m"+ "' is squares to the WEST │");
        System.out.println("│\u001B[36m" + " E - East (▷) | S - South (▽)"  + "\u001B[0m" + "     " +"\u001B[31m"+ "E" +"\u001B[0m"+" - exit                                                             │");
        System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println(" Level: "+"\u001B[31m"+currentLvl+"\u001B[0m");
    }
}


