package homework14.helper;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public Optional<String> modifyString(String emailAddress) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        if (emailAddress != null) {
            Matcher matcher = pattern.matcher(emailAddress);
            while (!matcher.matches() || emailAddress.isEmpty()) {
                return Optional.empty();
            }
        }

        return Optional.ofNullable(emailAddress);
    }
}
