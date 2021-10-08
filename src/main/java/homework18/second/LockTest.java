package homework18.second;

public class LockTest {

    static LockExample lockExample = new LockExample();

    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            private LockExample hero = lockExample;
            @Override
            public void run() {
                hero.agility();
                hero.strength();
                hero.stamina();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            private LockExample hero = lockExample;
            @Override
            public void run() {
                hero.agility();
                hero.strength();
                hero.stamina();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            private LockExample hero = lockExample;
            @Override
            public void run() {
                hero.agility();
                hero.strength();
                hero.stamina();
            }
        });

        thread.start();
        thread2.start();
        thread3.start();

    }
}
