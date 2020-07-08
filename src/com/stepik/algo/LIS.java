

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LIS {
    private void Run() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
         int n = Integer.parseInt(reader.readLine());

         int[] input = new int[n];
         String[] inputLine = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(LISimpl(input));

        }

    }
    private int LISimpl(int[] A) {
        int ans;
        int[] D = new int[A.length];
        for (int i = 0; i < D.length; i++) {
            D[i] = 1;
            for (int j = 0; j <= i - 1 ; j++) {
                if (A[j] <= A[i] && A[i]%A[j]==0 && D[j] +1 > D[i]) {
                    D[i] = D[i] + 1;
                }
            }
        }
        ans = 0;
        for (int i = 0; i < A.length ; i++) {
            ans = Math.max(ans, D[i]);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        new LIS().Run();
        long end = System.currentTimeMillis();
        System.out.print(end - start);
        System.out.println(" ms");
    }
}
