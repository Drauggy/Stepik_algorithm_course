import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lebenstein {
    private void run() throws IOException {
        String A, B;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            A = reader.readLine();
            B = reader.readLine();
        }
        String[] massiveA = A.split("");
        String[] massiveB = B.split("");
        RedactionLength(massiveA, massiveB);
    }

    private void RedactionLength(String[] A, String[] B) {
        int[][] D = new int[A.length + 1][B.length + 1];
        for (int i = 0; i <= A.length; i++) {
            D[i][0] = i;
        }
        for (int i = 0; i <= B.length; i++) {
            D[0][i] = i;
        }
        int c = 0;
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < B.length + 1; j++) {

                if (!A[i - 1].equals(B[j - 1])) {
                    c = 1;
                }
                D[i][j] = Math.min(D[i - 1][j] + 1, Math.min(D[i][j - 1] + 1, D[i - 1][j - 1] + c));
                c = 0;
            }
        }
        System.out.println(D[A.length][B.length]);
//        for (int[] ints : D) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
    }

    public static void main(String[] args) throws IOException {
        new Lebenstein().run();
    }
}
