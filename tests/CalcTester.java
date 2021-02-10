import Calc.CalcParser;
import org.junit.*;

import java.text.ParseException;


public class CalcTester {

    private static class MyTest {

        String input;
        int answer;

        public MyTest(String input, int answer) {
            this.input = input;
            this.answer = answer;
        }

    }

    @Test
    public void simpleTests() {
        MyTest[] tests = {
                new MyTest("5", 5),
                new MyTest("-5", -5),
                new MyTest("2+3", 5),
                new MyTest("7-4", 3),
                new MyTest("4-7", -3),
                new MyTest("2*3", 6),
                new MyTest("6/3", 2),
                new MyTest("2^3", 8),
        };

        launchTests(tests);
    }

    @Test
    public void complexTests() {
        MyTest[] tests = {
                new MyTest("2+2*2", 6),
                new MyTest("2+2*3*2+2", 16),
                new MyTest("4*3*2+6/2", 27),
                new MyTest("2+(1+33)/34*3", 5),
                new MyTest("2^(3^2)", 512),
                new MyTest("10/(2^3-5)+((-2-2)*-3)", 15),
        };

        launchTests(tests);
    }

    @Test
    public void unMinusTests() {
        MyTest[] tests = {
                new MyTest("-2", -2),
                new MyTest("--2", 2),
                new MyTest("---2", -2),
                new MyTest("----2", 2),
                new MyTest("----2+2", 4),
                new MyTest("1-2-3", -4)
        };

        launchTests(tests);
    }

    @Test
    public void powTests() {
        MyTest[] tests = {
                new MyTest("2^3^2", 512),
                new MyTest("2+3^2*3", 29),
                new MyTest("2^1^3^5", 2),
                new MyTest("2*(4+3^2^2)-5", 165),
                new MyTest("2^3*3^2", 72),
                new MyTest("2^3^3", 134217728)
        };

        launchTests(tests);
    }



    @Test
    public void errorTests() {
        MyTest[] tests = {
                new MyTest("2++2*2", 0),
                new MyTest("*3", 0),
                new MyTest("5+", 0),
                new MyTest("2(1+33)/34*3", 0),
                new MyTest("3^", 0),
                new MyTest("(1+2", 0),
        };

        launchErrorTests(tests);
    }

    private void launchTests(MyTest[] tests){
        for (MyTest test : tests) {
            try {
                int res = new CalcParser().parse(test.input).val;
                if (res != test.answer){
                    Assert.fail("Test: "+test.input+"\nExpected: "+test.answer+" but given: "+ res);
                }
            } catch (ParseException e) {
                Assert.fail("Unexpected exception:" + e.getLocalizedMessage());
            }
        }
    }

    private void launchErrorTests(MyTest[] tests){
        for (MyTest test : tests) {
            try {
                int res = new CalcParser().parse(test.input).val;
                Assert.fail("Test: "+test.input+"\nExpecting exception");
            } catch (ParseException e) {

            }
        }
    }

}
