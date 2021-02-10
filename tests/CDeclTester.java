import CDecl.CDeclParser;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class CDeclTester {

    private static class MyTest {

        String input;
        String answer;

        public MyTest(String input, String answer) {
            this.input = input;
            this.answer = answer;
        }

    }

    @Test
    public void simpleTests() {
        MyTest[] tests = {
                new MyTest("int a;", "int a;\n"),
                new MyTest("bool b;", "bool b;\n"),
                new MyTest("int a,b;", "int a,b;\n"),
                new MyTest("int a,b,c;", "int a,b,c;\n"),
                new MyTest("int a; int b;", "int a;\nint b;\n"),
        };

        launchTests(tests);
    }

    @Test
    public void pointerTests() {
        MyTest[] tests = {
                new MyTest("int *a;", "int *a;\n"),
                new MyTest("bool **b;", "bool **b;\n"),
                new MyTest("int a,*b;", "int a,*b;\n"),
                new MyTest("int **a,***b,c;", "int **a,***b,c;\n"),
                new MyTest("int ****a; int b;", "int ****a;\nint b;\n"),
        };

        launchTests(tests);
    }

    @Test
    public void whitespacesTests() {
        MyTest[] tests = {
                new MyTest("int     a;", "int a;\n"),
                new MyTest("int     a;\n   float  b;", "int a;\nfloat b;\n"),
                new MyTest("double  * * *   a;", "double ***a;\n"),
        };

        launchTests(tests);
    }

    @Test
    public void errorTests() {
        MyTest[] tests = {
                new MyTest("inta;", ""),
                new MyTest("int a", ""),
                new MyTest("int a b", ""),
                new MyTest("bol a;", ""),
                new MyTest("*int a;", ""),
        };

        launchErrorTests(tests);
    }


    private void launchTests(MyTest[] tests){
        for (MyTest test : tests) {
            try {
                String res = new CDeclParser().parse(test.input).val;
                if (!res.equals(test.answer)){
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
                String res = new CDeclParser().parse(test.input).val;
                Assert.fail("Test: "+test.input+"\nExpecting exception");
            } catch (ParseException e) {

            }
        }
    }
}
