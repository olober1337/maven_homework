package homework14.interfaces;

public interface Aviation {

    default void march() {
        System.out.println("Marching");
    }

    static void aviationMove() {
        System.out.println("Aviation is flying");
    }

    void aviationDroppingBombs();
    void aviationRetreatingToBase();
}
