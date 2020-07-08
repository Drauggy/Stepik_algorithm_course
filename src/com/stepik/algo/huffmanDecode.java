

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class huffmanDecode {
    private static String inputCode;
    private static String output="";
    static class Node {
       String letter;
       String code;


        Node(String letter, String code) {
            this.letter = letter;
            this.code = code;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int charNumbs = Integer.parseInt(firstLine.split(" ")[0]);
        int codeLength = Integer.parseInt(firstLine.split(" ")[1]);
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < charNumbs; i++) {
            String str = scanner.nextLine();
            str = str.replaceAll(":","");
            String[] inputLine = str.split(" ");
            nodes.add(new Node(inputLine[0],inputLine[1]));
        }
        inputCode = scanner.nextLine();
        scanner.close();

        nodes.sort(Comparator.comparingInt(i -> i.code.length()));
        while (inputCode.length() > 0 ) {
            for (Node node : nodes) {
                if (inputCode.startsWith(node.code)) {
                   output+=node.letter;
                  inputCode = inputCode.substring(node.code.length());
                }
            }
        }
        System.out.println(output);
    }
}
