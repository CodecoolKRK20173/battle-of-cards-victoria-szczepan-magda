package main.java;

import java.util.List;

public interface CardsParser {
    public List<Card> loadFromFile(String path);
}
