package cleancode.designpattern.sevendays.c01singleton;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonGreed singletonGreed = SingletonGreed.getInstance();

        SingletonSingleThread singletonSingleThread = SingletonSingleThread.getInstance("id-12345");
        String valueSingletonSingleThread = singletonSingleThread.getValue();
        System.out.println(valueSingletonSingleThread);

        SingletonSingleThread anotherSingletonSingleThread = SingletonSingleThread.getInstance("id-45678");
        String anotherValueSingletonSingleThread = anotherSingletonSingleThread.getValue();
        System.out.println(anotherValueSingletonSingleThread);

    }
}
