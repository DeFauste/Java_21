package ex02;

import java.util.concurrent.*;

public class SumArrayThread {
    private int[] array;
    private int sum = 0;

    SumArrayThread(int[] array) {
        this.array = array;
    }

    synchronized void plus(int value) {
        sum += value;
    }


    public int GetSum(int cThread) {
        int step = (array.length + cThread - 1) / cThread;
        int start = 0;
        int end = Math.min(start + step, array.length);
        ExecutorService executorService = Executors.newFixedThreadPool(cThread);
        Future future = null;
        for (int i = 0; i < cThread; i++) {
            future = executorService.submit(new SumRange(start, end, array, this, i));
            start += step;
            end = Math.min(start + step, array.length);
        }
        try {
            future.get();
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }
}
