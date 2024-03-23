package ex01;

public class Program {
    public static void main(String[] args) {
        int count = 0;
        try {
            count = Integer.parseInt(args[0].split("=")[1]);
            God god = new God(count);

            Egg egg = new Egg(god);
            Hen hen = new Hen(god);
            egg.start();
            hen.start();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

class God {
    private int count = 0;

    God(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private int hg = 0;

    synchronized void egg() throws InterruptedException { //put
        while (hg > 1) {
            wait();
        }
        hg++;
        System.out.printf("Egg=%d\n", hg);
        notify();
    }

    synchronized void hen() throws InterruptedException { // get
        while (hg < 1) {
            wait();
        }
        System.out.printf("Hen=%d\n", hg);
        hg--;
        notify();
    }
}

class Egg extends Thread {
    private God god;

    Egg(God god) {
        this.god = god;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < god.getCount(); i++)
                god.egg();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Hen extends Thread {
    private God god;

    Hen(God god) {
        this.god = god;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < god.getCount();i++ )
                god.hen();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}