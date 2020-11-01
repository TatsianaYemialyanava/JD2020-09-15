package by.it.yemialyanava.calcul;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

abstract class Var implements Operation {

    private  static Map<String, Var> varMap = new HashMap<>();

    public static HashMap<String, Var> getVarMap() {
        return (HashMap<String, Var>) varMap;
    }

    /*public HashMap<String, Var> getVarMap()
    public double getValue() {
        return value;
    }*/

    public static Var save (String name,Var value) throws CalcException {
        varMap.put(name, value);
        saveMap();
        return value;
    }

    private static void saveMap() throws CalcException{
        try(PrintWriter writer = new PrintWriter(FILENAME)){
            for (Map.Entry<String, Var> entry : varMap.entrySet()) {
                writer.printf("%s=%s\n", entry.getKey(), entry.getValue());
            }
        }catch (IOException e){
            throw new CalcException(ConsoleRunner.manager.get(MessagesNames.FILE_ERROR) + e);
        }
    }
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String VARS_TXT = "vars.txt";
    private static final String FILENAME = getPath(Var.class) + VARS_TXT;

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }

    static void load() throws CalcException{
        try{
            List<String> lines = Files.lines(Paths.get(FILENAME)).collect(Collectors.toList());
            Parser parser = new Parser();
            for (String line : lines) {
                parser.calc(line);
            }
        } catch (IOException e) {
            throw new CalcException(e);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ADD_IMPOSSIBLE) + this+ " " +  other);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException(ConsoleRunner.manager.get(MessagesNames.SUB_IMPOSSIBLE) + this + " " + other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException(ConsoleRunner.manager.get(MessagesNames.MUL_IMPOSSIBLE) + this + " " + other);
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException(ConsoleRunner.manager.get(MessagesNames.DIV_IMPOSSIBLE) + this + " " + other);
    }

    @Override
    public String toString() {
        return ConsoleRunner.manager.get(MessagesNames.ABSTRACT_VAR);
    }
}
