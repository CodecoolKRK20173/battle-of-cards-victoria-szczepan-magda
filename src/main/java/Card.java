package main.java;
import java.util.*;

public class Card implements Comparator {
    private String name;
    private Map<String, Integer> parameters;
    private List<String> parametersNames;
    public Card(String name, Map<String, Integer> parameters) {
        this.name = name;
        this.parameters = parameters;
        parametersNames = Arrays.asList("maxSpeed", "price", "acceleration");
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
                "\nPrice: " + getPrice())+" zl"+
                "\nAcceleration: " + getAcceleration()+" s\n"
                ;
        return content;
    }

    public List<String> getParametersKeys(){
        return parametersNames;
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
