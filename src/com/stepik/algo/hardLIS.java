import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class hardLIS {
    private void Run() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] input = new int[n];
            String[] inputLine = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(inputLine[i]);
            }
            LISimpl(input);
        }
    }

    private void LISimpl(int[] input) {
        int n = input.length;
        int[] D = new int[n + 1];
        int[] C = new int[n];
        Arrays.fill(C, -1);
        Arrays.fill(D, Integer.MIN_VALUE);
        D[0] = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            int j = SearchElementPositionNumberLessThanAx(D, input[i]);
            if (D[j - 1] >= input[i] && input[i] >= D[j]) {
                D[j] = input[i];
                C[i] = j;

            }
        }

        long res = Arrays.stream(D)
                .filter((x) -> x > Integer.MIN_VALUE && x < Integer.MAX_VALUE)
                .count();
        System.out.println(res);
        int[] output = new int[(int) res];

        while (res > 0) {
            for (int i = input.length - 1; i >= 0; i--) {
                if (C[i] == res) {
                    output[(int) res - 1] = i + 1;
                    res--;
                }
            }
        }
        Arrays.stream(output)
                .forEach((x) -> System.out.print(x + " "));
    }

    private int SearchElementPositionNumberLessThanAx(int[] D, int x) {
        int l = 0;
        int r = D.length;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m >= D.length) return D.length;
            if (D[m] < x) {
                r = m - 1;
            } else l = m + 1;
            if (r < 0) return 0;
        }
        return (l + r) / 2 + 1;
    }

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        new hardLIS().Run();
        long end = System.currentTimeMillis();
        //System.out.print(end - start);
        // System.out.println(" ms");
    }
}