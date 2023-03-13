package edu.uhcl.blindsight;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompendiumParser {


    public static List<String> getRaceList() throws Exception {

        final String RACES = "src/main/assets/CompendiumRaces.xml";
        SAXBuilder parser = new SAXBuilder();
        Document Races = parser.build(new File(RACES));

        List<String> raceList = new ArrayList<>();
        Element rootNode = Races.getRootElement();
        List<Element> rList = rootNode.getChildren("race");

        for (Element raceTag : rList) {
            raceList.add(raceTag.getChildText("name"));
        }
        return raceList;
    }
}
