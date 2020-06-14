package com.stepik.algo;

import java.util.*;

public class change {
    private static int number;
    private static Map<Integer,Integer> coins = new HashMap<>();
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        List<Integer> consts = List.of(25,10,5,1);
        for (int i = 0; i < consts.size(); i++) {
            int modus = input % consts.get(i);
            if (modus >= 0 && modus < input)  {
                number = input / consts.get(i);
                coins.put(consts.get(i),number);
                input -=consts.get(i)*number;
            }
        }
            for (Map.Entry<Integer,Integer> entry: coins.entrySet()
                 ) {
                System.out.print("Монеты равенством: "+entry.getKey()+"  Количество---  "+entry.getValue()+"\n");
            }
    }
}
