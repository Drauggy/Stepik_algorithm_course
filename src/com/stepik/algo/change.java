

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class change {
    private static int number;
    private static Map<Integer,Integer> coins = new HashMap<>();
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        List<Integer> consts = List.of(25,10,5,1);
            for (Integer aConst : consts) {
                int modus = input % aConst;
                if (modus >= 0 && modus < input) {
                    number = input / aConst;
                    coins.put(aConst, number);
                    input -= aConst * number;
                }
            }
            for (Map.Entry<Integer,Integer> entry: coins.entrySet()
                 ) {
                System.out.print("Монеты равенством: "+entry.getKey()+"  Количество---  "+entry.getValue()+"\n");
            }
    }
}
