package homework14.interfaces;

public interface Infantry {

    default void march() {
        System.out.println("Marching");
    }

    static void infantryMove() {
        System.out.println("Infantry is riding on SUV's");
    }

    void infantryPushingEnemyBack();
    void infantryAskingForHelp();
}
