package by.it.yemialyanava.jd02_10;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonsReflectionSaxHandler<T> extends DefaultHandler {
    private List<T> result = null;
    private Class<?> targetClass;
    private Object currentItem;
    private Method currentSetterMethod;

    public PersonsReflectionSaxHandler(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public List<T> getResult() {
        return result;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String shortClassName = targetClass.getSimpleName();
        try {
            if (qName.equals(shortClassName)) {
                currentItem = targetClass.newInstance();
            } else if (qName.equals(shortClassName+ "s")){
                result = new ArrayList<>();
            } else {
                String methodName = "set" + qName;
                currentSetterMethod = targetClass.getMethod(methodName, String.class);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String shortClassName = targetClass.getSimpleName();
        if (qName.equals(shortClassName)) {
            result.add((T) currentItem);
            currentItem = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        try {
            char[] subArray = Arrays.copyOfRange(ch, start, start + length);
            String setterArgument = String.valueOf(subArray);
            if (currentSetterMethod != null) {
                currentSetterMethod.invoke(currentItem, setterArgument);
                currentSetterMethod = null;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
