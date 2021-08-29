package homework17.thread;

public class UtilClass {

    public static int COUNTER = 1;

    public static synchronized int readThreadNameAndIncrementValue() {

        String name = Thread.currentThread().getName();
        System.out.println(name + COUNTER);

        return COUNTER++;

    }
}
