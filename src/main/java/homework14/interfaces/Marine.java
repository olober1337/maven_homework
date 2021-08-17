package homework14.interfaces;

public interface Marine {

    default void march() {
        System.out.println("Marching");
    }

    static void marineMove() {
        System.out.println("Marines are swimming");
    }

    void marineSwimTowardsEnemy();
    void marineGoingBackToTheShip();
}
