package by.it.lapkovskiy.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void TaskA() throws CalcException {
        writeInParse("A=2+5.3",new Scalar(7.3));

        writeInParse("B=A*3.5",new Scalar(25.55));

        writeInParse("B1=B+0.11*-5",new Scalar(25.0));

        writeInParse("B2=A/2-1",new Scalar(2.65));
    }



    @Test
    public void TaskB() throws CalcException {
        writeInParse("C=B+(A*2)",new Scalar(40.15));

        writeInParse("D=((C-0.15)-20)/(7-5)",new Scalar(10.0));

        writeInParse("E={2,3}*(D/2)",new Vector("{10,15}"));
    }
    @Test
    public void TaskC1() throws CalcException {
        writeInParse("F={{1,2.0},{3,4}}+5",new Matrix("{{6.0,7.0},{8.0,9.0}}"));
        writeInParse("F={{1,2.0},{3,4}}+F",new Matrix("{{7.0,9.0},{11.0,13.0}}"));

        writeInParse("F={{1,2.0},{3,4}}-5",new Matrix("{{-4.0,-3.0},{-2.0,-1.0}}"));
        writeInParse("F={{1,2.0},{3,4}}-F",new Matrix("{{5.0,5.0},{5.0,5.0}}"));

        writeInParse("F={{1,2.0},{3,4}}*5",new Matrix("{{5.0,10.0},{15.0,20.0}}"));
        writeInParse("F={{1,2.0},{3,4}}*F",new Matrix("{{35.0,50.0},{75.0,110.0}}"));
        writeInParse("F={{1,2.0},{3,4}}*{1,2}",new Vector("{5.0,11.0}"));

    }

    public void writeInParse(String line,Var expected) throws CalcException {
        Var var = parser.calc(line);
        System.out.println(line);
        System.out.println(var);

        assertEquals("Error calc", expected.toString(), var.toString());
    }
    @After
    public void tearDown() throws Exception {
    }
}