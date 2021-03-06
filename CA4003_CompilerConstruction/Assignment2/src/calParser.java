// Generated from cal.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Variable=1, Constant=2, Return=3, Integer=4, Boolean=5, Void=6, Main=7, 
		If=8, Else=9, True=10, False=11, While=12, Begin=13, End=14, Is=15, Skip=16, 
		Assign=17, Comma=18, Semi=19, Colon=20, LBR=21, RBR=22, Plus=23, Minus=24, 
		Negate=25, Or=26, And=27, Equal=28, NotEqual=29, LessEq=30, Less=31, GreaterEq=32, 
		Greater=33, Num=34, Id=35, InLineComment=36, LineComment=37, WS=38;
	public static final int
		RULE_program = 0, RULE_decl_list = 1, RULE_decl = 2, RULE_var_decl = 3, 
		RULE_const_decl = 4, RULE_function_list = 5, RULE_function = 6, RULE_type = 7, 
		RULE_parameter_list = 8, RULE_nemp_parameter_list = 9, RULE_end = 10, 
		RULE_main = 11, RULE_statement_block = 12, RULE_statement = 13, RULE_expression = 14, 
		RULE_binary_arith_op = 15, RULE_frag = 16, RULE_condition = 17, RULE_comp_op = 18, 
		RULE_arg_list = 19, RULE_nemp_arg_list = 20;
	public static final String[] ruleNames = {
		"program", "decl_list", "decl", "var_decl", "const_decl", "function_list", 
		"function", "type", "parameter_list", "nemp_parameter_list", "end", "main", 
		"statement_block", "statement", "expression", "binary_arith_op", "frag", 
		"condition", "comp_op", "arg_list", "nemp_arg_list"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "':='", "','", "';'", "':'", "'('", "')'", 
		"'+'", "'-'", "'~'", "'|'", "'&'", "'='", "'!='", "'<='", "'<'", "'>='", 
		"'>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Variable", "Constant", "Return", "Integer", "Boolean", "Void", 
		"Main", "If", "Else", "True", "False", "While", "Begin", "End", "Is", 
		"Skip", "Assign", "Comma", "Semi", "Colon", "LBR", "RBR", "Plus", "Minus", 
		"Negate", "Or", "And", "Equal", "NotEqual", "LessEq", "Less", "GreaterEq", 
		"Greater", "Num", "Id", "InLineComment", "LineComment", "WS"
	};
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
	public String getGrammarFileName() { return "cal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public calParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Function_listContext function_list() {
			return getRuleContext(Function_listContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			decl_list();
			setState(43);
			function_list();
			setState(44);
			main();
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

	public static class Decl_listContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public TerminalNode Semi() { return getToken(calParser.Semi, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitDecl_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_listContext decl_list() throws RecognitionException {
		Decl_listContext _localctx = new Decl_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl_list);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Variable:
			case Constant:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				decl();
				setState(47);
				match(Semi);
				setState(48);
				decl_list();
				}
				break;
			case Integer:
			case Boolean:
			case Void:
			case Main:
			case If:
			case While:
			case Begin:
			case End:
			case Skip:
			case Id:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class DeclContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Const_declContext const_decl() {
			return getRuleContext(Const_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Variable:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				var_decl();
				}
				break;
			case Constant:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				const_decl();
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

	public static class Var_declContext extends ParserRuleContext {
		public TerminalNode Variable() { return getToken(calParser.Variable, 0); }
		public TerminalNode Id() { return getToken(calParser.Id, 0); }
		public TerminalNode Colon() { return getToken(calParser.Colon, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(Variable);
			setState(58);
			match(Id);
			setState(59);
			match(Colon);
			setState(60);
			type();
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

	public static class Const_declContext extends ParserRuleContext {
		public TerminalNode Constant() { return getToken(calParser.Constant, 0); }
		public TerminalNode Id() { return getToken(calParser.Id, 0); }
		public TerminalNode Colon() { return getToken(calParser.Colon, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Assign() { return getToken(calParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Const_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitConst_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_declContext const_decl() throws RecognitionException {
		Const_declContext _localctx = new Const_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_const_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(Constant);
			setState(63);
			match(Id);
			setState(64);
			match(Colon);
			setState(65);
			type();
			setState(66);
			match(Assign);
			setState(67);
			expression();
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

	public static class Function_listContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public Function_listContext function_list() {
			return getRuleContext(Function_listContext.class,0);
		}
		public Function_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFunction_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_listContext function_list() throws RecognitionException {
		Function_listContext _localctx = new Function_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_list);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
			case Boolean:
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				function();
				setState(70);
				function_list();
				}
				break;
			case Main:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class FunctionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Id() { return getToken(calParser.Id, 0); }
		public List<TerminalNode> LBR() { return getTokens(calParser.LBR); }
		public TerminalNode LBR(int i) {
			return getToken(calParser.LBR, i);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public List<TerminalNode> RBR() { return getTokens(calParser.RBR); }
		public TerminalNode RBR(int i) {
			return getToken(calParser.RBR, i);
		}
		public TerminalNode Is() { return getToken(calParser.Is, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode Return() { return getToken(calParser.Return, 0); }
		public TerminalNode Semi() { return getToken(calParser.Semi, 0); }
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			type();
			setState(76);
			match(Id);
			setState(77);
			match(LBR);
			setState(78);
			parameter_list();
			setState(79);
			match(RBR);
			setState(80);
			match(Is);
			setState(81);
			decl_list();
			setState(82);
			match(Begin);
			setState(83);
			statement_block();
			setState(84);
			match(Return);
			setState(85);
			match(LBR);
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case True:
			case False:
			case LBR:
			case Minus:
			case Num:
			case Id:
				{
				setState(86);
				expression();
				}
				break;
			case RBR:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(90);
			match(RBR);
			setState(91);
			match(Semi);
			setState(92);
			end();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Integer() { return getToken(calParser.Integer, 0); }
		public TerminalNode Boolean() { return getToken(calParser.Boolean, 0); }
		public TerminalNode Void() { return getToken(calParser.Void, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Integer) | (1L << Boolean) | (1L << Void))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Parameter_listContext extends ParserRuleContext {
		public Nemp_parameter_listContext nemp_parameter_list() {
			return getRuleContext(Nemp_parameter_listContext.class,0);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter_list);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				nemp_parameter_list();
				}
				break;
			case RBR:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Nemp_parameter_listContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(calParser.Id, 0); }
		public TerminalNode Colon() { return getToken(calParser.Colon, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Comma() { return getToken(calParser.Comma, 0); }
		public Nemp_parameter_listContext nemp_parameter_list() {
			return getRuleContext(Nemp_parameter_listContext.class,0);
		}
		public Nemp_parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nemp_parameter_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNemp_parameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nemp_parameter_listContext nemp_parameter_list() throws RecognitionException {
		Nemp_parameter_listContext _localctx = new Nemp_parameter_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nemp_parameter_list);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(Id);
				setState(101);
				match(Colon);
				setState(102);
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(Id);
				setState(104);
				match(Colon);
				setState(105);
				type();
				setState(106);
				match(Comma);
				setState(107);
				nemp_parameter_list();
				}
				break;
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

	public static class EndContext extends ParserRuleContext {
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(End);
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

	public static class MainContext extends ParserRuleContext {
		public TerminalNode Main() { return getToken(calParser.Main, 0); }
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(Main);
			setState(114);
			match(Begin);
			setState(115);
			decl_list();
			setState(116);
			statement_block();
			setState(117);
			end();
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

	public static class Statement_blockContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Statement_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatement_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement_block);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
			case While:
			case Begin:
			case Skip:
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				statement();
				setState(120);
				statement_block();
				}
				break;
			case Return:
			case End:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Statement6Context extends StatementContext {
		public TerminalNode Skip() { return getToken(calParser.Skip, 0); }
		public TerminalNode Semi() { return getToken(calParser.Semi, 0); }
		public Statement6Context(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatement6(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Statement5Context extends StatementContext {
		public TerminalNode While() { return getToken(calParser.While, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public Statement5Context(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatement5(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Statement4Context extends StatementContext {
		public TerminalNode If() { return getToken(calParser.If, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> Begin() { return getTokens(calParser.Begin); }
		public TerminalNode Begin(int i) {
			return getToken(calParser.Begin, i);
		}
		public List<Statement_blockContext> statement_block() {
			return getRuleContexts(Statement_blockContext.class);
		}
		public Statement_blockContext statement_block(int i) {
			return getRuleContext(Statement_blockContext.class,i);
		}
		public List<TerminalNode> End() { return getTokens(calParser.End); }
		public TerminalNode End(int i) {
			return getToken(calParser.End, i);
		}
		public TerminalNode Else() { return getToken(calParser.Else, 0); }
		public Statement4Context(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatement4(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Statement3Context extends StatementContext {
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public Statement3Context(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatement3(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Statement2Context extends StatementContext {
		public TerminalNode Id() { return getToken(calParser.Id, 0); }
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public TerminalNode Semi() { return getToken(calParser.Semi, 0); }
		public Statement2Context(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatement2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Statement1Context extends StatementContext {
		public TerminalNode Id() { return getToken(calParser.Id, 0); }
		public TerminalNode Assign() { return getToken(calParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(calParser.Semi, 0); }
		public Statement1Context(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatement1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new Statement1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(Id);
				setState(126);
				match(Assign);
				setState(127);
				expression();
				setState(128);
				match(Semi);
				}
				break;
			case 2:
				_localctx = new Statement2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(Id);
				setState(131);
				match(LBR);
				setState(132);
				arg_list();
				setState(133);
				match(RBR);
				setState(134);
				match(Semi);
				}
				break;
			case 3:
				_localctx = new Statement3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(Begin);
				setState(137);
				statement_block();
				setState(138);
				match(End);
				}
				break;
			case 4:
				_localctx = new Statement4Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				match(If);
				setState(141);
				condition(0);
				setState(142);
				match(Begin);
				setState(143);
				statement_block();
				setState(144);
				match(End);
				setState(145);
				match(Else);
				setState(146);
				match(Begin);
				setState(147);
				statement_block();
				setState(148);
				match(End);
				}
				break;
			case 5:
				_localctx = new Statement5Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(150);
				match(While);
				setState(151);
				condition(0);
				setState(152);
				match(Begin);
				setState(153);
				statement_block();
				setState(154);
				match(End);
				}
				break;
			case 6:
				_localctx = new Statement6Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(156);
				match(Skip);
				setState(157);
				match(Semi);
				}
				break;
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expression1Context extends ExpressionContext {
		public List<FragContext> frag() {
			return getRuleContexts(FragContext.class);
		}
		public FragContext frag(int i) {
			return getRuleContext(FragContext.class,i);
		}
		public Binary_arith_opContext binary_arith_op() {
			return getRuleContext(Binary_arith_opContext.class,0);
		}
		public Expression1Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitExpression1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expression2Context extends ExpressionContext {
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public Expression2Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitExpression2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expression3Context extends ExpressionContext {
		public TerminalNode Id() { return getToken(calParser.Id, 0); }
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public Expression3Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitExpression3(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expression4Context extends ExpressionContext {
		public FragContext frag() {
			return getRuleContext(FragContext.class,0);
		}
		public Expression4Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitExpression4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expression);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new Expression1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				frag();
				setState(161);
				binary_arith_op();
				setState(162);
				frag();
				}
				break;
			case 2:
				_localctx = new Expression2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(LBR);
				setState(165);
				expression();
				setState(166);
				match(RBR);
				}
				break;
			case 3:
				_localctx = new Expression3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(Id);
				setState(169);
				match(LBR);
				setState(170);
				arg_list();
				setState(171);
				match(RBR);
				}
				break;
			case 4:
				_localctx = new Expression4Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				frag();
				}
				break;
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

	public static class Binary_arith_opContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(calParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(calParser.Minus, 0); }
		public Binary_arith_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_arith_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitBinary_arith_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_arith_opContext binary_arith_op() throws RecognitionException {
		Binary_arith_opContext _localctx = new Binary_arith_opContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_binary_arith_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_la = _input.LA(1);
			if ( !(_la==Plus || _la==Minus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class FragContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(calParser.Id, 0); }
		public TerminalNode Minus() { return getToken(calParser.Minus, 0); }
		public TerminalNode Num() { return getToken(calParser.Num, 0); }
		public TerminalNode True() { return getToken(calParser.True, 0); }
		public TerminalNode False() { return getToken(calParser.False, 0); }
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public FragContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frag; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFrag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FragContext frag() throws RecognitionException {
		FragContext _localctx = new FragContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_frag);
		try {
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(Id);
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(Minus);
				setState(180);
				match(Id);
				}
				break;
			case Num:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				match(Num);
				}
				break;
			case True:
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				match(True);
				}
				break;
			case False:
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
				match(False);
				}
				break;
			case LBR:
				enterOuterAlt(_localctx, 6);
				{
				setState(184);
				match(LBR);
				setState(185);
				expression();
				setState(186);
				match(RBR);
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode Negate() { return getToken(calParser.Negate, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public TerminalNode Or() { return getToken(calParser.Or, 0); }
		public TerminalNode And() { return getToken(calParser.And, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(191);
				match(Negate);
				setState(192);
				condition(4);
				}
				break;
			case 2:
				{
				setState(193);
				match(LBR);
				setState(194);
				condition(0);
				setState(195);
				match(RBR);
				}
				break;
			case 3:
				{
				setState(197);
				expression();
				setState(198);
				comp_op();
				setState(199);
				expression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(203);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(204);
					_la = _input.LA(1);
					if ( !(_la==Or || _la==And) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(205);
					condition(2);
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class Comp_opContext extends ParserRuleContext {
		public TerminalNode Equal() { return getToken(calParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(calParser.NotEqual, 0); }
		public TerminalNode Less() { return getToken(calParser.Less, 0); }
		public TerminalNode LessEq() { return getToken(calParser.LessEq, 0); }
		public TerminalNode Greater() { return getToken(calParser.Greater, 0); }
		public TerminalNode GreaterEq() { return getToken(calParser.GreaterEq, 0); }
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitComp_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equal) | (1L << NotEqual) | (1L << LessEq) | (1L << Less) | (1L << GreaterEq) | (1L << Greater))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Arg_listContext extends ParserRuleContext {
		public Nemp_arg_listContext nemp_arg_list() {
			return getRuleContext(Nemp_arg_listContext.class,0);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitArg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arg_list);
		try {
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Id:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				nemp_arg_list();
				}
				break;
			case RBR:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Nemp_arg_listContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(calParser.Id, 0); }
		public TerminalNode Comma() { return getToken(calParser.Comma, 0); }
		public Nemp_arg_listContext nemp_arg_list() {
			return getRuleContext(Nemp_arg_listContext.class,0);
		}
		public Nemp_arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nemp_arg_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNemp_arg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nemp_arg_listContext nemp_arg_list() throws RecognitionException {
		Nemp_arg_listContext _localctx = new Nemp_arg_listContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_nemp_arg_list);
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				match(Id);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(Id);
				setState(219);
				match(Comma);
				setState(220);
				nemp_arg_list();
				}
				break;
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
		case 17:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00e2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\5\3\66\n\3\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7L\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b[\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\5\ne\n\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13p\n\13\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\5\16~\n\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00a1\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00b1\n\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00bf\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00cc\n\23\3\23\3\23\3\23\7\23\u00d1\n"+
		"\23\f\23\16\23\u00d4\13\23\3\24\3\24\3\25\3\25\5\25\u00da\n\25\3\26\3"+
		"\26\3\26\3\26\5\26\u00e0\n\26\3\26\2\3$\27\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*\2\6\3\2\6\b\3\2\31\32\3\2\34\35\3\2\36#\2\u00e5\2"+
		",\3\2\2\2\4\65\3\2\2\2\69\3\2\2\2\b;\3\2\2\2\n@\3\2\2\2\fK\3\2\2\2\16"+
		"M\3\2\2\2\20`\3\2\2\2\22d\3\2\2\2\24o\3\2\2\2\26q\3\2\2\2\30s\3\2\2\2"+
		"\32}\3\2\2\2\34\u00a0\3\2\2\2\36\u00b0\3\2\2\2 \u00b2\3\2\2\2\"\u00be"+
		"\3\2\2\2$\u00cb\3\2\2\2&\u00d5\3\2\2\2(\u00d9\3\2\2\2*\u00df\3\2\2\2,"+
		"-\5\4\3\2-.\5\f\7\2./\5\30\r\2/\3\3\2\2\2\60\61\5\6\4\2\61\62\7\25\2\2"+
		"\62\63\5\4\3\2\63\66\3\2\2\2\64\66\3\2\2\2\65\60\3\2\2\2\65\64\3\2\2\2"+
		"\66\5\3\2\2\2\67:\5\b\5\28:\5\n\6\29\67\3\2\2\298\3\2\2\2:\7\3\2\2\2;"+
		"<\7\3\2\2<=\7%\2\2=>\7\26\2\2>?\5\20\t\2?\t\3\2\2\2@A\7\4\2\2AB\7%\2\2"+
		"BC\7\26\2\2CD\5\20\t\2DE\7\23\2\2EF\5\36\20\2F\13\3\2\2\2GH\5\16\b\2H"+
		"I\5\f\7\2IL\3\2\2\2JL\3\2\2\2KG\3\2\2\2KJ\3\2\2\2L\r\3\2\2\2MN\5\20\t"+
		"\2NO\7%\2\2OP\7\27\2\2PQ\5\22\n\2QR\7\30\2\2RS\7\21\2\2ST\5\4\3\2TU\7"+
		"\17\2\2UV\5\32\16\2VW\7\5\2\2WZ\7\27\2\2X[\5\36\20\2Y[\3\2\2\2ZX\3\2\2"+
		"\2ZY\3\2\2\2[\\\3\2\2\2\\]\7\30\2\2]^\7\25\2\2^_\5\26\f\2_\17\3\2\2\2"+
		"`a\t\2\2\2a\21\3\2\2\2be\5\24\13\2ce\3\2\2\2db\3\2\2\2dc\3\2\2\2e\23\3"+
		"\2\2\2fg\7%\2\2gh\7\26\2\2hp\5\20\t\2ij\7%\2\2jk\7\26\2\2kl\5\20\t\2l"+
		"m\7\24\2\2mn\5\24\13\2np\3\2\2\2of\3\2\2\2oi\3\2\2\2p\25\3\2\2\2qr\7\20"+
		"\2\2r\27\3\2\2\2st\7\t\2\2tu\7\17\2\2uv\5\4\3\2vw\5\32\16\2wx\5\26\f\2"+
		"x\31\3\2\2\2yz\5\34\17\2z{\5\32\16\2{~\3\2\2\2|~\3\2\2\2}y\3\2\2\2}|\3"+
		"\2\2\2~\33\3\2\2\2\177\u0080\7%\2\2\u0080\u0081\7\23\2\2\u0081\u0082\5"+
		"\36\20\2\u0082\u0083\7\25\2\2\u0083\u00a1\3\2\2\2\u0084\u0085\7%\2\2\u0085"+
		"\u0086\7\27\2\2\u0086\u0087\5(\25\2\u0087\u0088\7\30\2\2\u0088\u0089\7"+
		"\25\2\2\u0089\u00a1\3\2\2\2\u008a\u008b\7\17\2\2\u008b\u008c\5\32\16\2"+
		"\u008c\u008d\7\20\2\2\u008d\u00a1\3\2\2\2\u008e\u008f\7\n\2\2\u008f\u0090"+
		"\5$\23\2\u0090\u0091\7\17\2\2\u0091\u0092\5\32\16\2\u0092\u0093\7\20\2"+
		"\2\u0093\u0094\7\13\2\2\u0094\u0095\7\17\2\2\u0095\u0096\5\32\16\2\u0096"+
		"\u0097\7\20\2\2\u0097\u00a1\3\2\2\2\u0098\u0099\7\16\2\2\u0099\u009a\5"+
		"$\23\2\u009a\u009b\7\17\2\2\u009b\u009c\5\32\16\2\u009c\u009d\7\20\2\2"+
		"\u009d\u00a1\3\2\2\2\u009e\u009f\7\22\2\2\u009f\u00a1\7\25\2\2\u00a0\177"+
		"\3\2\2\2\u00a0\u0084\3\2\2\2\u00a0\u008a\3\2\2\2\u00a0\u008e\3\2\2\2\u00a0"+
		"\u0098\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\35\3\2\2\2\u00a2\u00a3\5\"\22"+
		"\2\u00a3\u00a4\5 \21\2\u00a4\u00a5\5\"\22\2\u00a5\u00b1\3\2\2\2\u00a6"+
		"\u00a7\7\27\2\2\u00a7\u00a8\5\36\20\2\u00a8\u00a9\7\30\2\2\u00a9\u00b1"+
		"\3\2\2\2\u00aa\u00ab\7%\2\2\u00ab\u00ac\7\27\2\2\u00ac\u00ad\5(\25\2\u00ad"+
		"\u00ae\7\30\2\2\u00ae\u00b1\3\2\2\2\u00af\u00b1\5\"\22\2\u00b0\u00a2\3"+
		"\2\2\2\u00b0\u00a6\3\2\2\2\u00b0\u00aa\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1"+
		"\37\3\2\2\2\u00b2\u00b3\t\3\2\2\u00b3!\3\2\2\2\u00b4\u00bf\7%\2\2\u00b5"+
		"\u00b6\7\32\2\2\u00b6\u00bf\7%\2\2\u00b7\u00bf\7$\2\2\u00b8\u00bf\7\f"+
		"\2\2\u00b9\u00bf\7\r\2\2\u00ba\u00bb\7\27\2\2\u00bb\u00bc\5\36\20\2\u00bc"+
		"\u00bd\7\30\2\2\u00bd\u00bf\3\2\2\2\u00be\u00b4\3\2\2\2\u00be\u00b5\3"+
		"\2\2\2\u00be\u00b7\3\2\2\2\u00be\u00b8\3\2\2\2\u00be\u00b9\3\2\2\2\u00be"+
		"\u00ba\3\2\2\2\u00bf#\3\2\2\2\u00c0\u00c1\b\23\1\2\u00c1\u00c2\7\33\2"+
		"\2\u00c2\u00cc\5$\23\6\u00c3\u00c4\7\27\2\2\u00c4\u00c5\5$\23\2\u00c5"+
		"\u00c6\7\30\2\2\u00c6\u00cc\3\2\2\2\u00c7\u00c8\5\36\20\2\u00c8\u00c9"+
		"\5&\24\2\u00c9\u00ca\5\36\20\2\u00ca\u00cc\3\2\2\2\u00cb\u00c0\3\2\2\2"+
		"\u00cb\u00c3\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cc\u00d2\3\2\2\2\u00cd\u00ce"+
		"\f\3\2\2\u00ce\u00cf\t\4\2\2\u00cf\u00d1\5$\23\4\u00d0\u00cd\3\2\2\2\u00d1"+
		"\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3%\3\2\2\2"+
		"\u00d4\u00d2\3\2\2\2\u00d5\u00d6\t\5\2\2\u00d6\'\3\2\2\2\u00d7\u00da\5"+
		"*\26\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da"+
		")\3\2\2\2\u00db\u00e0\7%\2\2\u00dc\u00dd\7%\2\2\u00dd\u00de\7\24\2\2\u00de"+
		"\u00e0\5*\26\2\u00df\u00db\3\2\2\2\u00df\u00dc\3\2\2\2\u00e0+\3\2\2\2"+
		"\20\659KZdo}\u00a0\u00b0\u00be\u00cb\u00d2\u00d9\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}