import java.util.Scanner;

public class SimpleSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        System.out.print(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
    }

}
