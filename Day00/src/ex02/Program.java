package ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number, count = 0;
        while (true) {
            number = Integer.parseInt(scanner.next());
            if (number == 42) break;
            int sum = 0;
            for (int i = number; i != 0 && number != 42; i /= 10) {
                sum += i % 10;
            }
            boolean notSimple = false;
            for (int div = 2; div < sum; div++) {
                if (sum % div == 0) {
                    notSimple = true;
                    break;
                }
            }
            if (!notSimple) count++;
        }
        System.out.println("Count of coffee-request – " + count);
    }
}
