package homework17.thread;

public class MyCallable implements java.util.concurrent.Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 1000; i++) {
            UtilClass.readThreadNameAndIncrementValue();
        }
        return "FINISHED";
    }
}
