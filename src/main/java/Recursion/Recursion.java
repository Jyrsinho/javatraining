package Recursion;

public class Recursion {

    /**
     * Counts the fibonacci number of given integer
     * @param n given integer
     */
        public static int recursiveFibonacci(int n) {
            if (n <= 1) {
                return n;
            }

            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }

}
