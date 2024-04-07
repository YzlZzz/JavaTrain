package Ch27;

public class Point {
    private double x;
    private double y;

    public Point(){
        x = 0;
        y = 0;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        Point pt = (Point) obj;
        return (x == pt.getX() && y == pt.getY());
    }

    @Override
    public int hashCode() {
        long bits = java.lang.Double.doubleToLongBits(getX());
        bits ^= (java.lang.Double.doubleToLongBits(getY()) * 31);
        return (int) (bits ^ (bits >> 32));
    }
}
