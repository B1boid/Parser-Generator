// Generated from /Users/aleksandrvorobev/Desktop/3 kurs/MT/Parser-Generator/src/gram.g4 by ANTLR 4.8
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gramVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gramParser#inputGrammar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputGrammar(gramParser.InputGrammarContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#gramName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGramName(gramParser.GramNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars(gramParser.VarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(gramParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#allRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllRules(gramParser.AllRulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#curRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurRule(gramParser.CurRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#parseRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseRule(gramParser.ParseRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#argInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgInit(gramParser.ArgInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#curRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurRules(gramParser.CurRulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(gramParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#tokenRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenRule(gramParser.TokenRuleContext ctx);
}