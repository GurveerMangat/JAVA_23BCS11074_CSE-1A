class MyClass1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread Example");
    }
}

class MyClass2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable Example");
    }
}

public class Q2 {
    public static void main(String[] args) {
        Thread t1 = new MyClass1();
        Thread t2 = new Thread(new MyClass2());
        t1.start();

        try {
            t1.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}
