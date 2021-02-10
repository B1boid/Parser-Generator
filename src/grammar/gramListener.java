// Generated from /Users/aleksandrvorobev/Desktop/3 kurs/MT/Parser-Generator/src/gram.g4 by ANTLR 4.8
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramParser}.
 */
public interface gramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramParser#inputGrammar}.
	 * @param ctx the parse tree
	 */
	void enterInputGrammar(gramParser.InputGrammarContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#inputGrammar}.
	 * @param ctx the parse tree
	 */
	void exitInputGrammar(gramParser.InputGrammarContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#gramName}.
	 * @param ctx the parse tree
	 */
	void enterGramName(gramParser.GramNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#gramName}.
	 * @param ctx the parse tree
	 */
	void exitGramName(gramParser.GramNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(gramParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(gramParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(gramParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(gramParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#allRules}.
	 * @param ctx the parse tree
	 */
	void enterAllRules(gramParser.AllRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#allRules}.
	 * @param ctx the parse tree
	 */
	void exitAllRules(gramParser.AllRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#curRule}.
	 * @param ctx the parse tree
	 */
	void enterCurRule(gramParser.CurRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#curRule}.
	 * @param ctx the parse tree
	 */
	void exitCurRule(gramParser.CurRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#parseRule}.
	 * @param ctx the parse tree
	 */
	void enterParseRule(gramParser.ParseRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#parseRule}.
	 * @param ctx the parse tree
	 */
	void exitParseRule(gramParser.ParseRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#argInit}.
	 * @param ctx the parse tree
	 */
	void enterArgInit(gramParser.ArgInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#argInit}.
	 * @param ctx the parse tree
	 */
	void exitArgInit(gramParser.ArgInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#curRules}.
	 * @param ctx the parse tree
	 */
	void enterCurRules(gramParser.CurRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#curRules}.
	 * @param ctx the parse tree
	 */
	void exitCurRules(gramParser.CurRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(gramParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(gramParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#tokenRule}.
	 * @param ctx the parse tree
	 */
	void enterTokenRule(gramParser.TokenRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#tokenRule}.
	 * @param ctx the parse tree
	 */
	void exitTokenRule(gramParser.TokenRuleContext ctx);
}