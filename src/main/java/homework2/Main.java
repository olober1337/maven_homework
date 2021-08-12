package homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Information addMoreData(List<? extends Number> list, Information information) {

        List<String> newPseudonym = information.getPseudonym();
        Set<String> newEmailAddress = information.getEmailAddress();
        Map<String, String> newEmailAddressPseudonym = information.getEmailAddressPseudonym();

        for (int i = 0; i < list.size(); i++) {
            String pseudonym = list.get(i).toString();

            newPseudonym.add(pseudonym);
            newEmailAddress.add(pseudonym + "@mail.ua");
            newEmailAddressPseudonym.put(pseudonym + "@mail.ua", pseudonym);

        }
        return information;
    }

    public static void main(String[] args) {

        InitializationData initializationData = new InitializationData();
        Information information = initializationData.addInformation();

        List<Number> newList = new ArrayList<>();

        newList.add(100);
        newList.add(200);
        newList.add(300);

        Information newInformation = addMoreData(newList, information);

        System.out.println("Pseudonym ArrayList size is : " + newInformation.getPseudonym().size());
        System.out.println("EmailAddress HashSet size is : " + newInformation.getEmailAddress().size());
        System.out.println("EmailAddressPseudonym HashMap size is : " + newInformation.getEmailAddressPseudonym().size());
    }
}