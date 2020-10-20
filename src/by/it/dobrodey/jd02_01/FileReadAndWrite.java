package by.it.dobrodey.jd02_01;

import java.io.File;

public class FileReadAndWrite {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String BUYER_CHOOSE = "buyerChoose";
    static final String FILENAME = getPath(Basket.class) + BUYER_CHOOSE;
    @SuppressWarnings("SameParameterValue")

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC +
                File.separator + packageName;
    }

}
