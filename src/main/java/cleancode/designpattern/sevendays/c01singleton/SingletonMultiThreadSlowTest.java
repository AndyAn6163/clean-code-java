package cleancode.designpattern.sevendays.c01singleton;

public class SingletonMultiThreadSlowTest implements Runnable {
    @Override
    public void run() {
        SingletonMultiThreadSlow singletonMultiThreadSlow = SingletonMultiThreadSlow.getInstance("id-12345");
        if (singletonMultiThreadSlow != null) {
            System.out.println(Thread.currentThread().getName() + " : hashcode of singletonMultiThreadSlow is " + singletonMultiThreadSlow.hashCode());
        }
    }

    public static void main(String[] args) {
        int threadNo = 1;
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SingletonMultiThreadSlowTest(), "RunnableThread" + threadNo++);
            thread.start();
        }
    }
}
