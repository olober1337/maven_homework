package homework1.service;

import homework1.entities.Human;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdminService extends AbstractService implements Service {

    @Override
    public void writeHumanInfo(Human human) throws IOException {

        File file = new File(PATH_TO_FILE);
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(human.toString());
        fileWriter.close();
    }
}
