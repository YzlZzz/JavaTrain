package Ch9;

public class RegularPolygon {
    public static void main(String[] args){
        RegularPolygon a = new RegularPolygon(6, 4);
        RegularPolygon b = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.printf("%-30s%-15s\n", "perimeter", "area");
        System.out.printf("%-30s%-15s\n", a.getPerimeter(), a.getArea());
        System.out.printf("%-30s%-15s\n", b.getPerimeter(), b.getArea());
    }

    //边数
    private int n = 1;

    //边的长度
    private double side = 1.0;

    //x坐标值
    private double x = 0;

    //y坐标值
    private double y = 0;

    public RegularPolygon(){}

    public RegularPolygon(int n, double side){
        this.n = n;
        this.side = side;
    }

    public RegularPolygon(int n, double side, double x, double y){
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public void setN(int n){
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getPerimeter(){
        return n * side;
    }

    public double getArea(){
        return ((n * side * side) / (4 * Math.tan(Math.PI / n)));
    }
}
