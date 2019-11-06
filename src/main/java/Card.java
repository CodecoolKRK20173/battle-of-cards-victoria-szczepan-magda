package main.java;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Card implements Comparator {
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

    public List<String> getParametersKeys(){
        return new ArrayList<>(parameters.keySet());
    }

    public boolean equalsCards(Card obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        return obj.name.equals(this.name) && obj.parameters.equals(this.parameters);
    }

    public boolean compareCards(Card card, String parameter){
        return this.parameters.get(parameter) > card.parameters.get(parameter);
    }
}
