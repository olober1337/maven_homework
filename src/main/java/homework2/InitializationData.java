package homework2;

import java.util.*;

public class InitializationData {

    public Information addInformation() {

        Information information = new Information();

        List<String> pseudonymList = new ArrayList<>();
        Set<String> emailAddressSet = new HashSet<>();
        Map<String, String> emailAddressPseudonymMap = new HashMap<>();

        String addPseudonym = "test";
        String addEmailAddress = "test@test.com";

        for (int i = 0; i < 30; i++) {
            pseudonymList.add(addPseudonym);
            emailAddressSet.add(addEmailAddress);
            emailAddressPseudonymMap.put(addEmailAddress, addPseudonym);
        }

        information.setPseudonym(pseudonymList);
        information.setEmailAddress(emailAddressSet);
        information.setEmailAddressPseudonym(emailAddressPseudonymMap);

        if (!checkSize(information)) {
            sizeCorrection(information.getPseudonym());
        }
        return information;

    }

    private boolean checkSize(Information information) {
        if (information.getPseudonym().size() == information.getEmailAddress().size()
                && information.getEmailAddress().size() == information.getEmailAddressPseudonym().size()) {
            return true;
        }
        return false;
    }

    private List<String> sizeCorrection(List<String> newList) {

        Set<String> pseudonymSet = new HashSet<>(newList);

        newList.clear();
        newList.addAll(pseudonymSet);
        return newList;

    }
}
