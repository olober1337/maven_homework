package homework14.interfaces;

public interface Scout {

    default void march() {
        System.out.println("Marching");
    }

    static void scoutMove() {
        System.out.println("Scouts are running");
    }

    void scoutDeployingOnMission();
    void scoutDetectedTheEnemy();
}

