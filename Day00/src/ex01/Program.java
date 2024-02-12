package ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.next());
        if (number < 1) {
            System.err.println("Illegal Argument");

        } else {
            for (int div = 2, i = 1; div < number; div++, i++) {
                if (number % div == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
