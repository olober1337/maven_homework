package homework1.service;

import homework1.entities.Human;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractService implements Service {

    static final String PATH_TO_FILE = "C:\\Users\\mcram\\Desktop\\homework_1\\homework_OOP.txt";

    @Override
    public boolean humanChecker(Human human) throws IOException {

        FileReader fileReader = new FileReader(PATH_TO_FILE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String emailAddress;
        String emailAddressChecker = human.getEmailAddress();
        while ((emailAddress = bufferedReader.readLine()) != null) {
            if (emailAddress.equals(emailAddressChecker)) {
                return true;
            }
        }
        bufferedReader.close();
        fileReader.close();
        return false;
    }
}