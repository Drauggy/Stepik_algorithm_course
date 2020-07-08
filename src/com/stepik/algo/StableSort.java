import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StableSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] input = new int[n];
        String line = bufferedReader.readLine();
        String[] lines = line.split(" ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(lines[i]);
        }
        int M = 10;
        int[] output = Sort(input, M);
        for (int i : output) {
            System.out.print(i + " ");
        }
    }

    private static int[] Sort(int[] A, int M) {
        int[] B = new int[M];
        int[] Am = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[A[i] - 1] = B[A[i] - 1] + 1;
        }
        for (int i = 1; i < M; i++) {
            B[i] = B[i] + B[i - 1];
        }
        for (int i = A.length - 1; i >= 0; i--) {
            Am[B[A[i] - 1] - 1] = A[i];
            B[A[i] - 1] = B[A[i] - 1] - 1;
        }
        return Am;
    }
}
