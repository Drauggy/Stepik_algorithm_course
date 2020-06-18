package com.stepik.algo;

import java.util.Arrays;
import java.util.Scanner;

public class InversionsNumber {
    private int[] mergeSort(int[] massive, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            int[] massiveA = Arrays.copyOfRange(massive,l,m+1);
            int[] massiveB = Arrays.copyOfRange(massive,m+1,r+1);
            return merge(mergeSort(massiveA, l, m), mergeSort(massiveB, m + 1, r));

        }
       return massive;
    }

    private int[] merge(int[] massiveA, int[] massiveB) {
        int[] newMassive = new int[massiveA.length + massiveB.length];
        int length = Math.min(massiveA.length, massiveB.length);
        int i = 0, j = 0;
        while (i < length && j < length) {
            for (int k = 0; k < length; k++) {


                if (massiveA[i] < massiveB[j]) {
                    newMassive[k] = massiveA[i];
                    i++;
                } else {
                    newMassive[k] = massiveB[j];
                    j++;
                }
            }
        }
        if (i >= length) {
            for (int k = j + i; k < newMassive.length; k++) {
                newMassive[k] = massiveB[j];
                j++;
            }
        } else if (j >= length) {
            for (int k = i + j; k < newMassive.length; k++) {
                newMassive[k] = massiveA[i];
                i++;
            }
        }


        return newMassive;
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
        new InversionsNumber().mergeSort(massive,0,massive.length -1);
        long end = System.currentTimeMillis();
        System.out.println("Время исполнения: " + (end - start));
        System.out.println(Arrays.toString(massive));
    }
}
