package sk.tuke.kpi.kp.NumberLink.Levels;
import sk.tuke.kpi.kp.NumberLink.Tile;

public class Level {

    private int row;
    private int column;
    private Tile[][] tiles;
    private Tile [][] levelComplete;
    private int setLvl;

//    enum DifficultyLevel {
//        EASY,
//        MEDIUM,
//        HARD
//    }

    public Level( int setLvl) {
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
            case 2:
                tiles = new Tile[][] {
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(1)},
                        {new Tile(2), new Tile(3), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(2), new Tile(0)},
                        {new Tile(0), new Tile(1), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(3)}
                };

                this.row    = 5;
                this.column = 4;

                break;
            case 3:
                tiles = new Tile[][] {
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(1), new Tile(2)},
                        {new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                        {new Tile(0), new Tile(0), new Tile(0), new Tile(3), new Tile(0)},
                        {new Tile(3), new Tile(1), new Tile(0), new Tile(0), new Tile(0)}
                };

                this.row    = 5;
                this.column = 5;


                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//            case 7:
//                break;
//            case 8:
//                break;
//            case 9:
//                break;
//            case 10:
//                break;
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
