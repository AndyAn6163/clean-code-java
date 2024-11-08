package cleancode.designpattern.sevendays.c01singleton;

public class SingletonMultiThreadFastTest implements Runnable {
    @Override
    public void run() {
        SingletonMultiThreadFast singletonMultiThreadFast = SingletonMultiThreadFast.getInstance("id-12345");
        if (singletonMultiThreadFast != null) {
            System.out.println(Thread.currentThread().getName() + " : hashcode of singletonMultiThreadFast is " + singletonMultiThreadFast.hashCode());
        }
    }

    public static void main(String[] args) {
        int threadNo = 1;
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SingletonMultiThreadFastTest(), "RunnableThread" + threadNo++);
            thread.start();
        }
    }
}
