package homework2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Information {
    private List<String> pseudonym;
    private Set<String> emailAddress;
    private Map<String, String> emailAddressPseudonym;

    public List<String> getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(List<String> pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Set<String> getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(Set<String> emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Map<String, String> getEmailAddressPseudonym() {
        return emailAddressPseudonym;
    }

    public void setEmailAddressPseudonym(Map<String, String> emailAddressPseudonym) {
        this.emailAddressPseudonym = emailAddressPseudonym;
    }

    @Override
    public String toString() {
        return "Information{" +
                "pseudonym=" + pseudonym +
                ", emailAddress=" + emailAddress +
                ", pseudonymEmailAddress=" + emailAddressPseudonym +
                '}';
    }
}

