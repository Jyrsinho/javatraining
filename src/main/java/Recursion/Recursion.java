package Recursion;

public class Recursion {

    /**
     * Counts the fibonacci number of given integer recursively
     * @param n given integer
     * @return fibonacci number of given integer recursively
     */
        public static int recursiveFibonacci(int n) {
            if (n <= 1) {
                return n;
            }

            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }


    /**
     * Counts the fibonacci number of given integer iteratively
     * @param n given integer
     * @return fibonacci number of given integer recursively
     */
    public static int iterativeFibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        int i = 0;
        int j = 1;
        int loops = 1;
        int fibonacci = 0;

        while (loops < n) {
            fibonacci = i + j;
            i = j;
            j = fibonacci;
            loops++;
        }
        return fibonacci;
        }

}
