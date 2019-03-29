package de.microservice.rechner.data;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import static java.lang.String.format;

public class RechnerDataStoreImpl implements RechnerDataStore {
    private HashMap<Repo, Document> repositories;

    public RechnerDataStoreImpl() {
        initialisiereRepository();
    }

    @Override
    public String ermittleKonfig(Repo repo, String xPathQuery) {
        NodeList nodeList = ermittleNodeListe(xPathQuery, repositories.get(repo));
        return formatiereErgebnisMitBlankAlsTrenner(nodeList);
    }

    private void initialisiereRepository() {
        repositories = new HashMap<>();
        repositories.put(Repo.IPD, ladeXmlDaten("/de/microservice/rechner/jerseyresources/RechnerResourceData.xml"));
    }

    private String formatiereErgebnisMitBlankAlsTrenner(NodeList nodeList) {
        StringBuilder ergebnisElemente = new StringBuilder();
        for (int i = 0; i < nodeList.getLength(); i++) {
            ergebnisElemente.append(format("%s ", nodeList.item(i).getNodeValue()));
        }
        return ergebnisElemente.toString().trim();
    }

    private NodeList ermittleNodeListe(String xPathQuery, Document ipdXmlDocument1) {
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            return (NodeList) xPath.compile(xPathQuery).evaluate(ipdXmlDocument1, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Document ladeXmlDaten(String xmlResourceName) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            InputStream xml = this.getClass().getResourceAsStream(xmlResourceName);
            return builder.parse(xml);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
