package by.it.frolova.testCalc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Before
    public void setUp() throws Exception {
        Parser parser;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void calcA1() throws CalcExceptions {
        Var var = new Parser().calc("A=2+5.3");
        double actual = Double.parseDouble(var.toString());
        double expected = 7.3;
        assertEquals("Test failed for expression: A=2+5.3", expected, actual, 1e-8);
        System.out.println("Success for expression: A=2+5.3");
    }

    @Test
    public void calcA2() throws CalcExceptions {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        Var var = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(var.toString());
        double expected = 25.55;
        assertEquals("Test failed for expression: B=A*3.5", expected, actual, 1e-8);
        System.out.println("Success for expression: B=A*3.5");
    }

    @Test
    public void calcA3() throws CalcExceptions {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var var = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(var.toString());
        double expected = 25;
        assertEquals("Test failed for expression: B1=B+0.11*-5", expected, actual, 1e-8);
        System.out.println("Success for expression: B1=B+0.11*-5");
    }

    @Test
    public void calcA4() throws CalcExceptions {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("B1=B+0.11*-5");
        Var var = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(var.toString());
        double expected = 2.65;
        assertEquals("Test failed for expression: B2=A/2-1", expected, actual, 1e-8);
        System.out.println("Success for expression: B2=A/2-1" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void calcB1() throws CalcExceptions {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("B1=B+0.11*-5");
        parser.calc("B2=A/2-1");
        Var var = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(var.toString());
        double expected = 40.15;
        assertEquals("Test failed for expression: C=B+(A*2)", expected, actual, 1e-8);
        System.out.println("Success for expression: C=B+(A*2)" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }
}