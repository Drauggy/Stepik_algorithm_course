package com.stepik.algo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class unlimitedBackpack {
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
        for (double[] arr: items
             ) {
            System.out.println(Arrays.toString(arr));
        }


           for (int i = 0; i < items.size(); i++) {
               if (packageVolume == 0) break;
               if (items.get(i)[1] > packageVolume) {
                   result = result.add(BigDecimal.valueOf(packageVolume).multiply(BigDecimal.valueOf(items.get(i)[0])
                           .divide(BigDecimal.valueOf(items.get(i)[1]), RoundingMode.HALF_UP)));
                   break;
               }
               else {
                   result = result.add(BigDecimal.valueOf(items.get(i)[0]));
                   packageVolume -= items.get(i)[1];
               }
           }

        System.out.print( result.setScale(3, RoundingMode.HALF_UP));
    }
}
