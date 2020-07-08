import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class optimumCalc {
    public static void main(String[] args) throws IOException {
        int N;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(reader.readLine());
        }
        int[] D = new int[N + 1];
        {
            int min;
            for (int i = 2; i < N + 1; i++) {
                min = D[i - 1] + 1;
                if (i % 2 == 0) {
                    min = Math.min(min, D[i / 2] + 1);
                }
                if (i % 3 == 0) {
                    min = Math.min(min, D[i / 3] + 1);
                }
                D[i] = min;
            }

            int hopesCount = D[D.length - 1];
            int[] result = new int[hopesCount + 1];
            for (int i = D.length - 1; i > 0; ) {
                if (i % 3 == 0 && D[i / 3] == hopesCount - 1) {
                    result[hopesCount] = i;
                    i = i / 3;
                } else if (i % 2 == 0 && D[i / 2] == hopesCount - 1) {
                    result[hopesCount] = i;
                    i = i / 2;
                } else {
                    result[hopesCount] = i;
                    --i;
                }
                hopesCount--;
            }
            System.out.println(D[D.length - 1]);
            for (int i : result) {
                System.out.print(i + " ");
            }
        }

    }
}
