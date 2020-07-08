import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        Test();
    }

    private static void Sort(int[] A) {
        BuildMaxHeap(A);
        int size = A.length;
        for (int i = A.length - 1; i > 0; i--) {
            int temp = A[size - 1];
            A[size - 1] = A[0];
            A[0] = temp;
            size--;
            SiftDown(A, 0, size);

        }

    }

    private static void BuildMaxHeap(int[] A) {
        for (int i = A.length / 2 - 1; i >= 0; i--) {
            SiftDown(A, i, 0);
        }
        System.out.println("Heap is: " + Arrays.toString(A));
    }

    private static void SiftDown(int[] A, int i, int size) {
        int length;
        if (size != 0) {
            length = size;
        } else length = A.length;
        int switcher = A[i];
        int switcherPos = i;
        boolean isSorted = false;
        while (!isSorted) {
            int leftChild = findLeftChild(switcherPos);
            int rightChild = findRightChild(switcherPos);

            int interMax;
            if (leftChild >= length) {
                break;
            } else if (rightChild >= length) {
                if (A[leftChild] < switcher) {
                    break;
                }
                interMax = A[leftChild];
                A[leftChild] = switcher;
                A[switcherPos] = interMax;

                isSorted = true;
            } else if (switcher <= A[leftChild] || switcher <= A[rightChild]) {


                if (A[leftChild] >= A[rightChild]) {
                    interMax = A[leftChild];
                    A[leftChild] = switcher;
                    A[switcherPos] = interMax;
                    switcherPos = leftChild;

                } else if (A[leftChild] < A[rightChild]) {
                    interMax = A[rightChild];
                    A[rightChild] = switcher;
                    A[switcherPos] = interMax;
                    switcherPos = rightChild;

                }
            } else isSorted = true;
        }

    }

    private static void Test() {
        Random random = new Random();
        int[] input = new int[8];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < input.length; j++) {
                input[j] = random.nextInt(10);
            }
            //    int[] input = {3,2,4,1,7,0,9,7};
            System.out.println(Arrays.toString(input));
            int[] copy = Arrays.copyOf(input, input.length);
            Arrays.sort(copy);
            Sort(input);
            if (Arrays.equals(copy, input)) System.out.println("TRUE");
        }

    }


    private static int findLeftChild(int i) {
        return 2 * i + 1;
    }

    private static int findRightChild(int i) {
        return 2 * i + 2;
    }

}
