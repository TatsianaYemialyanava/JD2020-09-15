package by.it.yemialyanava.jd02_10;

import com.sun.jmx.remote.internal.Unmarshal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class IamLazy {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class, Persons.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File f = new File("D:\\persons2.txt");
        Persons persons = (Persons) unmarshaller.unmarshal(f);
        printPersons(persons.getPersons());
    }

    private static void printPersons(List<Person> persons) {
        for (Person element : persons) {
            System.out.println(element.getName() + "\n " + element.getLastName() + "\n" + element.getBirthday()
                    + "\n" + element.getRace() + "\n");
        }
    }
}
