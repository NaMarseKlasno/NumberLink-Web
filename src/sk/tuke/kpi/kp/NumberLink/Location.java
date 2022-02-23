package sk.tuke.kpi.kp.NumberLink;

public class Location {

    private int elmX, elmY;

    public Location(int x, int y) {
        this.elmX = x;
        this.elmY = y;
    }

    public int getX() {
        return elmX;
    }

    public int getY() {
        return elmY;
    }

    public void setX(int elmX) {
        this.elmX = elmX;
    }

    public void setY(int elmY) {
        this.elmY = elmY;
    }

    public void setXY(int elmX, int elmY) {
        this.elmX = elmX;
        this.elmY = elmY;
    }

    public boolean isCollision(Location checkElm) {
        return this.elmX == checkElm.getX() && this.elmY == checkElm.getY();
    }
}
