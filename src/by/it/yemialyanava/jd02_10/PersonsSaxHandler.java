package by.it.yemialyanava.jd02_10;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonsSaxHandler extends DefaultHandler {
    private List<Person> persons = null;
    private Person currentPerson;
    private Passport currentPassport;
    private boolean insideName = false;
    private boolean insideLastName = false;
    private boolean insidePassportNumber = false;
    private boolean insidePassportIssue = false;

    public List<Person> getPersons(){
        return persons;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Persons")){
            persons = new ArrayList<>();
        } else if(qName.equals("Person")){
            currentPerson = new Person();
        } else if (qName.equals("Name")){
            insideName = true;
        } else if (qName.equals("LastName")){
            insideLastName = true;
        } else if(qName.equals("Passport")){
            currentPassport = new Passport();
        }else if (qName.equals("Number")){
            insidePassportNumber = true;
        }else if (qName.equals("Issue")){
            insidePassportIssue = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Person")){
            persons.add(currentPerson);
            currentPerson = null;
        }if (qName.equals("Passport")){
            currentPerson.setPassport(currentPassport);
            currentPassport = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        char[] subArray = Arrays.copyOfRange(ch, start, start+length);
        if(insideName==true){
            String name = String.valueOf(subArray);
            currentPerson.setName(name);
            insideName = false;
        } else if (insideLastName == true){
            String lastName = String.valueOf(subArray);
            currentPerson.setLastName(lastName);
            insideLastName = false;
        }else if(insidePassportNumber == true){
            Integer passportNumber = Integer.parseInt(String.valueOf(subArray));
            currentPassport.setNumberOfPassport(passportNumber);
            insidePassportNumber = false;
        }else if (insidePassportIssue==true){
            String issieDate = String.copyValueOf(subArray);
            currentPassport.setDateIssue(issieDate);
            insidePassportIssue = false;
        }
    }
}
