import java.util.Arrays;
import java.util.Random;

public class quicksort {
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
        quickSortR(A, l, m);
        quickSortR(A, m + 1, r);
        return A;
    }
/*
Quicksort3 - быстрая сортировка с выбором случайного разделителя и элиминацией хвостовой рекурсии
 */
    private int[] quickSortREL(int[] A, int l, int r) {
        while ( l < r) {


            Random random = new Random();
            int randomElement = random.nextInt(r - l) + l;
            int a = A[randomElement];
            A[randomElement] = A[l];
            A[l] = a;
            int m = Partition(A, l, r);
            if (m - 1 - l < r - (m + 1)) {
                quickSort3(A, l, m);
                l = m + 1;
            } else {
                quickSort3(A, m + 1, r);
                r = m;

            }
        }
            return A;

    }
    private int[] quickSort3(int[] A, int l, int r) {
        while ( l < r) {


            Random random = new Random();
            int randomElement = random.nextInt(r - l) + l;
            int a = A[randomElement];
            A[randomElement] = A[l];
            A[l] = a;
            int[] m = Partition3(A, l, r);
            if (m[0] - 1 - l < r - (m[1] + 1)) {
                quickSort3(A, l, m[0]);
                l = m[1] + 1;
            } else {
                quickSort3(A, m[1] + 1, r);
                r = m[0];

            }
        }
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
    private int[] Partition3(int[] A, int l, int r) {
        int x = A[l];
        int j = l;
        int k = j;
        for (int i = l + 1; i < r; i++) {
            if (A[i] < x) {
                j++;
                k++;
                int temp = A[i];
                A[i] = A[k];
                A[k] = temp;
                temp = A[k];
                A[k] = A[j];
                A[j] = temp;
            }
            else if ( A[i] == x) {
                k++;
                int temp = A[i];
                A[i] = A[k];
                A[k] = temp;
            }
        }
        int temp = A[l];
        A[l] = A[j];
        A[j] = temp;
        return new int[]{j,k};
    }


    private void Test() {
        Random random = new Random();
        int[] testMasssive = new int[500];
        for (int j = 0; j < 100; j++) {


            for (int i = 0; i < 500; i++) {
                testMasssive[i] = random.nextInt(8);
            }
            int[] A = new quicksort().quickSort3(testMasssive, 0, testMasssive.length);
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

        new quicksort().Test();

    }
}