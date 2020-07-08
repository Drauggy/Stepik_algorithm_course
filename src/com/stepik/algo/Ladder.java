import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ladder {
    public static void main(String[] args) throws IOException {
        new Ladder().Run();
    }

    private void Run() throws IOException {
        int N;
        int[] w;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(reader.readLine());
            w = new int[N];
            String[] input = reader.readLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                w[i] = Integer.parseInt(input[i]);
            }
        }
        Calculate(w);
    }

    private void Calculate(int[] A) {

        int[] B = new int[A.length + 1];

        B[0] = 0;
        B[1] = A[0];
        for (int i = 2; i < B.length; i++) {
            B[i] = Math.max(B[i - 1], B[i - 2]) + A[i - 1];


        }
        System.out.println(B[B.length - 1]);
    }
}
