package Ch18;

public class LogarithmSum {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }
    public static double sum(double i){
        double sum = 0;
        if(i == 1){
            return 1;
        }
        sum = 1.0 / i + sum(i - 1);
        return sum;
    }
}
