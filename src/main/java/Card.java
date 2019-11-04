package main.java;
import java.util.Map;

public class Card {
    private String name;
    private Map<String, Integer> parameters;
    public Card(String name, Map<String, Integer> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return parameters.get("maxSpeed");
    }
    public int getPrice() {
        return parameters.get("price");
    }
    public int getAcceleration() {
        return parameters.get("acceleration");
    }
    public String toString(){
        String content = "";
        content = content.concat("\n"+name+":" +
                "\nMax Speed: " + getMaxSpeed()+" km/h"+
                "\nAcceleration: " + getAcceleration()+" s"+
                "\nPrice: " + getPrice())+" zl\n";
        return content;
    }
}
