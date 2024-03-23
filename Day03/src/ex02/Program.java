package ex02;

public class Program {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        SumArrayThread arrayThread = new SumArrayThread(a);
        int sum = arrayThread.GetSum(3);
        System.out.printf("Sum by threads: %d", sum);
    }
}
