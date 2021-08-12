package homework1.service;

import homework1.entities.Human;

import java.io.IOException;

public interface Service {

    boolean humanChecker(Human human) throws IOException;

    void writeHumanInfo(Human human) throws IOException;

}
