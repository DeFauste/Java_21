package ex00;

public class Program {
    public static void main(String[] args) {
        int count = 0;
        try {
            count = Integer.parseInt(args[0].split("=")[1]);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int finalCount = count;
        Thread egg = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < finalCount; i++) {
                    System.out.println("Egg");
                    try {
                        Thread.sleep((long) (Math.random()*1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread hen = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < finalCount; i++) {
                    System.out.println("Hen");
                    try {
                        Thread.sleep((long) (Math.random()*1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        egg.start();
        hen.start();

    }
}
