package main.java.sk.tuke.gamestudio.core;

public class Levels {

    private int row;
    private int column;
    private Tile[][] tiles;
    private Tile [][] levelComplete;
    private final int setLvl;

    public Levels(int setLvl) {
        this.setLvl = setLvl;
        setLevel();
    }


    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile[][] getLevelComplete() {
        return levelComplete;
    }


    private void setLevel()
    {
        if (setLvl < 0 || setLvl > 10) {
            System.out.println("No such level exists!");
            return;
        }


        switch (setLvl)
        {
            case 1:
                tiles = new Tile[][] {
                        {new Tile(1), new Tile(2), new Tile(1)},
                        {new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(2), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0)}
                };

                levelComplete = new Tile[][] {
                        {new Tile(1), new Tile(2), new Tile(1)},
                        {new Tile(1), new Tile(2), new Tile(1)},
                        {new Tile(1), new Tile(2), new Tile(1)},
                        {new Tile(1), new Tile(1), new Tile(1)}
                };

                this.row    = 4;
                this.column = 3;

                break;

            case 2:
                tiles = new Tile[][] {
                        {new Tile(1), new Tile(3), new Tile(0), new Tile(1)},
                        {new Tile(0), new Tile(2), new Tile(3), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(2), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(0)}
                };

                levelComplete = new Tile[][] {
                        {new Tile(1), new Tile(3), new Tile(3), new Tile(1)},
                        {new Tile(1), new Tile(2), new Tile(3), new Tile(1)},
                        {new Tile(1), new Tile(2), new Tile(2), new Tile(1)},
                        {new Tile(1), new Tile(1), new Tile(1), new Tile(1)}
                };

                this.row    = 4;
                this.column = 4;

                break;

            case 3:
                tiles = new Tile[][] {
                        {new Tile(1), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(2), new Tile(0)},
                        {new Tile(0), new Tile(3), new Tile(0), new Tile(1)},
                        {new Tile(0), new Tile(2), new Tile(0), new Tile(3)}
                };

                levelComplete = new Tile[][] {
                        {new Tile(1), new Tile(1), new Tile(1), new Tile(1)},
                        {new Tile(2), new Tile(2), new Tile(2), new Tile(1)},
                        {new Tile(2), new Tile(3), new Tile(3), new Tile(1)},
                        {new Tile(2), new Tile(2), new Tile(3), new Tile(3)}
                };

                this.row    = 4;
                this.column = 4;

                break;
            case 4:
                tiles = new Tile[][] {
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(1)},
                        {new Tile(2), new Tile(3), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(2), new Tile(0)},
                        {new Tile(0), new Tile(1), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(3)}
                };

                levelComplete = new Tile[][] {
                        {new Tile(2), new Tile(2), new Tile(2), new Tile(1)},
                        {new Tile(2), new Tile(3), new Tile(2), new Tile(1)},
                        {new Tile(3), new Tile(3), new Tile(2), new Tile(1)},
                        {new Tile(3), new Tile(1), new Tile(1), new Tile(1)},
                        {new Tile(3), new Tile(3), new Tile(3), new Tile(3)}
                };

                this.row    = 5;
                this.column = 4;

                break;
            case 5:
                tiles = new Tile[][] {
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(1), new Tile(2)},
                        {new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(3), new Tile(0)},
                        {new Tile(3), new Tile(1), new Tile(0), new Tile(0), new Tile(0)}
                };

                levelComplete = new Tile[][] {
                        {new Tile(1), new Tile(1), new Tile(1), new Tile(1), new Tile(2)},
                        {new Tile(1), new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
                        {new Tile(1), new Tile(1), new Tile(1), new Tile(1), new Tile(1)},
                        {new Tile(3), new Tile(3), new Tile(3), new Tile(3), new Tile(1)},
                        {new Tile(3), new Tile(1), new Tile(1), new Tile(1), new Tile(1)}
                };

                this.row    = 5;
                this.column = 5;

                break;
            case 6:

                tiles = new Tile[][] {
                        {new Tile(1), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(2), new Tile(0), new Tile(2), new Tile(3), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(1), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(3), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)}
                };

                levelComplete = new Tile[][] {
                        {new Tile(1), new Tile(1), new Tile(2), new Tile(2), new Tile(2)},
                        {new Tile(2), new Tile(1), new Tile(2), new Tile(3), new Tile(2)},
                        {new Tile(2), new Tile(1), new Tile(1), new Tile(3), new Tile(2)},
                        {new Tile(2), new Tile(3), new Tile(3), new Tile(3), new Tile(2)},
                        {new Tile(2), new Tile(2), new Tile(2), new Tile(2), new Tile(2)}
                };

                this.row    = 5;
                this.column = 5;

                break;
            case 7:

                tiles = new Tile[][] {
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(1), new Tile(0)},
                        {new Tile(2), new Tile(3), new Tile(0), new Tile(4), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(4), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(3), new Tile(1), new Tile(0)}
                };

                levelComplete = new Tile[][] {
                        {new Tile(2), new Tile(2), new Tile(2), new Tile(1), new Tile(1)},
                        {new Tile(2), new Tile(3), new Tile(2), new Tile(4), new Tile(1)},
                        {new Tile(3), new Tile(3), new Tile(2), new Tile(4), new Tile(1)},
                        {new Tile(3), new Tile(4), new Tile(4), new Tile(4), new Tile(1)},
                        {new Tile(3), new Tile(3), new Tile(3), new Tile(1), new Tile(1)}
                };

                this.row    = 5;
                this.column = 5;

                break;
            case 8:
                tiles = new Tile[][] {
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(1), new Tile(2)},
                        {new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(3), new Tile(1), new Tile(4), new Tile(3), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(4)}
                };


                levelComplete = new Tile[][] {
                        {new Tile(1), new Tile(1), new Tile(1), new Tile(1), new Tile(2)},
                        {new Tile(1), new Tile(2), new Tile(2), new Tile(2), new Tile(2)},
                        {new Tile(1), new Tile(1), new Tile(4), new Tile(4), new Tile(4)},
                        {new Tile(3), new Tile(1), new Tile(4), new Tile(3), new Tile(4)},
                        {new Tile(3), new Tile(3), new Tile(3), new Tile(3), new Tile(4)}
                };

                this.row    = 5;
                this.column = 5;

                break;
            case 9:
                tiles = new Tile[][] {
                        {new Tile(0), new Tile(1), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(2), new Tile(0), new Tile(3), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(3), new Tile(4), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(1), new Tile(0), new Tile(0)},
                        {new Tile(4), new Tile(0), new Tile(0), new Tile(0), new Tile(2)}
                };

                levelComplete = new Tile[][] {
                        {new Tile(1), new Tile(1), new Tile(2), new Tile(2), new Tile(2)},
                        {new Tile(1), new Tile(2), new Tile(2), new Tile(3), new Tile(2)},
                        {new Tile(1), new Tile(3), new Tile(3), new Tile(3), new Tile(2)},
                        {new Tile(1), new Tile(3), new Tile(4), new Tile(4), new Tile(2)},
                        {new Tile(1), new Tile(1), new Tile(1), new Tile(4), new Tile(2)},
                        {new Tile(4), new Tile(4), new Tile(4), new Tile(4), new Tile(2)}
                };

                this.row    = 6;
                this.column = 5;

                break;
            case 10:
                tiles = new Tile[][] {
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(4), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(3), new Tile(0), new Tile(0), new Tile(2), new Tile(5), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(3), new Tile(1), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(5), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(1), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(4), new Tile(0), new Tile(0)}
                };


                levelComplete = new Tile[][] {
                        {new Tile(2), new Tile(2), new Tile(2), new Tile(4), new Tile(4), new Tile(4), new Tile(4)},
                        {new Tile(2), new Tile(3), new Tile(2), new Tile(2), new Tile(2), new Tile(5), new Tile(4)},
                        {new Tile(2), new Tile(3), new Tile(3), new Tile(3), new Tile(1), new Tile(5), new Tile(4)},
                        {new Tile(2), new Tile(5), new Tile(5), new Tile(5), new Tile(1), new Tile(5), new Tile(4)},
                        {new Tile(2), new Tile(5), new Tile(1), new Tile(1), new Tile(1), new Tile(5), new Tile(4)},
                        {new Tile(2), new Tile(5), new Tile(1), new Tile(5), new Tile(5), new Tile(5), new Tile(4)},
                        {new Tile(2), new Tile(5), new Tile(5), new Tile(5), new Tile(4), new Tile(4), new Tile(4)}
                };

                this.row    = 7;
                this.column = 7;

                break;
            default:
                break;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
