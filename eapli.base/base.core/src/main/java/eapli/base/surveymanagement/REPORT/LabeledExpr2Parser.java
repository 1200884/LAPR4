// Generated from C:/Users/marga/OneDrive - ISEP/ISEP/2�ANO/lei21_22_s4_2db_01/eapli.base/base.core/src/main/java/eapli/base/surveymanagement/REPORT\LabeledExpr2.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.REPORT;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LabeledExpr2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, EXCLAMATION=14, INTERROGATION=15, 
		DOT=16, DIGIT=17, LETTER=18, PONTUATION=19, NEXT=20, DEPENDENT=21;
	public static final int
		RULE_survey = 0, RULE_list_of_clients = 1, RULE_client = 2, RULE_list_of_sections = 3, 
		RULE_section = 4, RULE_content = 5, RULE_question_struct = 6, RULE_title = 7, 
		RULE_id = 8, RULE_type = 9, RULE_free_text = 10, RULE_numeric = 11, RULE_single_choice = 12, 
		RULE_multiple_choice = 13, RULE_sorting_options = 14, RULE_scaling_options = 15, 
		RULE_sentence = 16, RULE_word = 17, RULE_dot_mark = 18, RULE_number = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"survey", "list_of_clients", "client", "list_of_sections", "section", 
			"content", "question_struct", "title", "id", "type", "free_text", "numeric", 
			"single_choice", "multiple_choice", "sorting_options", "scaling_options", 
			"sentence", "word", "dot_mark", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'['", "']'", "'No answers.'", "'>'", "'Question'", "'(Free Text)'", 
			"'(Numeric)'", "'(Single Choice)'", "'(Multiple Choice)'", "'(Sorting Options)'", 
			"'(Scaling Options)'", "'-'", "'!'", "'?'", "'.'", null, null, null, 
			null, "'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "EXCLAMATION", "INTERROGATION", "DOT", "DIGIT", "LETTER", 
			"PONTUATION", "NEXT", "DEPENDENT"
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
	public String getGrammarFileName() { return "LabeledExpr2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LabeledExpr2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SurveyContext extends ParserRuleContext {
		public SurveyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_survey; }
	 
		public SurveyContext() { }
		public void copyFrom(SurveyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HandleClientsContext extends SurveyContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List<TerminalNode> NEXT() { return getTokens(LabeledExpr2Parser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExpr2Parser.NEXT, i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List_of_clientsContext list_of_clients() {
			return getRuleContext(List_of_clientsContext.class,0);
		}
		public HandleClientsContext(SurveyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterHandleClients(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitHandleClients(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitHandleClients(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SurveyContext survey() throws RecognitionException {
		SurveyContext _localctx = new SurveyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_survey);
		try {
			_localctx = new HandleClientsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			title();
			setState(41);
			match(NEXT);
			setState(42);
			id();
			setState(43);
			match(NEXT);
			setState(44);
			list_of_clients();
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

	public static class List_of_clientsContext extends ParserRuleContext {
		public List<ClientContext> client() {
			return getRuleContexts(ClientContext.class);
		}
		public ClientContext client(int i) {
			return getRuleContext(ClientContext.class,i);
		}
		public List_of_clientsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_of_clients; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterList_of_clients(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitList_of_clients(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitList_of_clients(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_of_clientsContext list_of_clients() throws RecognitionException {
		List_of_clientsContext _localctx = new List_of_clientsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_list_of_clients);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				client();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
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

	public static class ClientContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode NEXT() { return getToken(LabeledExpr2Parser.NEXT, 0); }
		public List_of_sectionsContext list_of_sections() {
			return getRuleContext(List_of_sectionsContext.class,0);
		}
		public ClientContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_client; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterClient(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitClient(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitClient(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClientContext client() throws RecognitionException {
		ClientContext _localctx = new ClientContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_client);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__0);
			setState(52);
			number();
			setState(53);
			match(T__0);
			setState(54);
			match(NEXT);
			setState(55);
			list_of_sections();
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

	public static class List_of_sectionsContext extends ParserRuleContext {
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public List_of_sectionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_of_sections; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterList_of_sections(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitList_of_sections(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitList_of_sections(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_of_sectionsContext list_of_sections() throws RecognitionException {
		List_of_sectionsContext _localctx = new List_of_sectionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_list_of_sections);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				section();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
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

	public static class SectionContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List<TerminalNode> NEXT() { return getTokens(LabeledExpr2Parser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExpr2Parser.NEXT, i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__1);
			setState(63);
			title();
			setState(64);
			match(NEXT);
			setState(65);
			id();
			setState(66);
			match(NEXT);
			setState(67);
			content();
			setState(68);
			match(T__2);
			setState(69);
			match(NEXT);
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

	public static class ContentContext extends ParserRuleContext {
		public List<Question_structContext> question_struct() {
			return getRuleContexts(Question_structContext.class);
		}
		public Question_structContext question_struct(int i) {
			return getRuleContext(Question_structContext.class,i);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_content);
		int _la;
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(71);
					question_struct();
					}
					}
					setState(74); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__4 );
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(T__3);
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

	public static class Question_structContext extends ParserRuleContext {
		public List<TerminalNode> NEXT() { return getTokens(LabeledExpr2Parser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExpr2Parser.NEXT, i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Question_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_struct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterQuestion_struct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitQuestion_struct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitQuestion_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Question_structContext question_struct() throws RecognitionException {
		Question_structContext _localctx = new Question_structContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_question_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__4);
			setState(80);
			match(NEXT);
			setState(81);
			match(T__5);
			setState(82);
			match(NEXT);
			setState(83);
			id();
			setState(84);
			type();
			setState(85);
			match(NEXT);
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

	public static class TitleContext extends ParserRuleContext {
		public TerminalNode NEXT() { return getToken(LabeledExpr2Parser.NEXT, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_title);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(NEXT);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(90);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
					{
					setState(88);
					number();
					}
					break;
				case LETTER:
					{
					setState(89);
					word();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT || _la==LETTER );
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode PONTUATION() { return getToken(LabeledExpr2Parser.PONTUATION, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(96);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
					{
					setState(94);
					number();
					}
					break;
				case LETTER:
					{
					setState(95);
					word();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT || _la==LETTER );
			setState(100);
			match(PONTUATION);
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
		public Free_textContext free_text() {
			return getRuleContext(Free_textContext.class,0);
		}
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
		public Single_choiceContext single_choice() {
			return getRuleContext(Single_choiceContext.class,0);
		}
		public Multiple_choiceContext multiple_choice() {
			return getRuleContext(Multiple_choiceContext.class,0);
		}
		public Sorting_optionsContext sorting_options() {
			return getRuleContext(Sorting_optionsContext.class,0);
		}
		public Scaling_optionsContext scaling_options() {
			return getRuleContext(Scaling_optionsContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				free_text();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				numeric();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				single_choice();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				multiple_choice();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				sorting_options();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(107);
				scaling_options();
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

	public static class Free_textContext extends ParserRuleContext {
		public List<TerminalNode> NEXT() { return getTokens(LabeledExpr2Parser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExpr2Parser.NEXT, i);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public Free_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_free_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterFree_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitFree_text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitFree_text(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Free_textContext free_text() throws RecognitionException {
		Free_textContext _localctx = new Free_textContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_free_text);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__6);
			setState(113); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(111);
					match(NEXT);
					setState(112);
					sentence();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(115); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class NumericContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterNumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitNumeric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitNumeric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericContext numeric() throws RecognitionException {
		NumericContext _localctx = new NumericContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_numeric);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__7);
			setState(118);
			number();
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

	public static class Single_choiceContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(LabeledExpr2Parser.LETTER, 0); }
		public Single_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterSingle_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitSingle_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitSingle_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_choiceContext single_choice() throws RecognitionException {
		Single_choiceContext _localctx = new Single_choiceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_single_choice);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__8);
			setState(121);
			match(LETTER);
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

	public static class Multiple_choiceContext extends ParserRuleContext {
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public Multiple_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterMultiple_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitMultiple_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitMultiple_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choiceContext multiple_choice() throws RecognitionException {
		Multiple_choiceContext _localctx = new Multiple_choiceContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_multiple_choice);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__9);
			setState(124);
			word();
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

	public static class Sorting_optionsContext extends ParserRuleContext {
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public Sorting_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sorting_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterSorting_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitSorting_options(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitSorting_options(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sorting_optionsContext sorting_options() throws RecognitionException {
		Sorting_optionsContext _localctx = new Sorting_optionsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sorting_options);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__10);
			setState(127);
			word();
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

	public static class Scaling_optionsContext extends ParserRuleContext {
		public List<TerminalNode> NEXT() { return getTokens(LabeledExpr2Parser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExpr2Parser.NEXT, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(LabeledExpr2Parser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(LabeledExpr2Parser.LETTER, i);
		}
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public Scaling_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scaling_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterScaling_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitScaling_options(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitScaling_options(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scaling_optionsContext scaling_options() throws RecognitionException {
		Scaling_optionsContext _localctx = new Scaling_optionsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_scaling_options);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__11);
			setState(134); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(130);
					match(NEXT);
					setState(131);
					match(LETTER);
					setState(132);
					match(T__12);
					setState(133);
					number();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(136); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class SentenceContext extends ParserRuleContext {
		public Dot_markContext dot_mark() {
			return getRuleContext(Dot_markContext.class,0);
		}
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<TerminalNode> NEXT() { return getTokens(LabeledExpr2Parser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExpr2Parser.NEXT, i);
		}
		public List<TerminalNode> PONTUATION() { return getTokens(LabeledExpr2Parser.PONTUATION); }
		public TerminalNode PONTUATION(int i) {
			return getToken(LabeledExpr2Parser.PONTUATION, i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(138);
				word();
				}
				break;
			case DIGIT:
				{
				setState(139);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(150); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PONTUATION) {
					{
					setState(142);
					match(PONTUATION);
					}
				}

				setState(145);
				match(NEXT);
				setState(148);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LETTER:
					{
					setState(146);
					word();
					}
					break;
				case DIGIT:
					{
					setState(147);
					number();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PONTUATION || _la==NEXT );
			setState(154);
			dot_mark();
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

	public static class WordContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(LabeledExpr2Parser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(LabeledExpr2Parser.LETTER, i);
		}
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_word);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(156);
					match(LETTER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(159); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Dot_markContext extends ParserRuleContext {
		public TerminalNode EXCLAMATION() { return getToken(LabeledExpr2Parser.EXCLAMATION, 0); }
		public TerminalNode INTERROGATION() { return getToken(LabeledExpr2Parser.INTERROGATION, 0); }
		public TerminalNode DOT() { return getToken(LabeledExpr2Parser.DOT, 0); }
		public Dot_markContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot_mark; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterDot_mark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitDot_mark(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitDot_mark(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dot_markContext dot_mark() throws RecognitionException {
		Dot_markContext _localctx = new Dot_markContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_dot_mark);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << INTERROGATION) | (1L << DOT))) != 0)) ) {
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

	public static class NumberContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(LabeledExpr2Parser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(LabeledExpr2Parser.DIGIT, i);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExpr2Listener ) ((LabeledExpr2Listener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExpr2Visitor ) return ((LabeledExpr2Visitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_number);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(163);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(166); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static final String _serializedATN =
		"\u0004\u0001\u0015\u00a9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u00010\b\u0001\u000b"+
		"\u0001\f\u00011\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0004\u0003;\b\u0003\u000b\u0003\f\u0003"+
		"<\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005I\b\u0005"+
		"\u000b\u0005\f\u0005J\u0001\u0005\u0003\u0005N\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007[\b\u0007\u000b"+
		"\u0007\f\u0007\\\u0001\b\u0001\b\u0004\ba\b\b\u000b\b\f\bb\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tm\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0004\nr\b\n\u000b\n\f\ns\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0004\u000f\u0087\b\u000f\u000b\u000f\f\u000f\u0088\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u008d\b\u0010\u0001\u0010\u0003\u0010\u0090\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0095\b\u0010\u0004"+
		"\u0010\u0097\b\u0010\u000b\u0010\f\u0010\u0098\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0004\u0011\u009e\b\u0011\u000b\u0011\f\u0011\u009f\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0004\u0013\u00a5\b\u0013\u000b\u0013\f"+
		"\u0013\u00a6\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0001"+
		"\u0001\u0000\u000e\u0010\u00a9\u0000(\u0001\u0000\u0000\u0000\u0002/\u0001"+
		"\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u0006:\u0001\u0000\u0000"+
		"\u0000\b>\u0001\u0000\u0000\u0000\nM\u0001\u0000\u0000\u0000\fO\u0001"+
		"\u0000\u0000\u0000\u000eW\u0001\u0000\u0000\u0000\u0010`\u0001\u0000\u0000"+
		"\u0000\u0012l\u0001\u0000\u0000\u0000\u0014n\u0001\u0000\u0000\u0000\u0016"+
		"u\u0001\u0000\u0000\u0000\u0018x\u0001\u0000\u0000\u0000\u001a{\u0001"+
		"\u0000\u0000\u0000\u001c~\u0001\u0000\u0000\u0000\u001e\u0081\u0001\u0000"+
		"\u0000\u0000 \u008c\u0001\u0000\u0000\u0000\"\u009d\u0001\u0000\u0000"+
		"\u0000$\u00a1\u0001\u0000\u0000\u0000&\u00a4\u0001\u0000\u0000\u0000("+
		")\u0003\u000e\u0007\u0000)*\u0005\u0014\u0000\u0000*+\u0003\u0010\b\u0000"+
		"+,\u0005\u0014\u0000\u0000,-\u0003\u0002\u0001\u0000-\u0001\u0001\u0000"+
		"\u0000\u0000.0\u0003\u0004\u0002\u0000/.\u0001\u0000\u0000\u000001\u0001"+
		"\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"2\u0003\u0001\u0000\u0000\u000034\u0005\u0001\u0000\u000045\u0003&\u0013"+
		"\u000056\u0005\u0001\u0000\u000067\u0005\u0014\u0000\u000078\u0003\u0006"+
		"\u0003\u00008\u0005\u0001\u0000\u0000\u00009;\u0003\b\u0004\u0000:9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=\u0007\u0001\u0000\u0000\u0000>?\u0005\u0002"+
		"\u0000\u0000?@\u0003\u000e\u0007\u0000@A\u0005\u0014\u0000\u0000AB\u0003"+
		"\u0010\b\u0000BC\u0005\u0014\u0000\u0000CD\u0003\n\u0005\u0000DE\u0005"+
		"\u0003\u0000\u0000EF\u0005\u0014\u0000\u0000F\t\u0001\u0000\u0000\u0000"+
		"GI\u0003\f\u0006\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000"+
		"\u0000LN\u0005\u0004\u0000\u0000MH\u0001\u0000\u0000\u0000ML\u0001\u0000"+
		"\u0000\u0000N\u000b\u0001\u0000\u0000\u0000OP\u0005\u0005\u0000\u0000"+
		"PQ\u0005\u0014\u0000\u0000QR\u0005\u0006\u0000\u0000RS\u0005\u0014\u0000"+
		"\u0000ST\u0003\u0010\b\u0000TU\u0003\u0012\t\u0000UV\u0005\u0014\u0000"+
		"\u0000V\r\u0001\u0000\u0000\u0000WZ\u0005\u0014\u0000\u0000X[\u0003&\u0013"+
		"\u0000Y[\u0003\"\u0011\u0000ZX\u0001\u0000\u0000\u0000ZY\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]\u000f\u0001\u0000\u0000\u0000^a\u0003&\u0013\u0000"+
		"_a\u0003\"\u0011\u0000`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000cd\u0001\u0000\u0000\u0000de\u0005\u0013\u0000\u0000e\u0011\u0001"+
		"\u0000\u0000\u0000fm\u0003\u0014\n\u0000gm\u0003\u0016\u000b\u0000hm\u0003"+
		"\u0018\f\u0000im\u0003\u001a\r\u0000jm\u0003\u001c\u000e\u0000km\u0003"+
		"\u001e\u000f\u0000lf\u0001\u0000\u0000\u0000lg\u0001\u0000\u0000\u0000"+
		"lh\u0001\u0000\u0000\u0000li\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000"+
		"\u0000lk\u0001\u0000\u0000\u0000m\u0013\u0001\u0000\u0000\u0000nq\u0005"+
		"\u0007\u0000\u0000op\u0005\u0014\u0000\u0000pr\u0003 \u0010\u0000qo\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000t\u0015\u0001\u0000\u0000\u0000uv\u0005\b\u0000"+
		"\u0000vw\u0003&\u0013\u0000w\u0017\u0001\u0000\u0000\u0000xy\u0005\t\u0000"+
		"\u0000yz\u0005\u0012\u0000\u0000z\u0019\u0001\u0000\u0000\u0000{|\u0005"+
		"\n\u0000\u0000|}\u0003\"\u0011\u0000}\u001b\u0001\u0000\u0000\u0000~\u007f"+
		"\u0005\u000b\u0000\u0000\u007f\u0080\u0003\"\u0011\u0000\u0080\u001d\u0001"+
		"\u0000\u0000\u0000\u0081\u0086\u0005\f\u0000\u0000\u0082\u0083\u0005\u0014"+
		"\u0000\u0000\u0083\u0084\u0005\u0012\u0000\u0000\u0084\u0085\u0005\r\u0000"+
		"\u0000\u0085\u0087\u0003&\u0013\u0000\u0086\u0082\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u001f\u0001\u0000\u0000\u0000"+
		"\u008a\u008d\u0003\"\u0011\u0000\u008b\u008d\u0003&\u0013\u0000\u008c"+
		"\u008a\u0001\u0000\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d"+
		"\u0096\u0001\u0000\u0000\u0000\u008e\u0090\u0005\u0013\u0000\u0000\u008f"+
		"\u008e\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0001\u0000\u0000\u0000\u0091\u0094\u0005\u0014\u0000\u0000\u0092"+
		"\u0095\u0003\"\u0011\u0000\u0093\u0095\u0003&\u0013\u0000\u0094\u0092"+
		"\u0001\u0000\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0097"+
		"\u0001\u0000\u0000\u0000\u0096\u008f\u0001\u0000\u0000\u0000\u0097\u0098"+
		"\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0003$\u0012\u0000\u009b!\u0001\u0000\u0000\u0000\u009c\u009e\u0005\u0012"+
		"\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000"+
		"\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a0#\u0001\u0000\u0000\u0000\u00a1\u00a2\u0007\u0000\u0000"+
		"\u0000\u00a2%\u0001\u0000\u0000\u0000\u00a3\u00a5\u0005\u0011\u0000\u0000"+
		"\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\'\u0001\u0000\u0000\u0000\u00111<JMZ\\`bls\u0088\u008c\u008f\u0094"+
		"\u0098\u009f\u00a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}