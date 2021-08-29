package homework17.thread;

public class MyThread extends java.lang.Thread {

    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i) {
            UtilClass.readThreadNameAndIncrementValue();
        }
    }
}
