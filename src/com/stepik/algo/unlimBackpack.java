

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class unlimBackpack {
    private static  BigDecimal result = BigDecimal.ZERO;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        int itemsNumber = Integer.parseInt(inputLine.split(" ")[0]);
        double packageVolume = Double.parseDouble(inputLine.split(" ")[1]);
        List<String> array = new ArrayList<>();
        for (int i = 0; i < itemsNumber; i++) {
            String line = scanner.nextLine();
            array.add(line);
        }
        scanner.close();
        List<double[]> items = new ArrayList<>();
        for(String str: array) {
            items.add(new double[]{Double.parseDouble(str.split(" ")[0]), Double.parseDouble(str.split(" ")[1])});
        }
        Comparator<double[]> sortByFirstElement = (ints, t1) -> {
            if(t1[0] /t1[1] > ints[0] /ints[1]) return 1;
            if(t1[0] /t1[1] < ints[0] /ints[1]) return -1;
            return 0;

        };
        items.sort(sortByFirstElement);
//        for (double[] arr: items
//        ) {
//            System.out.println(Arrays.toString(arr));
//        }
        for (double[] item : items) {
            if (packageVolume == 0) break;
            if (item[1] > packageVolume) {
                result = result.add(BigDecimal.valueOf(packageVolume).multiply(BigDecimal.valueOf(item[0])
                        .divide(BigDecimal.valueOf(item[1]), 7, RoundingMode.HALF_UP)));
                break;
            } else {
                result = result.add(BigDecimal.valueOf(item[0]));
                packageVolume -= item[1];
            }
        }

        System.out.printf("%.3f", result);
    }
}
