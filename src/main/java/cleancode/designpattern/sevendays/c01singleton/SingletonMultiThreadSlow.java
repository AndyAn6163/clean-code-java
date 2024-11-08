package cleancode.designpattern.sevendays.c01singleton;

public class SingletonMultiThreadSlow {

    private static SingletonMultiThreadSlow instance;

    private String value;

    private SingletonMultiThreadSlow(String value){

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.value = value;
    }

    // 增添 synchronized 讓 getInstance 方法呼叫時被鎖住，方法完成後才釋放，因此效能不好
    public static synchronized SingletonMultiThreadSlow getInstance(String value){
        if(instance == null){
            instance = new SingletonMultiThreadSlow(value);
        }
        return  instance;
    }

    public String getValue(){
        return value;
    }
}
