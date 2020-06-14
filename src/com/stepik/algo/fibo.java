package com.stepik.algo;

import java.util.Scanner;

public class fibo {

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));

    }
    private static int fibonacci(int n) {
        int[] numbers_F = new int[n+1];
        numbers_F[0] = 0;
        numbers_F[1] = 1;
        for (int i = 2; i <= n; i++) {
            numbers_F[i] = (numbers_F[i-1] + numbers_F[i-2]);
        }

        return numbers_F[n];
    }


}
