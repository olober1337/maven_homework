package homework4;

import homework4.entities.Client;
import homework4.exceptions.WrongFieldException;
import homework4.exceptions.WrongSumException;
import homework4.services.TransactionService;
import homework4.utils.Helper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the sender account ID : ");
        String senderId = scanner.nextLine();
        String validLengthOfSenderId = lengthCheckerMethod(senderId, scanner);
        client.setClientID(validLengthOfSenderId);

        System.out.println("Please enter the receiver account ID : ");
        String receiverId = scanner.nextLine();
        String validLengthOfReceiverAccountId = lengthCheckerMethod(receiverId, scanner);

        System.out.println("Please enter the sum of the transaction : ");
        double sum = scanner.nextDouble();
        Double validSumOfTransaction = sumCheckerMethod(sum, scanner);
        client.setSum(validSumOfTransaction);
        scanner.close();

        TransactionService transactionService = new TransactionService();
        transactionService.moneyTransaction(validLengthOfSenderId, validLengthOfReceiverAccountId);
        System.out.println("Transfer successful!");

    }

    private static String lengthCheckerMethod (String lengthCheck, Scanner scannerLengthChecker) {

        Helper helperLengthChecker = new Helper();

        while (lengthCheck.length() != 10) {
            try {
                helperLengthChecker.checkIdLength(lengthCheck);
            } catch (WrongFieldException e) {
                e.printStackTrace();
            }
            System.out.println("The ID length is incorrect, please enter it again : ");
            lengthCheck = scannerLengthChecker.nextLine();
        }
        return lengthCheck;
    }

    private static Double sumCheckerMethod (Double sum, Scanner scannerSumChecker) {

        Helper helperSumChecker = new Helper();

        while (sum >= 1000.00) {
            try {
                helperSumChecker.checkSum(sum);
            } catch (WrongSumException e) {
                e.printStackTrace();
            }
            System.out.println("The sum is incorrect, please enter it again : ");
            sum = scannerSumChecker.nextDouble();
        }
        return sum;
    }
}
