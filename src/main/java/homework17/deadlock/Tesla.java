package homework17.deadlock;

public class Tesla {

    private Volkswagen volkswagen;

    public Volkswagen getVolkswagen() {
        return volkswagen;
    }

    public void setVolkswagen(Volkswagen volkswagen) {
        this.volkswagen = volkswagen;
    }

    public synchronized String getStringFromVolkswagen() {
        return "Hello from VAG group electro crap!";
    }
}
