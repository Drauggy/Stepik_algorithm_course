package com.stepik.algo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    private int[] quickSort(int[] A, int l, int r) {
        if (l >= r) return A;
        int m = Partition(A, l, r);
        quickSort(A, l, m);
        quickSort(A, m + 1, r);
        return A;
    }
    private int[] quickSortR(int[] A, int l, int r) {
        if (l >= r) return A;
        Random random = new Random();
        int randomElement = random.nextInt(r - l) + l;
        int a = A[randomElement];
        A[randomElement] = A[l];
        A[l] = a;
        int m = Partition(A, l, r);
        quickSort(A, l, m);
        quickSort(A, m + 1, r);
        return A;
    }

    private int Partition(int[] A, int l, int r) {
        int x = A[l];
        int j = l;
        for (int i = l + 1; i < r; i++) {
            if (A[i] <= x) {
                j++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[l];
        A[l] = A[j];
        A[j] = temp;
        return j;
    }

    private void Test() {
        Random random = new Random();
        int[] testMasssive = new int[40];
        for (int j = 0; j < 100; j++) {


            for (int i = 0; i < 40; i++) {
                testMasssive[i] = random.nextInt(100);
            }
            int[] A = new QuickSort().quickSortR(testMasssive, 0, testMasssive.length);
            int[] B = Arrays.stream(testMasssive)
                    .sorted().toArray();

            if (Arrays.equals(A, B)) System.out.println("Верно");
            else {
                System.out.println("Error");
                System.out.println(Arrays.toString(A));
                System.out.println(Arrays.toString(B));
            }
        }
    }

    public static void main(String[] args) {
//        int[] massive;
//        String input;
//        try (Scanner scanner = new Scanner(System.in)) {
//            System.out.println("Введите элементы массива через пробел");
//            int massiveLength = scanner.nextInt();
//            massive = new int[massiveLength];
//            scanner.nextLine();
//            input = scanner.nextLine();
//        }
//        String[] in = input.split(" ");
//        for (int i = 0; i < massive.length; i++) {
//            massive[i] = Integer.parseInt(in[i]);
//        }
//        // long start = System.currentTimeMillis();
//        System.out.println(Arrays.toString(new QuickSort().quickSort(massive, 0, massive.length)));
//        //long end = System.currentTimeMillis();
//        //System.out.println("Время исполнения: " + (end - start));
         new QuickSort().Test();

    }
}
