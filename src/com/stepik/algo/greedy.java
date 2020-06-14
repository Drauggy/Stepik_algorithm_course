package com.stepik.algo;

import java.util.Scanner;

public class greedy {
    private static StringBuilder strOut = new StringBuilder();
    private static void greedyAlgorythm (int n) {
        if (n == 1) {
            System.out.println(1);
            System.out.print(1);
        }
        if (n == 2) {
            System.out.println(1);
            System.out.print(2);
        }
        if (n == 3) {
            System.out.println(2);
            System.out.print("1 2");
        }
        long sum =2;
        for (int i = 3; i < n; i++) {
            sum+=i;
            if (sum >= n) {
              finder(i-1, i-((int)sum-n));
              break;
            }
        }
    }
    private static void finder (int n, int m) {
        System.out.println(n);
        for (int i = 1; i < n; i++) {
            strOut.append(i+" ");
        }
        System.out.print(strOut.toString());
        System.out.print(n+(m-1));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        greedyAlgorythm(input);
    }
}
