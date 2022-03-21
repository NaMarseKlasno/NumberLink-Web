package main.java.sk.tuke.gamestudio.core;

public class Tile {

    private static final String RED    = "\u001B[31m";
    private static final String GREEN  = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE   = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN   = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    private int content;
    private String Color;

    public Tile(int content) {
        this.content = content;
        setColor();
    }

    private void setColor() {
        switch (this.content) {
            case 1 -> this.Color = YELLOW;
            case 2 -> this.Color = BLUE;
            case 3 -> this.Color = GREEN;
            case 4 -> this.Color = RED;
            case 5 -> this.Color = PURPLE;
            case 6 -> this.Color = CYAN;
            default -> this.Color = WHITE;
        }
    }

    public String getColor() {
        return Color;
    }

    public void setContent(int content) {
        this.content = content;
        setColor();
    }

    public int getContent() {
        return content;
    }
}