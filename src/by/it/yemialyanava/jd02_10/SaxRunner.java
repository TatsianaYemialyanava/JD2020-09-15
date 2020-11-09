package by.it.yemialyanava.jd02_10;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaxRunner {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        File f = new File("D:\\persons.txt");
        PersonsSaxHandler personsHandler = new PersonsSaxHandler();
        try {
            saxParser.parse(f, personsHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Person> persons = personsHandler.getPersons();
        printPersons(persons);
    }
    private static void printPersons(List<Person> persons) {
        for (Person element : persons) {
            System.out.println(element.getName() + "\n " + element.getLastName() + "\n" + element.getPassport().getNumberOfPassport() +
                    "\n" + element.getPassport().getDateIssue());
        }
    }
}
