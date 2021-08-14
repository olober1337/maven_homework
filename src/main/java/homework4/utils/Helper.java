package homework4.utils;

import homework4.exceptions.UserExpectedError;
import homework4.exceptions.WrongFieldException;
import homework4.exceptions.WrongSumException;

public class Helper {

    public void checkIdLength(String clientID) throws WrongFieldException {

        if (clientID.length() != 10) {
            throw new WrongFieldException();
        }
    }

    public void checkSum(Double sum) throws WrongSumException {

        if (sum >= 1000.00) {
            throw new WrongSumException();
        }
    }

    public void checkAccountId(String senderID, String receiverId) {

        if (senderID.equals(receiverId)) {
            throw new UserExpectedError();
        }
    }
}