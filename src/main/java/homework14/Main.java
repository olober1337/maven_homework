package homework14;

import homework14.helper.Helper;
import homework14.interfaces.*;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        interfacesCall();
        helperCall();
    }

    public static void interfacesCall() {

        Army army = new Army();

        army.march();
        Infantry.infantryMove();
        Scout.scoutMove();
        army.infantryPushingEnemyBack();
        army.infantryAskingForHelp();
        army.scoutDeployingOnMission();
        army.scoutDetectedTheEnemy();

        SpecialForces specialForces = new SpecialForces();

        specialForces.march();
        Aviation.aviationMove();
        Marine.marineMove();
        specialForces.aviationDroppingBombs();
        specialForces.aviationRetreatingToBase();
        specialForces.marineSwimTowardsEnemy();
        specialForces.marineGoingBackToTheShip();

    }

    public static void helperCall() {

        Helper helper = new Helper();

        Optional<String> validEmail = helper.modifyString("hello@gmail.com");
        validEmail.ifPresent(System.out::println);

        Optional<String> invalidEmail = helper.modifyString("wfewfefewffwfwfwfw");
        invalidEmail.ifPresent(System.out::println);

    }
}
