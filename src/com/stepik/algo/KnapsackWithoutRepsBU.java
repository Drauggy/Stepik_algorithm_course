import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnapsackWithoutRepsBU {
    public static void main(String[] args) throws IOException {
        new KnapsackWithoutRepsBU().Run();
    }

    private void Run() throws IOException {
        int W, n;
        int[] w;
        String[] inputFirstLine;
        String[] inputSecondLine;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFirstLine = reader.readLine().split(" ");
            inputSecondLine = reader.readLine().split(" ");
        }
        W = Integer.parseInt(inputFirstLine[0]);
        n = Integer.parseInt(inputFirstLine[1]);
        w = new int[n];
        for (int i = 0; i < inputSecondLine.length; i++) {
            w[i] = Integer.parseInt(inputSecondLine[i]);
        }
        DinSackBU(W, w);
    }

    private void DinSackBU(int W, int[] w) {
        int[][] D = new int[w.length + 1][W + 1];

        for (int i = 1; i < D.length; i++) {
            for (int j = 1; j < D[0].length; j++) {
                D[i][j] = D[i - 1][j];
                if (w[i - 1] <= j) {
                    D[i][j] = Math.max(D[i][j], D[i - 1][j - w[i - 1]] + w[i - 1]);
                }
            }
        }

        System.out.println(D[D.length - 1][D[0].length - 1]);
//        for (int[] ints : D) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }


    }
}
