package sk.tuke.kpi.kp.NumberLink;

import sk.tuke.kpi.kp.NumberLink.Location;
import sk.tuke.kpi.kp.NumberLink.Tile;
import java.util.Random;


public class Field {

    private int rowCount;
    private int columnCount;
    private int elemCount;
    private Tile[][] tiles;
    private Tile[][] field;

    Location elm1;
    Location elm2;
    Location elm3;

    public Field(int row, int column, int elemCount)
    {
        this.rowCount = row;
        this.columnCount = column;
        this.elemCount = elemCount;
        this.tiles = new Tile[row][column];
        this.field = new Tile[row][column];
        generate();
    }


    public boolean verifyConnection(Field field, Location el1, Location el2)
    {
        return false;
    }

    private void generate()
    {
//        Tile[][] field = new Tile[this.rowCount][this.columnCount];
        for (int i=0; i<rowCount; ++i) {
            for (int j=0; j<columnCount; ++j) {
                this.field[i][j] = new Tile(0);
                this.tiles[i][j] = new Tile(0);
            }
        }

        int content = 1;

        while (maxiAmount()) {

            elm1 = new Location(0,0);
            elm2 = new Location(0,0);
            elm3 = new Location(0,0);

            Random rand = new Random();

            while (elm1.isCollision(elm2) || field[elm1.getY()][elm1.getX()].getContent() != 0 || field[elm2.getY()][elm2.getX()].getContent() != 0) {
                elm1.setXY(rand.nextInt(this.columnCount), rand.nextInt(this.rowCount) );
                elm2.setXY(rand.nextInt(this.columnCount), rand.nextInt(this.rowCount) );
            } //while (elm1.isCollision(elm2) && field[elm1.getX()][elm1.getY()].getContent() != 0 && field[elm2.getX()][elm2.getY()].getContent() != 0);

//            elm1.setXY(0, 0);
//            elm2.setXY(3, 3);

            field[elm1.getY()][elm1.getX()].setContent(content);
            field[elm2.getY()][elm2.getX()].setContent(content);

            printField(field);

            if (elm1.getX() <= elm2.getX() && elm1.getY() < elm2.getY()) {
                f1(content);
            } else if (elm1.getX() > elm2.getX() && elm1.getY() >= elm2.getY()) {
                f2(content);
            } else if (elm1.getX() >= elm2.getX() && elm1.getY() < elm2.getY()) {
                f3(content);
            } else if (elm1.getX() < elm2.getX() && elm1.getY() >= elm2.getY()) {
                f4(content);
            }


            tiles[elm1.getY()][elm1.getX()].setContent(content);
            tiles[elm2.getY()][elm2.getX()].setContent(content);


            ++content;
        }
//        printField(tiles);
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
                    System.out.print( "| "+ tiles[i][j].getContent() + " ");
                    ++res;
                }
            } System.out.print("|");
            System.out.println();

            System.out.print("+");
            for (int j=0; j<columnCount; ++j) {
                System.out.print("---+");
            } System.out.println();
        }
        System.out.println("count of elm: " + res + "/" + this.elemCount*2);
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

    private boolean maxiAmount() {
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.columnCount; j++) {
                if ((this.field[i][j].getContent() == 0) && (field[i+1][j].getContent() == 0 || field[i][j+1].getContent() == 0 || field[i-1][j].getContent() == 0 || field[i][j-1].getContent() == 0)) {
                    return true;
                }
            }
        } return false;
    }



    private void f1(int content) {
        Random rand = new Random();
        elm3.setXY(elm1.getX(), elm1.getY());
        while ( !((elm3.getX()+1==elm2.getX()&&elm3.getY()==elm2.getY()) || (elm3.getX()==elm2.getX()&&elm3.getY()+1==elm2.getY()) || (elm3.getX()-1==elm2.getX()&&elm3.getY()==elm2.getY()) || (elm3.getX()==elm2.getX()&&elm3.getY()-1==elm2.getY())) ) {

            if (elm3.getX()+1 >= columnCount || elm3.getY()+1 >= rowCount) {
                if (elm3.getX()+1 >= columnCount && elm3.getY()+1 >= rowCount) { // если тупик
                    f2(content);
                    return;
                }
                if (elm3.getX()+1 >= columnCount) {
                    elm3.setXY(elm3.getX(),elm3.getY()+1);
                } else elm3.setXY(elm3.getX()+1, elm3.getY());

            }

            else if (field[elm3.getY()+1][elm3.getX()].getContent() != 0 || field[elm3.getY()][elm3.getX()+1].getContent() != 0) {
                if (field[elm3.getY()+1][elm3.getX()].getContent() != 0 && field[elm3.getY()][elm3.getX()+1].getContent() != 0) {
                    f4(content);
                    return;
                } if (field[elm3.getY()+1][elm3.getX()].getContent() != 0) {
                    elm3.setXY(elm3.getX()+1, elm3.getY());
                } else elm3.setXY(elm3.getX(),elm3.getY()+1);
            }

            else {
                int randNum = rand.nextInt(2);
                switch (randNum) {
                    case 0:
                        elm3.setXY(elm3.getX() + 1, elm3.getY());
                        break;
                    case 1:
                        elm3.setXY(elm3.getX(), elm3.getY() + 1);
                        break;
                    default:
                        break;
                }
            }

            field[elm3.getY()][elm3.getX()].setContent(content);
            printField(field);
        }
    }

    private void f2(int content) {
        Random rand = new Random();

        elm3.setXY(elm1.getX(), elm1.getY());

        while ( !((elm3.getX()+1==elm2.getX()&&elm3.getY()==elm2.getY()) || (elm3.getX()==elm2.getX()&&elm3.getY()+1==elm2.getY()) || (elm3.getX()-1==elm2.getX()&&elm3.getY()==elm2.getY()) || (elm3.getX()==elm2.getX()&&elm3.getY()-1==elm2.getY())) ) {

            if (elm3.getX()-1 < 0 || elm3.getY()+1 >= rowCount) {
                if (elm3.getX()-1 < 0 && elm3.getY()+1 >= rowCount) { // если тупик
                     f3(content);
                    return;
                }
                if (elm3.getX()-1 < 0) {
                    elm3.setXY(elm3.getX(),elm3.getY()+1);
                } else elm3.setXY(elm3.getX()+1, elm3.getY());

            }

            else if (field[elm3.getY()+1][elm3.getX()].getContent() != 0 || field[elm3.getY()][elm3.getX()-1].getContent() != 0) {
                if (field[elm3.getY() + 1][elm3.getX()].getContent() != 0 && field[elm3.getY()][elm3.getX() - 1].getContent() != 0) {
                    f1(content);
                    return;
                } if (field[elm3.getY()+1][elm3.getX()].getContent() != 0) {
                    elm3.setXY(elm3.getX()-1, elm3.getY());
                } else elm3.setXY(elm3.getX(),elm3.getY()+1);
            }

            else {
                int randNum = rand.nextInt(2);
                switch (randNum) {
                    case 0:
                        elm3.setXY(elm3.getX() - 1, elm3.getY());
                        break;
                    case 1:
                        elm3.setXY(elm3.getX(), elm3.getY() + 1);
                        break;
                    default:
                        break;
                }
            }

            field[elm3.getY()][elm3.getX()].setContent(content);
            printField(field);
        }
    }

    private void f3(int content) {
        Random rand = new Random();
        elm3.setXY(elm1.getX(), elm1.getY());
        while ( !((elm3.getX()+1==elm2.getX()&&elm3.getY()==elm2.getY()) || (elm3.getX()==elm2.getX()&&elm3.getY()+1==elm2.getY()) || (elm3.getX()-1==elm2.getX()&&elm3.getY()==elm2.getY()) || (elm3.getX()==elm2.getX()&&elm3.getY()-1==elm2.getY())) ) {

            if (elm3.getX()-1 < 0 || elm3.getY()-1 < 0) {
                if (elm3.getX()-1 < 0 && elm3.getY()-1 < 0) { // если тупик
                    f4(content);
                    return;
                }
                if (elm3.getX()-1 < 0) {
                    elm3.setXY(elm3.getX(),elm3.getY()-1);
                } else elm3.setXY(elm3.getX()-1, elm3.getY());

            }

            else if (field[elm3.getY() - 1][elm3.getX()].getContent() != 0 || field[elm3.getY()][elm3.getX() - 1].getContent() != 0) {
                if (field[elm3.getY() - 1][elm3.getX()].getContent() != 0 && field[elm3.getY()][elm3.getX() - 1].getContent() != 0) {
                    f2(content);
                    return;
//                    if (field[elm3.getY()-1][elm3.getX()].getContent() != 0 || field[elm3.getY()][elm3.getX()-1].getContent() != 0) {
//                        if (field[elm3.getY() + 1][elm3.getX()].getContent() != 0) {
//                            break;
//                        }
//                    }

                } if (field[elm3.getY()-1][elm3.getX()].getContent() != 0) {
                    elm3.setXY(elm3.getX()-1, elm3.getY());
                } else elm3.setXY(elm3.getX(),elm3.getY()-1);
            }

            else {
                int randNum = rand.nextInt(2);
                switch (randNum) {
                    case 0:
                        elm3.setXY(elm3.getX() - 1, elm3.getY());
                        break;
                    case 1:
                        elm3.setXY(elm3.getX(), elm3.getY() - 1);
                        break;
                    default:
                        break;
                }
            }

            field[elm3.getY()][elm3.getX()].setContent(content);
            printField(field);
        }
    }

    private void f4(int content) {

        Random rand = new Random();
        elm3.setXY(elm1.getX(), elm1.getY());
        while ( !((elm3.getX()+1==elm2.getX()&&elm3.getY()==elm2.getY()) || (elm3.getX()==elm2.getX()&&elm3.getY()+1==elm2.getY()) || (elm3.getX()-1==elm2.getX()&&elm3.getY()==elm2.getY()) || (elm3.getX()==elm2.getX()&&elm3.getY()-1==elm2.getY())) ) {

            if (elm3.getX()+1 < 0 || elm3.getY()-1 < 0) {
                if (elm3.getX()+1 >= columnCount && elm3.getY()-1 < 0) { // если тупик
                    f1(content);
                    return;
                }
                if (elm3.getX()+1 >= columnCount) {
                    elm3.setXY(elm3.getX(),elm3.getY()-1);
                } else elm3.setXY(elm3.getX()+1, elm3.getY());

            }

            else if (field[elm3.getY() - 1][elm3.getX()].getContent() != 0 || field[elm3.getY()][elm3.getX() + 1].getContent() != 0) {
                if (field[elm3.getY() - 1][elm3.getX()].getContent() != 0 && field[elm3.getY()][elm3.getX() + 1].getContent() != 0) {
                    f3(content);
                    return;
//                    if (field[elm3.getY()-1][elm3.getX()].getContent() != 0 || field[elm3.getY()][elm3.getX()-1].getContent() != 0) {
//                        if (field[elm3.getY() + 1][elm3.getX()].getContent() != 0) {
//                            break;
//                        }
//                    }

                } if (field[elm3.getY()-1][elm3.getX()].getContent() != 0) {
                    elm3.setXY(elm3.getX()+1, elm3.getY());
                } else elm3.setXY(elm3.getX(),elm3.getY()-1);
            }

            else {
                int randNum = rand.nextInt(2);
                switch (randNum) {
                    case 0:
                        elm3.setXY(elm3.getX() + 1, elm3.getY());
                        break;
                    case 1:
                        elm3.setXY(elm3.getX(), elm3.getY() - 1);
                        break;
                    default:
                        break;
                }
            }

            field[elm3.getY()][elm3.getX()].setContent(content);
            printField(field);
        }

    }

}