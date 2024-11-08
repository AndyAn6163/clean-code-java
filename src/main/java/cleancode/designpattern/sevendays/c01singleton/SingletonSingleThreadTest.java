package cleancode.designpattern.sevendays.c01singleton;

public class SingletonSingleThreadTest implements Runnable {

    @Override
    public void run() {
        SingletonSingleThread singletonSingleThread = SingletonSingleThread.getInstance("id-12345");
        if (singletonSingleThread != null) {
            System.out.println(Thread.currentThread().getName() + " : hashcode of SingletonSingleThread is " + singletonSingleThread.hashCode());
        }
    }

    public static void main(String[] args) {

        int threadNo = 1;
        for (int i = 0; i < 10; i++) {

            /**
             * 一瞬間跑了 10 個 Thread，會發現 hashcode 都不一樣，但如果慢慢跑，就會發現一樣了，代表這個單例只適用於單線程狀況
             *             try {
             *                 Thread.sleep(5000);
             *             } catch (InterruptedException e) {
             *                 throw new RuntimeException(e);
             *             }
             */

            Thread thread = new Thread(new SingletonSingleThreadTest(), "RunnableThread" + threadNo++);
            thread.start();
        }
    }
}
