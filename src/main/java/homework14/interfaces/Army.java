package homework14.interfaces;

public class Army implements Scout, Infantry{

    @Override
    public void march() {
        System.out.println("Scout and infantry, march!");
    }

    @Override
    public void infantryPushingEnemyBack() {
        System.out.println("Target confirmed, move move move!");
    }

    @Override
    public void infantryAskingForHelp() {
        System.out.println("Mayday, mayday, two men hit. Need backup!");
    }

    @Override
    public void scoutDeployingOnMission() {
        System.out.println("No worries guys, we're here to help.");
    }

    @Override
    public void scoutDetectedTheEnemy() {
        System.out.println("Enemy detected. Working on target.");
    }
}
