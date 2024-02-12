package ex00;

public class Program {
    public static void main(String[] args) {
        Integer number = 479598;
        Integer sum = 0;

        for (int i = number; i != 0; i /= 10) {
            sum += i % 10;
        }
        System.out.println(sum);
    }
}
