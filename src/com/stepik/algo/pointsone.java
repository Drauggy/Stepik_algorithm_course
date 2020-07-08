

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class pointsone {
    private static List<int[]> input = new ArrayList<>();
    private static int pointsNumber;
    private static int optimPoints = 1;
    private static List<Integer> ouput = new ArrayList<>();


    private static void optimizePoints(List<int[]> in) {
        ouput.add(in.get(in.size() - 1)[0]);
        for (int i = in.size() - 2; i >= 0; i--) {
            if (ouput.get(ouput.size() - 1) <= in.get(i)[1] && ouput.get(ouput.size() - 1) >= in.get(i)[0]) {
            } else {
                optimPoints++;
                ouput.add(in.get(i)[0]);
            }
        }
    }

    public static void main(String[] args) {
        List<String> inputNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        pointsNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < pointsNumber; i++) {
            String line = scanner.nextLine();
            inputNumbers.add(line);
            input.add(new int[]{Integer.parseInt(inputNumbers.get(i).split(" ")[0]),
                    Integer.parseInt(inputNumbers.get(i).split(" ")[1])});
        }
        scanner.close();
//        sort(input);

        input.sort(Comparator.comparingInt(o -> o[0]));
//        for (int[] a: input
//             ) {
//            System.out.println(Arrays.toString(a));
//        }
        optimizePoints(input);
        System.out.println(optimPoints);
        for (int i : ouput
        ) {
            System.out.print(i + " ");
        }

    }
}
