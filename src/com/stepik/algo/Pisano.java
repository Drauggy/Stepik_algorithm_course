

import java.util.Scanner;

public class Pisano {
    static int pisanoNumber;

    public static void main(String[] args) throws Exception {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println((fibonacci(n, m)));
    }

    private static int fibonacci(long n, int m) throws Exception {

        int[] numbers_F = new int[(6 * m)];
        numbers_F[0] = 0;
        numbers_F[1] = 1;
        boolean is_zero = false;
        for (int i = 2; i <= 6 * m; i++) {
            numbers_F[i] = (numbers_F[i - 1] + numbers_F[i - 2]) % m;
            if (!is_zero) {
                if (numbers_F[i] == 0) {
                    is_zero = true;
                }
            }
            if (is_zero && numbers_F[i] == 1 && numbers_F[i - 1] == 0) {
                pisanoNumber = i - 1;
                break;
            }
        }
        return numbers_F[(int) (n % pisanoNumber)];
    }
}
