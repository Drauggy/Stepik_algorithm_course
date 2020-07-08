import java.util.Arrays;
import java.util.Scanner;

public class InversionsNumber {
    private static long count;

    private int[] mergeSort(int[] massive, int l, int r) {
        if (l < r && massive.length != 1) {
            int m = (l + r) / 2;
            int[] massiveA = Arrays.copyOf(massive, m);
            int[] massiveB = Arrays.copyOfRange(massive, m, r);
            return merge(mergeSort(massiveA, l, m), mergeSort(massiveB, 0, r - m));
        }
        return massive;
    }

    private int[] merge(int[] massiveA, int[] massiveB) {
        int[] newMassive = new int[massiveA.length + massiveB.length];
        int length = Math.min(massiveA.length, massiveB.length);
        int i = 0, j = 0;
        int k = 0;
        while (i < massiveA.length && j < massiveB.length) {
            if (massiveA[i] <= massiveB[j]) {
                newMassive[k] = massiveA[i];
                i++;
            } else if (massiveB[j] < massiveA[i]) {
                newMassive[k] = massiveB[j];
                j++;
                count += (massiveA.length - i);
            }
            k++;
        }
        if (i >= length) {
            for (int l = j + i; l < newMassive.length; l++) {
                newMassive[l] = massiveB[j];
                j++;
            }
        } else if (j >= length) {
            for (int l = i + j; l < newMassive.length; l++) {
                newMassive[l] = massiveA[i];
                i++;
            }
        }
        return newMassive;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("Введите элементы массива через пробел");
        int massiveLength = scanner.nextInt();
        int[] massive = new int[massiveLength];
        scanner.nextLine();
        String input = scanner.nextLine();
        String[] in = input.split(" ");
        for (int i = 0; i < massive.length; i++) {
            massive[i] = Integer.parseInt(in[i]);
        }
        // long start = System.currentTimeMillis();
        new InversionsNumber().mergeSort(massive, 0, massive.length);
        //long end = System.currentTimeMillis();
        //System.out.println("Время исполнения: " + (end - start));
        System.out.println(count);
    }
}