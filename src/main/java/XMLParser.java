package main.java;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.*;


public class XMLParser implements CardsParser{

    public List<Card> loadFromFile(String path) {
        List<Card> cards = new ArrayList<Card>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(path);
            doc.getDocumentElement().normalize();
            NodeList nCarsList = doc.getElementsByTagName("Car");
            for (int i = 0; i < nCarsList.getLength(); i++) {
                Map<String, Float> parameters = new LinkedHashMap<>();
                Node nCar = nCarsList.item(i);
                if(nCar.getNodeType() == Node.ELEMENT_NODE){
                    Element carElement = (Element) nCar;
                    String carId = carElement.getAttribute("id");
                    NodeList nParametersList = carElement.getElementsByTagName("Parameter");
                    for (int j = 0; j < nParametersList.getLength(); j++) {
                        Node nParameter = nParametersList.item(j);
                        if(nParameter.getNodeType() == Node.ELEMENT_NODE){
                            Element parameterElement = (Element) nParameter;
                            String parameterId = parameterElement.getAttribute("id");
                            String value = parameterElement.getTextContent();
                            parameters.put(parameterId, Float.parseFloat(value));
                        }
                    }
                    Card card = new Card(carId, parameters);
                    cards.add(card);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return cards;
    }
}
