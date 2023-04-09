package Day09;

public class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void moveR() {
        this.x += 1;
    }

    public void moveL() {
        this.x -= 1;
    }

    public void moveU() {
        this.y += 1;
    }

    public void moveD() {
        this.y -= 1;
    }

   

    public int getDifferenceX(Pair other) {
        return Math.abs(this.x - other.x);
    }

    public int getDifferenceY(Pair other) {
        return Math.abs(this.y - other.y);
    }

    public int getDifferenceXY(Pair other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

    

    //tostring

    @Override
    public String toString() {
        return "(" +
            getX() + "," +
            getY() + ")";
    }
    
}
