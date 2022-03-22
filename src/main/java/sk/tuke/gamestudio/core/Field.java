package sk.tuke.gamestudio.core;

public class Field {

    private int rowCount;
    private int columnCount;
    private Tile[][] tiles;
    private Levels lvl;

    public Field() {}

    public Field(int lvl)
    {
        generate(lvl);
    }

    public void generate(int setLvl)
    {
        lvl = new Levels(setLvl);

        this.rowCount = lvl.getRow();
        this.columnCount = lvl.getColumn();

        this.tiles = lvl.getTiles();


    }

    public boolean connectTiles(int x, int y, char dir, int count)
    {
        if (count<=0) return true;

        if (('W'==dir && (x-count-1)>=0) || ('E'==dir && (x+count-1)<this.columnCount) || ('N'==dir && (y-count-1)>=0) || ('S'==dir && (y+count-1)<this.rowCount) )
        {
            if (this.tiles[y-1][x-1].getContent() == 0) return false;

            switch (dir) {
                case 'W':
                    for (int i = x-1, j = 0; j <= count; i--, ++j) {
                        this.tiles[y-1][i].setContent(tiles[y-1][x-1].getContent());
                    }
                    break;

                case 'E':
                    for (int i = x-1, j = 0; j <= count; i++, ++j) {
                        this.tiles[y-1][i].setContent(tiles[y-1][x-1].getContent());
                    }
                    break;
                case 'N':
                    for (int i = y-1, j = 0; j <= count; i--, ++j) {
                        this.tiles[i][x-1].setContent(tiles[y-1][x-1].getContent());
                    }
                    break;

                case 'S':
                    for (int i = y-1, j = 0; j <= count; i++, ++j) {
                        this.tiles[i][x-1].setContent(tiles[y-1][x-1].getContent());
                    }
                    break;
            }
            return true;
        }

        return false;
    }

    public boolean isLevelSolved()
    {
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.columnCount; j++) {
                if (this.tiles[i][j].getContent() != this.lvl.getLevelComplete()[i][j].getContent()) {
                    return false;
                }
            }
        }

        return true;
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

}