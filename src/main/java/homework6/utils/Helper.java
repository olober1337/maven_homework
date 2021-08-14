package homework6.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Helper {

    public void phoneChecker(String phoneNumber) {

        Pattern pattern = Pattern.compile("^((\\+?380)([0-9]{9}))$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            System.out.println("Phone number " + phoneNumber + " is correct");
        } else {
            System.out.println("Phone number " + phoneNumber + " is not correct");
        }
    }

    public void emailChecker(String emailAddress) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(emailAddress);

        if (matcher.matches()) {
            System.out.println("Email address " + emailAddress + " is correct");
        } else {
            System.out.println("Email address " + emailAddress + " is incorrect");
        }
    }

    public void dateOfBirthChecker(String dateOfBirth) {

        Pattern pattern = Pattern.compile("^((0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d{2}))");
        Matcher matcher = pattern.matcher(dateOfBirth);

        if (matcher.matches()) {
            System.out.println("Date of birth " + dateOfBirth + " is correct");
        } else {
            System.out.println("Date of birth " + dateOfBirth + " is incorrect");
        }
    }
}
