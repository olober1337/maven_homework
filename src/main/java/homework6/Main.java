package homework6;

import homework6.exceptions.StringFormatException;
import homework6.utils.Helper;
import homework6.utils.StringHelper;

public class Main {

    public static void main(String[] args) throws StringFormatException {

        StringHelper stringHelper = new StringHelper();
        char[] newArray = {'h','o','m','e','w','o','r','k'};
        String testForCheck = "done";
        System.out.println(stringHelper.checkStringAndArray(testForCheck, newArray));

        String correctPhoneNumber = "+380661213345";
        String correctEmailAddress = "new.email.address1@test.com";
        String correctDateOfBirth = "21.07.1997";

        Helper helper = new Helper();

        helper.phoneChecker(correctPhoneNumber);
        helper.emailChecker(correctEmailAddress);
        helper.dateOfBirthChecker(correctDateOfBirth);

        String incorrectPhoneNumber = "+38066121334511";
        String incorrectEmailAddress = "new.email.addre!@#ss1@test.com";
        String incorrectDateOfBirth = "21.07.1800";

        helper.phoneChecker(incorrectPhoneNumber);
        helper.emailChecker(incorrectEmailAddress);
        helper.dateOfBirthChecker(incorrectDateOfBirth);

    }
}
