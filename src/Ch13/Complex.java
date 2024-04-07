package Ch13;

import java.util.Scanner;

public class Complex implements Cloneable, Comparable<Complex>{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        Complex c1 = new Complex(a, b);

        System.out.print("Enter the second complex number: ");
        double c = input.nextDouble();
        double d = input.nextDouble();
        Complex c2 = new Complex(c, d);

        System.out.println("(" + c1 + ")" + " + " + "(" + c2 + ")" + " = " + c1.add(c2));
        System.out.println("(" + c1 + ")" + " - " + "(" + c2 + ")" + " = " + c1.subtract(c2));
        System.out.println("(" + c1 + ")" + " * " + "(" + c2 + ")" + " = " + c1.multiply(c2));
        System.out.println("(" + c1 + ")" + " / " + "(" + c2 + ")" + " = " + c1.divide(c2));
        System.out.println("|" + c1 + "| = " + c1.abs());

        Complex c3 = (Complex)c1.clone();
        System.out.println(c1 == c3);
        System.out.println(c3.getRealPart());
        System.out.println(c3.getImaginaryPart());
        Complex c4 = new Complex(4, -0.5);
        Complex[] list = {c1, c2, c3, c4};
        java.util.Arrays.sort(list);
        System.out.println(java.util.Arrays.toString(list));
    }
    private double realPart;

    private double imaginaryPart;

    public Complex(){
        this(0, 0);
    }

    public Complex(double realPart){
        this.realPart = realPart;
    }

    public Complex(double realPart, double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public Complex add(Complex complex){
        double real = realPart + complex.realPart;
        double imaginary = imaginaryPart + complex.imaginaryPart;
        return new Complex(real, imaginary);
    }

    public Complex subtract(Complex complex){
        double real = realPart - complex.realPart;
        double imaginary = imaginaryPart - complex.imaginaryPart;
        return new Complex(real, imaginary);
    }

    public Complex multiply(Complex complex){
        double real = realPart * complex.realPart - imaginaryPart * complex.imaginaryPart;
        double imaginary = imaginaryPart * complex.realPart + realPart * complex.imaginaryPart;
        return new Complex(real, imaginary);
    }

    public Complex divide(Complex complex){
        double real = (realPart * complex.realPart + imaginaryPart * complex.imaginaryPart) / (complex.realPart * complex.realPart + complex.imaginaryPart * complex.imaginaryPart);
        double imaginary = (imaginaryPart * complex.realPart - realPart * complex.imaginaryPart) / (complex.realPart * complex.realPart + complex.imaginaryPart * complex.imaginaryPart);
        return new Complex(real, imaginary);
    }

    public double abs(){
        double temp = realPart * realPart + imaginaryPart * imaginaryPart;
        return Math.pow(temp, 0.5);
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    @Override
    public int compareTo(Complex o) {
        return Double.compare(abs(), o.abs());
    }

    @Override
    public String toString(){
        if(imaginaryPart != 0){
            return (realPart + " + " + imaginaryPart + "i");
        }
        else return realPart + "";
    }

    @Override
    public Object clone(){
        return new Complex(realPart, imaginaryPart);
    }
}
