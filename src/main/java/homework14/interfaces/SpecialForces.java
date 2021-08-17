package homework14.interfaces;

public class SpecialForces implements Marine, Aviation{

    @Override
    public void march() {
        System.out.println("Special Forces are standing together to protect the land!");
    }

    @Override
    public void aviationDroppingBombs() {
        System.out.println("The bombs have reached the targets.");
    }

    @Override
    public void aviationRetreatingToBase() {
        System.out.println("Mission successful. Retreat to base.");
    }

    @Override
    public void marineSwimTowardsEnemy() {
        System.out.println("Quite, they should not hear us.");
    }

    @Override
    public void marineGoingBackToTheShip() {
        System.out.println("The commander is eliminated. Seals, go back to the ship.");
    }
}
