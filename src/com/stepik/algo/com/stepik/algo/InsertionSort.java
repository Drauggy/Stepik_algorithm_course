package com.stepik.algo;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    private void Sort(int[] massive) {
        int mLength = massive.length;
        for (int i = 1; i < mLength ; i++) {
            int j = i;
            while ( j > 0 && massive[j] < massive[j-1]) {
                int temp = massive[j-1];
                massive[j-1] = massive[j];
                massive[j] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы массива через пробел");
        int[] massive;
        String input = scanner.nextLine();
        String[] in = input.split(" ");
        massive = new int[in.length];
        for (int i = 0; i <in.length ; i++) {
            massive[i] = Integer.parseInt(in[i]);
        }
        long start = System.currentTimeMillis();
        new InsertionSort().Sort(massive);
        long end = System.currentTimeMillis();
        System.out.println("Время исполнения: " + (end - start));
        System.out.println(Arrays.toString(massive));
    }
}
