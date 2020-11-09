package by.it.yemialyanava.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class GsonExample {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        FileReader fl = new FileReader("D://persons3.txt");
        Persons persons = gson.fromJson(fl, Persons.class);
        printPersons(persons.getPersons());
    }

    private static void printPersons(List<Person> persons) {
        for (Person element : persons) {
            System.out.println(element.getName() + "\n " + element.getLastName() + "\n");
        }
    }
}
