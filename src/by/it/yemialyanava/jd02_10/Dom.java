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

public class Dom {
    /*private static final String FILE_DATA = "dataTaskA.bin";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    //private static final String RESULT_TASK_A = "resultTaskA.txt";

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }*/

    public static void main(String[] args) {
        //String fileNAME = "D/persons.txt";
        File f = new File("D:\\persons.txt");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try{
            doc = builder.parse(f);
            //System.out.println(doc);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();

        System.out.println("root: " + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Person");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            System.out.println("\n current element: " + nNode.getNodeName());
            if (nNode.getNodeType()==Node.ELEMENT_NODE){
                Element element = (Element) nNode;
                System.out.println("Name: " + element.getElementsByTagName("Name").item(0).getTextContent());
                System.out.println("LastName: " + element.getElementsByTagName("LastName").item(0).getTextContent());
                System.out.println("Passport: " + element.getElementsByTagName("Passport").item(0).getTextContent());
            }
        }
    }
}
