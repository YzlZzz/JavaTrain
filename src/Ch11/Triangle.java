package Ch11;

import java.util.Date;
import java.util.Scanner;

public class Triangle extends GeometricObject{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 3 side: ");

        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        Triangle tri = new Triangle(side1, side2, side3);

        System.out.print("Enter color of Triangle: ");
        String color = input.next();
        tri.setColor(color);

        System.out.print("Enter filled of triangle(true or false): ");
        boolean isFilled = input.nextBoolean();
        tri.setFilled(isFilled);

        System.out.println(tri.toString());
        System.out.println("color: " + tri.getColor());
        System.out.println("IsFilled: " + tri.isFilled());
    }

    final private double side1;

    final private double side2;

    final private double side3;

    public Triangle(){
        this(1.0, 1.0, 1.0);
    }

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1(){
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea(){
        double s = (side1 + side2 + side3) / 2;
        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    @Override
    public String toString(){
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}

class GeometricObject{
    private String color;

    private boolean filled;

    private java.util.Date dateCreated;

    public GeometricObject(){
        this("white", false);
        dateCreated = new Date(System.currentTimeMillis());
    }

    public GeometricObject(String color, boolean filled){
        this.color = color;
        this.filled = filled;
        dateCreated = new Date(System.currentTimeMillis());
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String toString(){
        return "color: " + color + " isFilled: " + filled;
    }
}
