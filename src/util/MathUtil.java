package util;

public class MathUtil {

    /**
     * 返回两个数的最大公约数
     *
     * @return a 与 b 的最大公约数
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a;
            a = b;
            b = r % a;
        }

        return a;
    }

    /**
     * 检查一个数是否为素数
     *
     * @return 如果是素数返回true，反之返回false
     */
    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }


    /**
     * 快速幂
     *
     * @param x 底数x
     * @param n 指数n
     * @return 返回x^n的结果
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1d / quickMul(x, -N);
    }

    public double quickMul(double x, long n) {
        double ans = 1d;

        while (n > 0) {
            if (n % 2 == 1) ans *= x;

            x *= x;
            n >>= 1;
        }
        return ans;
    }


    /**
     * 阶乘运算
     *
     * @return 返回阶乘后的数
     */
    public static long factorial(int n) {
        long res = 1;

        while (n > 0) {
            res *= n;
            n--;
        }
        return res;
    }


}
