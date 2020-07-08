

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gCommon(a, b));
    }
    static int gCommon(int a, int b) {
       if (a == 0) return b;
       if (b == 0) return a;
       if (a >= b) return gCommon(a % b, b);
        return gCommon(a, b % a);

    }
}
