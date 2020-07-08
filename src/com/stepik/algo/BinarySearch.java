import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    private final int[] inputMassive;
    private final int[] massive4Search;

    private BinarySearch(int[][] input) {
        this.inputMassive = input[0];
        this.massive4Search = input[1];
    }

    private BinarySearch(int[] input, int[] search) {
        this.inputMassive = input;
        this.massive4Search = search;
    }

    private int run(int i) {
        int l = 0;
        int r = inputMassive.length;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m >= inputMassive.length || m < 0 ) return -1;
            if (inputMassive[m] == i) {
                return m + 1;
            } else if (inputMassive[m] > i) {
                r = m - 1;
            } else l = m + 1;
        }
        return -1;
    }

    private static void Test() {
        Random random = new Random();
        int n = random.nextInt(20);
        int m = random.nextInt(10);
        int[] input = new int[n];
        int[] search = new int[m];

        for (int i = 0; i < n; i++) {
            input[i] = random.nextInt(30);
        }
        Arrays.sort(input);
        for (int i = 0; i < m; i++) {
            search[i] = random.nextInt(30);
        }
        System.out.println(Arrays.toString(input) + Arrays.toString(search));
        BinarySearch binarySearch = new BinarySearch(input,search);
        for (int value : search) {
            System.out.print(binarySearch.run(value) + " ");
        }


    }

    private static int[][] input() throws IOException {
        int[][] result = new int[2][];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 2; i++) {
                String inputString = reader.readLine();
                String[] input = inputString.split(" ");
                int n = Integer.parseInt(input[0]);
                int[] copy = new int[n];
                for (int j = 0; j < n; j++) {
                    copy[j] = Integer.parseInt(input[j + 1]);
                }
                result[i] = copy;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BinarySearch binarySearch = new BinarySearch(input());
//        Test();
        for (int i = 0; i < binarySearch.massive4Search.length; i++) {
            System.out.print(binarySearch.run(binarySearch.massive4Search[i])+ " ");
        }
    }
}
