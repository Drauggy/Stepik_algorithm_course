import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    private void Sort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int k = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[k]) k = j;
            }
            int temp = A[k];
            A[k] = A[i];
            A[i] = temp;

        }
    }

    private void Test() {
        Random random = new Random();
        int[] input = new int[100];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < input.length; j++) {
                input[j] = random.nextInt(100);
            }
            int[] copy = Arrays.copyOf(input, input.length);
            System.out.println(Arrays.equals(copy, input));
            new SelectionSort().Sort(input);
            Arrays.sort(copy);
            System.out.println(Arrays.equals(input, copy));
        }

    }

    public static void main(String[] args) {
        new SelectionSort().Test();

    }
}
