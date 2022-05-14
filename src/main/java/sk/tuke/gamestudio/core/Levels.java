package sk.tuke.gamestudio.core;


//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.IntStream;

public class Levels {

    private int row;
    private int column;
    private Tile[][] tiles;
    private Tile [][] levelComplete;
    private final int setLvl;

//    private List<LevelState> statusList = new ArrayList<>();;

    public Levels(int setLvl)
    {
//        IntStream.rangeClosed(1, 10).forEach(i -> statusList.add(new LevelState(i, LevelState.Status.INACCESSIBLE)));
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
            case 0:
                level_0();
                break;
            case 1:
                level_1();
                break;
            case 2:
                level_2();
                break;
            case 3:
                level_3();
                break;
            case 4:
                level_4();
                break;
            case 5:
                level_5();
                break;
            case 6:
                level_6();
                break;
            case 7:
                level_7();
                break;
            case 8:
                level_8();
                break;
            case 9:
                level_9();
                break;
            case 10:
                level_10();
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


    private void level_0() {
        tiles = new Tile[][] {
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)}
        };


        levelComplete = new Tile[][] {
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(9), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)}
        };

        row    = 7;
        column = 7;
    }




    private void level_1() {
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

        row    = 4;
        column = 3;
    }



    private void level_2() {
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

        row    = 4;
        column = 4;
    }


    private void level_3() {
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

        row    = 4;
        column = 4;
    }


    private void level_4() {
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

        row    = 5;
        column = 4;
    }


    private void level_5() {
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

        row    = 5;
        column = 5;
    }


    private void level_6() {
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

        row    = 5;
        column = 5;
    }


    private void level_7() {
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

        row    = 5;
        column = 5;
    }


    private void level_8() {
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

        row    = 5;
        column = 5;
    }


    private void level_9() {
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

        row    = 6;
        column = 5;
    }


    private void level_10() {
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

        row    = 7;
        column = 7;
    }

}
