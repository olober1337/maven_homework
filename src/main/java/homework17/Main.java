package homework17;

import homework17.deadlock.Tesla;
import homework17.deadlock.Volkswagen;
import homework17.thread.MyCallable;
import homework17.thread.MyRunnable;
import homework17.thread.MyThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread thread = new MyThread("Sebek");

        thread.start();
        thread.join();

        Thread thread1 = new Thread(new MyRunnable());

        thread1.start();
        thread1.setName("Kotlovan");
        thread1.join();

        MyCallable myCallable = new MyCallable();

        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        thread2.setName("Vkus i aromat");
        System.out.println(futureTask.get());
        thread2.join();

        //5.1 После пяти запусков, диапазон с 3000 до 3000.
        //5.2 После добавления synchronized после пяти запусков диапазон с 1770 до 3000.
        //5.3 После join, тред 1 - с 1 до 1000, тред 2 = с 1001 до 2000, тред 3 - с 2001 до 3000.

        deadlockExample();
    }

    private static void deadlockExample() {

            Volkswagen volkswagen = new Volkswagen();
            Tesla tesla = new Tesla();

            volkswagen.setTesla(tesla);
            tesla.setVolkswagen(volkswagen);

            Thread firstThread = new Thread(() -> System.out.println(volkswagen.getStringFromTesla()));
            Thread secondTread = new Thread(() -> System.out.println(tesla.getStringFromVolkswagen()));
            firstThread.start();
            secondTread.start();
    }
}
