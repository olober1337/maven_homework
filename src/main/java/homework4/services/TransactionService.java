package homework4.services;

import homework4.utils.Helper;

public class TransactionService {

    public void moneyTransaction(String senderAccountId, String clientAccountId) {

        Helper helper = new Helper();
        helper.checkAccountId(senderAccountId, clientAccountId);
    }
}
