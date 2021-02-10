import CDecl.CDeclParser;
import Calc.CalcParser;
import grammar.*;
//import visualizer.CDeclVisualizer;
import visualizer.CalcVisualizer;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    private static final boolean NEED_GENERATE = true;
    private static final boolean GENERATE_CALC = true;

    public static void main(String[] args) {

        if (NEED_GENERATE) {
            try {
                String pathCalc = "src/calc.gram";
                String pathCDecl = "src/cdecl.gram";
                Grammar curGrammar = new GrammarGenerator(GENERATE_CALC ? pathCalc : pathCDecl).generate();
                new RuleGenerator(curGrammar).generate();
                new LexicalAnalyzerGenerator(curGrammar).generate();
                new ParserGenerator(curGrammar).generate();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            CalcParser.Node node = new CalcParser().parse("2^3^2");
            System.out.println(node.val);
            CalcVisualizer.show(node);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        try {
//            CDeclParser.Node node = new CDeclParser().parse("int **a,b; double ccc;");
//            System.out.println(node.val);
//            CDeclVisualizer.show(node);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


    }
}
