package cleancode.designpattern.sevendays.c01singleton;

public class SingletonSingleThread {

    private static SingletonSingleThread instance;

    private String value;

    private SingletonSingleThread(String value) {

        // 模擬建立這個物件需要耗費很多資源的狀況
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.value = value;

    }

    // 注意要標記成 static method
    public static SingletonSingleThread getInstance(String value) {
        if (instance == null) {
            // 只有第一次建立這個物件的時候，才會有塞值得動作
            instance = new SingletonSingleThread(value);
        }
        return instance;
    }

    public String getValue() {
        return value;
    }
}
