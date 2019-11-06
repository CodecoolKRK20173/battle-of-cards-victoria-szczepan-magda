package main.java;
import java.util.*;

public class Card implements Comparator {
    private String name;
    private Map<String, Float> parameters;
    private List<String> parametersNames;
    public Card(String name, Map<String, Float> parameters) {
        this.name = name;
        this.parameters = parameters;
        parametersNames = Arrays.asList("maxSpeed", "price", "acceleration");
    }


    public String getName() {
        return name;
    }

    public float getMaxSpeed() {
        return parameters.get("maxSpeed");
    }
    public float getPrice() {
        return parameters.get("price");
    }
    public float getAcceleration() {
        return parameters.get("acceleration");
    }
    public String toString(){
        String content = "";
        content = content.concat("\n" + "-".repeat(20) + "\n"+name+":" +
                "\nMax Speed: " + getMaxSpeed()+" km/h"+
                "\nPrice: " + getPrice())+" zl"+
                "\nAcceleration: " + getAcceleration()+" s\n" + "-".repeat(20) + "\n"
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

    public Boolean compareCards(Card card, String parameter){
        if(this.parameters.get(parameter).equals( card.parameters.get(parameter)))
            return null;
        if (!parameter.equals("acceleration"))
            return this.parameters.get(parameter) > card.parameters.get(parameter);
        else
            return this.parameters.get(parameter) < card.parameters.get(parameter);
    }
}
