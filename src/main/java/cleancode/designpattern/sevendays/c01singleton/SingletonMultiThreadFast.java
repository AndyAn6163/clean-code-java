package cleancode.designpattern.sevendays.c01singleton;

public class SingletonMultiThreadFast {

    private static SingletonMultiThreadFast instance;

    private String value;

    private SingletonMultiThreadFast(String value){

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.value = value;
    }

    // synchronized 放在 getInstance 方法上效能會變差
    // 應該只需要放在 new SingletonMultiThreadFast 這裡就好
    public static SingletonMultiThreadFast getInstance(String value){
        if(instance == null){
            synchronized (SingletonMultiThreadFast.class) {
                if(instance == null) {
                    instance = new SingletonMultiThreadFast(value);
                }
            }
        }
        return instance;
    }

    public String getValue(){
        return value;
    }
}
