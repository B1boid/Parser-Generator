// Generated from /Users/aleksandrvorobev/Desktop/3 kurs/MT/Parser-Generator/src/gram.g4 by ANTLR 4.8
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GRAMMAR=1, R_OPEN=2, S_OPEN=3, C_OPEN=4, A_OPEN=5, R_CLOSE=6, S_CLOSE=7, 
		C_CLOSE=8, A_CLOSE=9, COLON=10, SEMICOLON=11, OR=12, ARG=13, CODE=14, 
		TOKEN=15, WORD=16, REG_EXPR=17, WHITESPACES=18;
	public static final int
		RULE_inputGrammar = 0, RULE_gramName = 1, RULE_vars = 2, RULE_var = 3, 
		RULE_allRules = 4, RULE_curRule = 5, RULE_parseRule = 6, RULE_argInit = 7, 
		RULE_curRules = 8, RULE_name = 9, RULE_tokenRule = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"inputGrammar", "gramName", "vars", "var", "allRules", "curRule", "parseRule", 
			"argInit", "curRules", "name", "tokenRule"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "'('", "'['", "'{'", "'<-'", "')'", "']'", "'}'", 
			"'->'", "':'", "';'", "'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GRAMMAR", "R_OPEN", "S_OPEN", "C_OPEN", "A_OPEN", "R_CLOSE", "S_CLOSE", 
			"C_CLOSE", "A_CLOSE", "COLON", "SEMICOLON", "OR", "ARG", "CODE", "TOKEN", 
			"WORD", "REG_EXPR", "WHITESPACES"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "gram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InputGrammarContext extends ParserRuleContext {
		public GramNameContext gramName() {
			return getRuleContext(GramNameContext.class,0);
		}
		public AllRulesContext allRules() {
			return getRuleContext(AllRulesContext.class,0);
		}
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public InputGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputGrammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterInputGrammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitInputGrammar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitInputGrammar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputGrammarContext inputGrammar() throws RecognitionException {
		InputGrammarContext _localctx = new InputGrammarContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_inputGrammar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			gramName();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==A_OPEN) {
				{
				setState(23);
				vars();
				}
			}

			setState(26);
			allRules();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GramNameContext extends ParserRuleContext {
		public TerminalNode GRAMMAR() { return getToken(gramParser.GRAMMAR, 0); }
		public TerminalNode WORD() { return getToken(gramParser.WORD, 0); }
		public TerminalNode SEMICOLON() { return getToken(gramParser.SEMICOLON, 0); }
		public GramNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gramName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterGramName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitGramName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitGramName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GramNameContext gramName() throws RecognitionException {
		GramNameContext _localctx = new GramNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_gramName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(GRAMMAR);
			setState(29);
			match(WORD);
			setState(30);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarsContext extends ParserRuleContext {
		public TerminalNode A_OPEN() { return getToken(gramParser.A_OPEN, 0); }
		public TerminalNode A_CLOSE() { return getToken(gramParser.A_CLOSE, 0); }
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(A_OPEN);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				var();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			setState(38);
			match(A_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(gramParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(gramParser.WORD, i);
		}
		public TerminalNode SEMICOLON() { return getToken(gramParser.SEMICOLON, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(WORD);
			setState(41);
			match(WORD);
			setState(42);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllRulesContext extends ParserRuleContext {
		public List<CurRuleContext> curRule() {
			return getRuleContexts(CurRuleContext.class);
		}
		public CurRuleContext curRule(int i) {
			return getRuleContext(CurRuleContext.class,i);
		}
		public AllRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterAllRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitAllRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitAllRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllRulesContext allRules() throws RecognitionException {
		AllRulesContext _localctx = new AllRulesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_allRules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				curRule();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TOKEN || _la==WORD );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CurRuleContext extends ParserRuleContext {
		public ParseRuleContext parseRule() {
			return getRuleContext(ParseRuleContext.class,0);
		}
		public TokenRuleContext tokenRule() {
			return getRuleContext(TokenRuleContext.class,0);
		}
		public CurRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_curRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterCurRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitCurRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitCurRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CurRuleContext curRule() throws RecognitionException {
		CurRuleContext _localctx = new CurRuleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_curRule);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				parseRule();
				}
				break;
			case TOKEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				tokenRule();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParseRuleContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(gramParser.WORD, 0); }
		public TerminalNode COLON() { return getToken(gramParser.COLON, 0); }
		public CurRulesContext curRules() {
			return getRuleContext(CurRulesContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(gramParser.SEMICOLON, 0); }
		public ArgInitContext argInit() {
			return getRuleContext(ArgInitContext.class,0);
		}
		public ParseRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterParseRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitParseRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitParseRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseRuleContext parseRule() throws RecognitionException {
		ParseRuleContext _localctx = new ParseRuleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parseRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(WORD);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==S_OPEN) {
				{
				setState(54);
				argInit();
				}
			}

			setState(57);
			match(COLON);
			setState(58);
			curRules(0);
			setState(59);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgInitContext extends ParserRuleContext {
		public TerminalNode S_OPEN() { return getToken(gramParser.S_OPEN, 0); }
		public List<TerminalNode> WORD() { return getTokens(gramParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(gramParser.WORD, i);
		}
		public TerminalNode S_CLOSE() { return getToken(gramParser.S_CLOSE, 0); }
		public ArgInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterArgInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitArgInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitArgInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgInitContext argInit() throws RecognitionException {
		ArgInitContext _localctx = new ArgInitContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(S_OPEN);
			setState(62);
			match(WORD);
			setState(63);
			match(WORD);
			setState(64);
			match(S_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CurRulesContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode CODE() { return getToken(gramParser.CODE, 0); }
		public List<CurRulesContext> curRules() {
			return getRuleContexts(CurRulesContext.class);
		}
		public CurRulesContext curRules(int i) {
			return getRuleContext(CurRulesContext.class,i);
		}
		public TerminalNode OR() { return getToken(gramParser.OR, 0); }
		public CurRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_curRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterCurRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitCurRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitCurRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CurRulesContext curRules() throws RecognitionException {
		return curRules(0);
	}

	private CurRulesContext curRules(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CurRulesContext _localctx = new CurRulesContext(_ctx, _parentState);
		CurRulesContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_curRules, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(68); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(67);
					name();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(70); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(72);
				match(CODE);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CurRulesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_curRules);
					setState(75);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(76);
					match(OR);
					setState(77);
					curRules(3);
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode TOKEN() { return getToken(gramParser.TOKEN, 0); }
		public TerminalNode WORD() { return getToken(gramParser.WORD, 0); }
		public TerminalNode ARG() { return getToken(gramParser.ARG, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_name);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(TOKEN);
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(WORD);
				setState(86);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(85);
					match(ARG);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenRuleContext extends ParserRuleContext {
		public TerminalNode TOKEN() { return getToken(gramParser.TOKEN, 0); }
		public TerminalNode COLON() { return getToken(gramParser.COLON, 0); }
		public TerminalNode REG_EXPR() { return getToken(gramParser.REG_EXPR, 0); }
		public TerminalNode SEMICOLON() { return getToken(gramParser.SEMICOLON, 0); }
		public TerminalNode CODE() { return getToken(gramParser.CODE, 0); }
		public TokenRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterTokenRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitTokenRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramVisitor ) return ((gramVisitor<? extends T>)visitor).visitTokenRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenRuleContext tokenRule() throws RecognitionException {
		TokenRuleContext _localctx = new TokenRuleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tokenRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(TOKEN);
			setState(91);
			match(COLON);
			setState(92);
			match(REG_EXPR);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE) {
				{
				setState(93);
				match(CODE);
				}
			}

			setState(96);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return curRules_sempred((CurRulesContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean curRules_sempred(CurRulesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24e\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\5\2\33\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\6\4%\n\4\r\4"+
		"\16\4&\3\4\3\4\3\5\3\5\3\5\3\5\3\6\6\6\60\n\6\r\6\16\6\61\3\7\3\7\5\7"+
		"\66\n\7\3\b\3\b\5\b:\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\6"+
		"\nG\n\n\r\n\16\nH\3\n\5\nL\n\n\3\n\3\n\3\n\7\nQ\n\n\f\n\16\nT\13\n\3\13"+
		"\3\13\3\13\5\13Y\n\13\5\13[\n\13\3\f\3\f\3\f\3\f\5\fa\n\f\3\f\3\f\3\f"+
		"\2\3\22\r\2\4\6\b\n\f\16\20\22\24\26\2\2\2d\2\30\3\2\2\2\4\36\3\2\2\2"+
		"\6\"\3\2\2\2\b*\3\2\2\2\n/\3\2\2\2\f\65\3\2\2\2\16\67\3\2\2\2\20?\3\2"+
		"\2\2\22D\3\2\2\2\24Z\3\2\2\2\26\\\3\2\2\2\30\32\5\4\3\2\31\33\5\6\4\2"+
		"\32\31\3\2\2\2\32\33\3\2\2\2\33\34\3\2\2\2\34\35\5\n\6\2\35\3\3\2\2\2"+
		"\36\37\7\3\2\2\37 \7\22\2\2 !\7\r\2\2!\5\3\2\2\2\"$\7\7\2\2#%\5\b\5\2"+
		"$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\13\2\2)\7\3\2"+
		"\2\2*+\7\22\2\2+,\7\22\2\2,-\7\r\2\2-\t\3\2\2\2.\60\5\f\7\2/.\3\2\2\2"+
		"\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\13\3\2\2\2\63\66\5\16\b\2"+
		"\64\66\5\26\f\2\65\63\3\2\2\2\65\64\3\2\2\2\66\r\3\2\2\2\679\7\22\2\2"+
		"8:\5\20\t\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\7\f\2\2<=\5\22\n\2=>\7\r\2"+
		"\2>\17\3\2\2\2?@\7\5\2\2@A\7\22\2\2AB\7\22\2\2BC\7\t\2\2C\21\3\2\2\2D"+
		"F\b\n\1\2EG\5\24\13\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2"+
		"\2JL\7\20\2\2KJ\3\2\2\2KL\3\2\2\2LR\3\2\2\2MN\f\4\2\2NO\7\16\2\2OQ\5\22"+
		"\n\5PM\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\23\3\2\2\2TR\3\2\2\2U[\7"+
		"\21\2\2VX\7\22\2\2WY\7\17\2\2XW\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZU\3\2\2\2"+
		"ZV\3\2\2\2[\25\3\2\2\2\\]\7\21\2\2]^\7\f\2\2^`\7\23\2\2_a\7\20\2\2`_\3"+
		"\2\2\2`a\3\2\2\2ab\3\2\2\2bc\7\r\2\2c\27\3\2\2\2\r\32&\61\659HKRXZ`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}