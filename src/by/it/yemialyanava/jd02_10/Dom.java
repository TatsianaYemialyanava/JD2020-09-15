package by.it.yemialyanava.jd02_10;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dom {

    public static void main(String[] args) {
        Document document = getDomModel();
        List<Person> persons = convertModel(document);
        printPersons(persons);
    }

    private static Document getDomModel() {
        File f = new File("D:\\persons.txt");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try {
            doc = builder.parse(f);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    private static List<Person> convertModel(Document document) {
        NodeList nList = document.getElementsByTagName("Person");
        List<Person> result = new ArrayList<>();
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element element = (Element) nNode;
            Person person = new Person();
            person.setName(element.getElementsByTagName("Name").item(0).getTextContent());
            person.setLastName(element.getElementsByTagName("LastName").item(0).getTextContent());

            Passport passport = new Passport();
            Node passportNode = element.getElementsByTagName("Passport").item(0);
            Element elementPassport = (Element) passportNode;
            NodeList xyedlist = elementPassport.getElementsByTagName("Issue");
            Node xyeda = xyedlist.item(0);
            String dateIssue = xyeda.getTextContent();
            passport.setDateIssue(dateIssue);

            String strPassportNumber = elementPassport.getElementsByTagName("Number").item(0).getTextContent();
            passport.setNumberOfPassport(Integer.parseInt(strPassportNumber));
            person.setPassport(passport);
            result.add(person);
        }
        return result;
    }

    private static void printPersons(List<Person> persons) {
        for (Person element : persons) {
            System.out.println(element.getName() + "\n " + element.getLastName() + "\n" + element.getPassport().getNumberOfPassport() +
                    "\n" + element.getPassport().getDateIssue());
        }
    }
}
