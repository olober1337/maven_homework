package homework17.thread;

public class MyRunnable implements java.lang.Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i) {
            UtilClass.readThreadNameAndIncrementValue();
        }
    }
}
