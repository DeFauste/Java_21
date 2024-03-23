package ex02;

public class SumRange implements Runnable{
    private int sum = 0;
    private int[] num;
    private int start = 0;
    private int end = 0;
    int nThread = 0;
    SumArrayThread sumArrayThread;
    SumRange(int start, int end, int[] num, SumArrayThread sumArrayThread, int nThread) {
        this.num = num;
        this.start = start;
        this.end = end;
        this.sumArrayThread = sumArrayThread;
        this.nThread = nThread;
    }
    @Override
    public void run() {
        for(int i = start; i < end; i++ ) {
            sum += num[i];
        }
        sumArrayThread.plus(sum);
        System.out.printf("Thread %d: from %d to %d sum is %d\n", nThread, start, end, sum);
    }
}
