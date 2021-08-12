package homework1.service;

import homework1.entities.Human;

public class UserService extends AbstractService implements Service {

    public static final String ERROR_MESSAGE = "WriteHumanInfo cannot be applied to UserService";

    @Override
    public void writeHumanInfo(Human human) {
        System.out.println(ERROR_MESSAGE);
    }
}