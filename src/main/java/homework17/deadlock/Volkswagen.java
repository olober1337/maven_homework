package homework17.deadlock;

public class Volkswagen {

    private Tesla tesla;

    public Tesla getTesla() {
        return tesla;
    }

    public void setTesla(Tesla tesla) {
        this.tesla = tesla;
    }

    public synchronized String getStringFromTesla() {
        return "Eat my electro power you son of Audi!";
    }

}
