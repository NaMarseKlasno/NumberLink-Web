package sk.tuke.kpi.kp.NumberLink;

import sk.tuke.kpi.kp.NumberLink.Levels.Level;


public class Field {

    private int rowCount;
    private int columnCount;
    private int elemCount;
    private int setLvl;
    private Tile[][] tiles;
//    private Tile[][] field;

    private static final String RESET  = "\u001B[0m";
    private static final String RED    = "\u001B[31m";
    private static final String GREEN  = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE   = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN   = "\u001B[36m";

    public Field(int lvl)
    {
//        this.rowCount = row;
//        this.columnCount = column;
//        this.elemCount = elemCount;
//        this.tiles = new Tile[row][column];
//        this.field = new Tile[row][column];
        this.setLvl = lvl;
        generate();
    }


//    public boolean verifyConnection(Field field, Location el1, Location el2)
//    {
//        return false;
//    }

    private void generate()
    {
        Level lvl = new Level(setLvl);

        this.rowCount = lvl.getRow();
        this.columnCount = lvl.getColumn();

        this.tiles = lvl.getTiles();

    }

    public void printField(Tile[][] tiles) {
        System.out.println("");
        int res = 0;
        System.out.print("+");
        for (int j=0; j<columnCount; ++j) {
            System.out.print("---+");
        } System.out.println();
        for (int i=0; i<rowCount; ++i) {
            for (int j=0; j<columnCount; ++j) {
                if (tiles[i][j].getContent() == 0) System.out.print("|   ");
                else {
                    switch (tiles[i][j].getContent()) {
                        case 1 -> System.out.print("| " + (RED    + tiles[i][j].getContent() + RESET) + " ");
                        case 2 -> System.out.print("| " + (BLUE   + tiles[i][j].getContent() + RESET) + " ");
                        case 3 -> System.out.print("| " + (GREEN  + tiles[i][j].getContent() + RESET) + " ");
                        case 4 -> System.out.print("| " + (YELLOW + tiles[i][j].getContent() + RESET) + " ");
                        case 5 -> System.out.print("| " + (PURPLE + tiles[i][j].getContent() + RESET) + " ");
                        case 6 -> System.out.print("| " + (CYAN   + tiles[i][j].getContent() + RESET) + " ");
                        default -> System.out.print("| " + tiles[i][j].getContent() + " ");
                    }
                    ++res;
                }
            } System.out.print("|");
            System.out.println();

            System.out.print("+");
            for (int j=0; j<columnCount; ++j) {
                System.out.print("---+");
            } System.out.println();
        }
//        System.out.println("count of elm: " + res + "/" + this.elemCount*2);
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public int getElemCount() {
        return this.elemCount;
    }

//    private boolean maxiAmount() {
//        for (int i = 0; i < this.rowCount; i++) {
//            for (int j = 0; j < this.columnCount; j++) {
//                if ((this.field[i][j].getContent() == 0) && (field[i+1][j].getContent() == 0 || field[i][j+1].getContent() == 0 || field[i-1][j].getContent() == 0 || field[i][j-1].getContent() == 0)) {
//                    return true;
//                }
//            }
//        } return false;
//    }
}