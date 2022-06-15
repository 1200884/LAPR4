// Generated from C:/Users/PC/OneDrive - Instituto Superior de Engenharia do Porto/Desktop/Gustavo/ISEP/LAPR4/eapli.base/base.core/src/main/java/eapli/base/surveymanagement/ANTLR\LabeledExpr.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.ANTLR;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LabeledExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, EXCLAMATION=17, 
		INTERROGATION=18, DOT=19, DIGIT=20, LETTER=21, PONTUATION=22, NEXT=23, 
		MANDATORY=24, OPTIONAL=25, CD=26;
	public static final int
		RULE_questionnaire = 0, RULE_list_of_sections = 1, RULE_section = 2, RULE_content = 3, 
		RULE_question_struct = 4, RULE_title = 5, RULE_id = 6, RULE_welcome_message = 7, 
		RULE_section_description = 8, RULE_instruction = 9, RULE_final_message = 10, 
		RULE_type = 11, RULE_repeatability = 12, RULE_repeatable = 13, RULE_non_repeatable = 14, 
		RULE_obligatoriness = 15, RULE_mandatory = 16, RULE_optional = 17, RULE_cd = 18, 
		RULE_option = 19, RULE_free_text = 20, RULE_numeric = 21, RULE_single_choice = 22, 
		RULE_single_choice_input = 23, RULE_multiple_choice = 24, RULE_multiple_choice_input = 25, 
		RULE_sorting_options = 26, RULE_scaling_options = 27, RULE_text = 28, 
		RULE_sentence = 29, RULE_word = 30, RULE_dot_mark = 31, RULE_number = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"questionnaire", "list_of_sections", "section", "content", "question_struct", 
			"title", "id", "welcome_message", "section_description", "instruction", 
			"final_message", "type", "repeatability", "repeatable", "non_repeatable", 
			"obligatoriness", "mandatory", "optional", "cd", "option", "free_text", 
			"numeric", "single_choice", "single_choice_input", "multiple_choice", 
			"multiple_choice_input", "sorting_options", "scaling_options", "text", 
			"sentence", "word", "dot_mark", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-----------------------------------------------------'", "'['", 
			"']'", "'>'", "'further questions.'", "'-'", "'(Free Text)'", "'(Numeric)'", 
			"'(Single Choice)'", "'(Single Choice with input)'", "'(Multiple Choice)'", 
			"'(Multiple Choice with input)'", "'(Sorting Options)'", "'(Scaling Options)'", 
			"'The options are:'", "'\"'", "'!'", "'?'", "'.'", null, null, null, 
			null, "'-----Mandatory'", "'-----Optional'", "'-----Condition dependent'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "EXCLAMATION", "INTERROGATION", "DOT", 
			"DIGIT", "LETTER", "PONTUATION", "NEXT", "MANDATORY", "OPTIONAL", "CD"
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
	public String getGrammarFileName() { return "LabeledExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LabeledExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QuestionnaireContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List<TerminalNode> NEXT() { return getTokens(LabeledExprParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExprParser.NEXT, i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Welcome_messageContext welcome_message() {
			return getRuleContext(Welcome_messageContext.class,0);
		}
		public List_of_sectionsContext list_of_sections() {
			return getRuleContext(List_of_sectionsContext.class,0);
		}
		public Final_messageContext final_message() {
			return getRuleContext(Final_messageContext.class,0);
		}
		public QuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitQuestionnaire(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitQuestionnaire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionnaireContext questionnaire() throws RecognitionException {
		QuestionnaireContext _localctx = new QuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionnaire);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			title();
			setState(67);
			match(NEXT);
			setState(68);
			id();
			setState(69);
			match(NEXT);
			setState(70);
			welcome_message();
			setState(71);
			match(NEXT);
			setState(72);
			match(T__0);
			setState(73);
			match(NEXT);
			setState(74);
			list_of_sections();
			setState(75);
			final_message();
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
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterList_of_sections(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitList_of_sections(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitList_of_sections(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_of_sectionsContext list_of_sections() throws RecognitionException {
		List_of_sectionsContext _localctx = new List_of_sectionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_list_of_sections);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				section();
				}
				}
				setState(80); 
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
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
	 
		public SectionContext() { }
		public void copyFrom(SectionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HandleSectionContext extends SectionContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List<TerminalNode> NEXT() { return getTokens(LabeledExprParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExprParser.NEXT, i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Section_descriptionContext section_description() {
			return getRuleContext(Section_descriptionContext.class,0);
		}
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public HandleSectionContext(SectionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterHandleSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitHandleSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitHandleSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_section);
		try {
			_localctx = new HandleSectionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__1);
			setState(83);
			title();
			setState(84);
			match(NEXT);
			setState(85);
			id();
			setState(86);
			match(NEXT);
			setState(87);
			section_description();
			setState(88);
			match(NEXT);
			setState(89);
			obligatoriness();
			setState(90);
			match(NEXT);
			setState(91);
			content();
			setState(92);
			match(T__2);
			setState(93);
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
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(95);
				question_struct();
				}
				}
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
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
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<TerminalNode> NEXT() { return getTokens(LabeledExprParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExprParser.NEXT, i);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
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
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterQuestion_struct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitQuestion_struct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitQuestion_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Question_structContext question_struct() throws RecognitionException {
		Question_structContext _localctx = new Question_structContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_question_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__3);
			setState(101);
			id();
			setState(102);
			match(NEXT);
			setState(103);
			instruction();
			setState(104);
			match(NEXT);
			setState(105);
			type();
			setState(106);
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
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
	 
		public TitleContext() { }
		public void copyFrom(TitleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintTitleContext extends TitleContext {
		public TerminalNode NEXT() { return getToken(LabeledExprParser.NEXT, 0); }
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
		public PrintTitleContext(TitleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterPrintTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitPrintTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitPrintTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_title);
		int _la;
		try {
			_localctx = new PrintTitleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(NEXT);
			setState(111); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(111);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
					{
					setState(109);
					number();
					}
					break;
				case LETTER:
					{
					setState(110);
					word();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(113); 
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
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
	 
		public IdContext() { }
		public void copyFrom(IdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintIdContext extends IdContext {
		public TerminalNode PONTUATION() { return getToken(LabeledExprParser.PONTUATION, 0); }
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
		public PrintIdContext(IdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterPrintId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitPrintId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitPrintId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_id);
		int _la;
		try {
			_localctx = new PrintIdContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(117);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
					{
					setState(115);
					number();
					}
					break;
				case LETTER:
					{
					setState(116);
					word();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT || _la==LETTER );
			setState(121);
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

	public static class Welcome_messageContext extends ParserRuleContext {
		public Welcome_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_welcome_message; }
	 
		public Welcome_messageContext() { }
		public void copyFrom(Welcome_messageContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintExprContext extends Welcome_messageContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public PrintExprContext(Welcome_messageContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterPrintExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitPrintExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitPrintExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Welcome_messageContext welcome_message() throws RecognitionException {
		Welcome_messageContext _localctx = new Welcome_messageContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_welcome_message);
		try {
			_localctx = new PrintExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			text();
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

	public static class Section_descriptionContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public Section_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterSection_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitSection_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitSection_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Section_descriptionContext section_description() throws RecognitionException {
		Section_descriptionContext _localctx = new Section_descriptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_section_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			sentence();
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

	public static class InstructionContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			sentence();
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

	public static class Final_messageContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public Final_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_final_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterFinal_message(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitFinal_message(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitFinal_message(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Final_messageContext final_message() throws RecognitionException {
		Final_messageContext _localctx = new Final_messageContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_final_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			text();
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
		public RepeatabilityContext repeatability() {
			return getRuleContext(RepeatabilityContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			repeatability();
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

	public static class RepeatabilityContext extends ParserRuleContext {
		public RepeatableContext repeatable() {
			return getRuleContext(RepeatableContext.class,0);
		}
		public Non_repeatableContext non_repeatable() {
			return getRuleContext(Non_repeatableContext.class,0);
		}
		public RepeatabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterRepeatability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitRepeatability(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitRepeatability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatabilityContext repeatability() throws RecognitionException {
		RepeatabilityContext _localctx = new RepeatabilityContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_repeatability);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				repeatable();
				}
				break;
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				non_repeatable();
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

	public static class RepeatableContext extends ParserRuleContext {
		public Free_textContext free_text() {
			return getRuleContext(Free_textContext.class,0);
		}
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
		public Single_choice_inputContext single_choice_input() {
			return getRuleContext(Single_choice_inputContext.class,0);
		}
		public Multiple_choice_inputContext multiple_choice_input() {
			return getRuleContext(Multiple_choice_inputContext.class,0);
		}
		public Single_choiceContext single_choice() {
			return getRuleContext(Single_choiceContext.class,0);
		}
		public Multiple_choiceContext multiple_choice() {
			return getRuleContext(Multiple_choiceContext.class,0);
		}
		public RepeatableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterRepeatable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitRepeatable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitRepeatable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatableContext repeatable() throws RecognitionException {
		RepeatableContext _localctx = new RepeatableContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_repeatable);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				free_text();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				numeric();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				single_choice_input();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				multiple_choice_input();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(141);
				single_choice();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(142);
				multiple_choice();
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

	public static class Non_repeatableContext extends ParserRuleContext {
		public Sorting_optionsContext sorting_options() {
			return getRuleContext(Sorting_optionsContext.class,0);
		}
		public Scaling_optionsContext scaling_options() {
			return getRuleContext(Scaling_optionsContext.class,0);
		}
		public Non_repeatableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_repeatable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterNon_repeatable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitNon_repeatable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitNon_repeatable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_repeatableContext non_repeatable() throws RecognitionException {
		Non_repeatableContext _localctx = new Non_repeatableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_non_repeatable);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				sorting_options();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
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

	public static class ObligatorinessContext extends ParserRuleContext {
		public MandatoryContext mandatory() {
			return getRuleContext(MandatoryContext.class,0);
		}
		public OptionalContext optional() {
			return getRuleContext(OptionalContext.class,0);
		}
		public CdContext cd() {
			return getRuleContext(CdContext.class,0);
		}
		public ObligatorinessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obligatoriness; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterObligatoriness(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitObligatoriness(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitObligatoriness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObligatorinessContext obligatoriness() throws RecognitionException {
		ObligatorinessContext _localctx = new ObligatorinessContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_obligatoriness);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MANDATORY:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				mandatory();
				}
				break;
			case OPTIONAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				optional();
				}
				break;
			case CD:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				cd();
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

	public static class MandatoryContext extends ParserRuleContext {
		public TerminalNode MANDATORY() { return getToken(LabeledExprParser.MANDATORY, 0); }
		public MandatoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mandatory; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterMandatory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitMandatory(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitMandatory(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MandatoryContext mandatory() throws RecognitionException {
		MandatoryContext _localctx = new MandatoryContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mandatory);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(MANDATORY);
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

	public static class OptionalContext extends ParserRuleContext {
		public TerminalNode OPTIONAL() { return getToken(LabeledExprParser.OPTIONAL, 0); }
		public OptionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterOptional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitOptional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitOptional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionalContext optional() throws RecognitionException {
		OptionalContext _localctx = new OptionalContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_optional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(OPTIONAL);
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

	public static class CdContext extends ParserRuleContext {
		public TerminalNode CD() { return getToken(LabeledExprParser.CD, 0); }
		public List<TerminalNode> NEXT() { return getTokens(LabeledExprParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExprParser.NEXT, i);
		}
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public CdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterCd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitCd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitCd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CdContext cd() throws RecognitionException {
		CdContext _localctx = new CdContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(CD);
			setState(159);
			match(NEXT);
			setState(160);
			id();
			setState(161);
			match(NEXT);
			setState(162);
			id();
			setState(163);
			match(NEXT);
			setState(164);
			id();
			setState(165);
			match(NEXT);
			setState(166);
			match(T__4);
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

	public static class OptionContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(LabeledExprParser.LETTER, 0); }
		public TerminalNode NEXT() { return getToken(LabeledExprParser.NEXT, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(LETTER);
			setState(169);
			match(T__5);
			setState(170);
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

	public static class Free_textContext extends ParserRuleContext {
		public Free_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_free_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterFree_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitFree_text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitFree_text(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Free_textContext free_text() throws RecognitionException {
		Free_textContext _localctx = new Free_textContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_free_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__6);
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
		public NumericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterNumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitNumeric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitNumeric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericContext numeric() throws RecognitionException {
		NumericContext _localctx = new NumericContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_numeric);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__7);
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
		public List<TerminalNode> NEXT() { return getTokens(LabeledExprParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExprParser.NEXT, i);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public Single_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterSingle_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitSingle_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitSingle_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_choiceContext single_choice() throws RecognitionException {
		Single_choiceContext _localctx = new Single_choiceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_single_choice);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(T__8);
			setState(181); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(177);
					match(NEXT);
					setState(178);
					option();
					setState(179);
					sentence();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(183); 
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

	public static class Single_choice_inputContext extends ParserRuleContext {
		public Single_choice_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_choice_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterSingle_choice_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitSingle_choice_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitSingle_choice_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_choice_inputContext single_choice_input() throws RecognitionException {
		Single_choice_inputContext _localctx = new Single_choice_inputContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_single_choice_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__9);
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
		public List<TerminalNode> NEXT() { return getTokens(LabeledExprParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExprParser.NEXT, i);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public Multiple_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterMultiple_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitMultiple_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitMultiple_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choiceContext multiple_choice() throws RecognitionException {
		Multiple_choiceContext _localctx = new Multiple_choiceContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_multiple_choice);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__10);
			setState(192); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(188);
					match(NEXT);
					setState(189);
					option();
					setState(190);
					sentence();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(194); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class Multiple_choice_inputContext extends ParserRuleContext {
		public Multiple_choice_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterMultiple_choice_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitMultiple_choice_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitMultiple_choice_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_inputContext multiple_choice_input() throws RecognitionException {
		Multiple_choice_inputContext _localctx = new Multiple_choice_inputContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_multiple_choice_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__11);
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
		public List<TerminalNode> NEXT() { return getTokens(LabeledExprParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExprParser.NEXT, i);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public Sorting_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sorting_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterSorting_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitSorting_options(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitSorting_options(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sorting_optionsContext sorting_options() throws RecognitionException {
		Sorting_optionsContext _localctx = new Sorting_optionsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_sorting_options);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__12);
			setState(203); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(199);
					match(NEXT);
					setState(200);
					option();
					setState(201);
					sentence();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(205); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class Scaling_optionsContext extends ParserRuleContext {
		public List<TerminalNode> NEXT() { return getTokens(LabeledExprParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExprParser.NEXT, i);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public Scaling_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scaling_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterScaling_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitScaling_options(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitScaling_options(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scaling_optionsContext scaling_options() throws RecognitionException {
		Scaling_optionsContext _localctx = new Scaling_optionsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_scaling_options);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__13);
			setState(212); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(208);
					match(NEXT);
					setState(209);
					option();
					setState(210);
					sentence();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(214); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(216);
			match(NEXT);
			setState(217);
			match(T__14);
			setState(223); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(218);
					match(NEXT);
					setState(219);
					id();
					setState(220);
					match(NEXT);
					setState(221);
					sentence();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(225); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class TextContext extends ParserRuleContext {
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public List<TerminalNode> NEXT() { return getTokens(LabeledExprParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExprParser.NEXT, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(T__15);
			setState(228);
			sentence();
			setState(231); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(229);
				match(NEXT);
				setState(230);
				sentence();
				}
				}
				setState(233); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEXT );
			setState(235);
			match(T__15);
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
		public List<TerminalNode> NEXT() { return getTokens(LabeledExprParser.NEXT); }
		public TerminalNode NEXT(int i) {
			return getToken(LabeledExprParser.NEXT, i);
		}
		public List<TerminalNode> PONTUATION() { return getTokens(LabeledExprParser.PONTUATION); }
		public TerminalNode PONTUATION(int i) {
			return getToken(LabeledExprParser.PONTUATION, i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(237);
				word();
				}
				break;
			case DIGIT:
				{
				setState(238);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(249); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PONTUATION) {
					{
					setState(241);
					match(PONTUATION);
					}
				}

				setState(244);
				match(NEXT);
				setState(247);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LETTER:
					{
					setState(245);
					word();
					}
					break;
				case DIGIT:
					{
					setState(246);
					number();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(251); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PONTUATION || _la==NEXT );
			setState(253);
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
		public List<TerminalNode> LETTER() { return getTokens(LabeledExprParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(LabeledExprParser.LETTER, i);
		}
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_word);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(256); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(255);
					match(LETTER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(258); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		public TerminalNode EXCLAMATION() { return getToken(LabeledExprParser.EXCLAMATION, 0); }
		public TerminalNode INTERROGATION() { return getToken(LabeledExprParser.INTERROGATION, 0); }
		public TerminalNode DOT() { return getToken(LabeledExprParser.DOT, 0); }
		public Dot_markContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot_mark; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterDot_mark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitDot_mark(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitDot_mark(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dot_markContext dot_mark() throws RecognitionException {
		Dot_markContext _localctx = new Dot_markContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_dot_mark);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
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
		public List<TerminalNode> DIGIT() { return getTokens(LabeledExprParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(LabeledExprParser.DIGIT, i);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_number);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(263); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(262);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(265); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		"\u0004\u0001\u001a\u010c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001O\b\u0001\u000b"+
		"\u0001\f\u0001P\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u0003a\b\u0003\u000b"+
		"\u0003\f\u0003b\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0004\u0005p\b\u0005\u000b\u0005\f\u0005q\u0001\u0006\u0001\u0006"+
		"\u0004\u0006v\b\u0006\u000b\u0006\f\u0006w\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0003\f\u0088\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u0090\b\r\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0094\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0099"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0004\u0016\u00b6\b\u0016\u000b"+
		"\u0016\f\u0016\u00b7\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0004\u0018\u00c1\b\u0018\u000b\u0018\f"+
		"\u0018\u00c2\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0004\u001a\u00cc\b\u001a\u000b\u001a\f\u001a"+
		"\u00cd\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0004"+
		"\u001b\u00d5\b\u001b\u000b\u001b\f\u001b\u00d6\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0004\u001b"+
		"\u00e0\b\u001b\u000b\u001b\f\u001b\u00e1\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0004\u001c\u00e8\b\u001c\u000b\u001c\f\u001c\u00e9"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u00f0\b\u001d"+
		"\u0001\u001d\u0003\u001d\u00f3\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0003\u001d\u00f8\b\u001d\u0004\u001d\u00fa\b\u001d\u000b\u001d\f\u001d"+
		"\u00fb\u0001\u001d\u0001\u001d\u0001\u001e\u0004\u001e\u0101\b\u001e\u000b"+
		"\u001e\f\u001e\u0102\u0001\u001f\u0001\u001f\u0001 \u0004 \u0108\b \u000b"+
		" \f \u0109\u0001 \u0000\u0000!\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@\u0000\u0001"+
		"\u0001\u0000\u0011\u0013\u0105\u0000B\u0001\u0000\u0000\u0000\u0002N\u0001"+
		"\u0000\u0000\u0000\u0004R\u0001\u0000\u0000\u0000\u0006`\u0001\u0000\u0000"+
		"\u0000\bd\u0001\u0000\u0000\u0000\nl\u0001\u0000\u0000\u0000\fu\u0001"+
		"\u0000\u0000\u0000\u000e{\u0001\u0000\u0000\u0000\u0010}\u0001\u0000\u0000"+
		"\u0000\u0012\u007f\u0001\u0000\u0000\u0000\u0014\u0081\u0001\u0000\u0000"+
		"\u0000\u0016\u0083\u0001\u0000\u0000\u0000\u0018\u0087\u0001\u0000\u0000"+
		"\u0000\u001a\u008f\u0001\u0000\u0000\u0000\u001c\u0093\u0001\u0000\u0000"+
		"\u0000\u001e\u0098\u0001\u0000\u0000\u0000 \u009a\u0001\u0000\u0000\u0000"+
		"\"\u009c\u0001\u0000\u0000\u0000$\u009e\u0001\u0000\u0000\u0000&\u00a8"+
		"\u0001\u0000\u0000\u0000(\u00ac\u0001\u0000\u0000\u0000*\u00ae\u0001\u0000"+
		"\u0000\u0000,\u00b0\u0001\u0000\u0000\u0000.\u00b9\u0001\u0000\u0000\u0000"+
		"0\u00bb\u0001\u0000\u0000\u00002\u00c4\u0001\u0000\u0000\u00004\u00c6"+
		"\u0001\u0000\u0000\u00006\u00cf\u0001\u0000\u0000\u00008\u00e3\u0001\u0000"+
		"\u0000\u0000:\u00ef\u0001\u0000\u0000\u0000<\u0100\u0001\u0000\u0000\u0000"+
		">\u0104\u0001\u0000\u0000\u0000@\u0107\u0001\u0000\u0000\u0000BC\u0003"+
		"\n\u0005\u0000CD\u0005\u0017\u0000\u0000DE\u0003\f\u0006\u0000EF\u0005"+
		"\u0017\u0000\u0000FG\u0003\u000e\u0007\u0000GH\u0005\u0017\u0000\u0000"+
		"HI\u0005\u0001\u0000\u0000IJ\u0005\u0017\u0000\u0000JK\u0003\u0002\u0001"+
		"\u0000KL\u0003\u0014\n\u0000L\u0001\u0001\u0000\u0000\u0000MO\u0003\u0004"+
		"\u0002\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000Q\u0003\u0001\u0000\u0000"+
		"\u0000RS\u0005\u0002\u0000\u0000ST\u0003\n\u0005\u0000TU\u0005\u0017\u0000"+
		"\u0000UV\u0003\f\u0006\u0000VW\u0005\u0017\u0000\u0000WX\u0003\u0010\b"+
		"\u0000XY\u0005\u0017\u0000\u0000YZ\u0003\u001e\u000f\u0000Z[\u0005\u0017"+
		"\u0000\u0000[\\\u0003\u0006\u0003\u0000\\]\u0005\u0003\u0000\u0000]^\u0005"+
		"\u0017\u0000\u0000^\u0005\u0001\u0000\u0000\u0000_a\u0003\b\u0004\u0000"+
		"`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000c\u0007\u0001\u0000\u0000\u0000de\u0005"+
		"\u0004\u0000\u0000ef\u0003\f\u0006\u0000fg\u0005\u0017\u0000\u0000gh\u0003"+
		"\u0012\t\u0000hi\u0005\u0017\u0000\u0000ij\u0003\u0016\u000b\u0000jk\u0005"+
		"\u0017\u0000\u0000k\t\u0001\u0000\u0000\u0000lo\u0005\u0017\u0000\u0000"+
		"mp\u0003@ \u0000np\u0003<\u001e\u0000om\u0001\u0000\u0000\u0000on\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000r\u000b\u0001\u0000\u0000\u0000sv\u0003@ \u0000"+
		"tv\u0003<\u001e\u0000us\u0001\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000"+
		"vw\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000yz\u0005\u0016\u0000\u0000z\r\u0001\u0000"+
		"\u0000\u0000{|\u00038\u001c\u0000|\u000f\u0001\u0000\u0000\u0000}~\u0003"+
		":\u001d\u0000~\u0011\u0001\u0000\u0000\u0000\u007f\u0080\u0003:\u001d"+
		"\u0000\u0080\u0013\u0001\u0000\u0000\u0000\u0081\u0082\u00038\u001c\u0000"+
		"\u0082\u0015\u0001\u0000\u0000\u0000\u0083\u0084\u0003\u0018\f\u0000\u0084"+
		"\u0017\u0001\u0000\u0000\u0000\u0085\u0088\u0003\u001a\r\u0000\u0086\u0088"+
		"\u0003\u001c\u000e\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0086"+
		"\u0001\u0000\u0000\u0000\u0088\u0019\u0001\u0000\u0000\u0000\u0089\u0090"+
		"\u0003(\u0014\u0000\u008a\u0090\u0003*\u0015\u0000\u008b\u0090\u0003."+
		"\u0017\u0000\u008c\u0090\u00032\u0019\u0000\u008d\u0090\u0003,\u0016\u0000"+
		"\u008e\u0090\u00030\u0018\u0000\u008f\u0089\u0001\u0000\u0000\u0000\u008f"+
		"\u008a\u0001\u0000\u0000\u0000\u008f\u008b\u0001\u0000\u0000\u0000\u008f"+
		"\u008c\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u008e\u0001\u0000\u0000\u0000\u0090\u001b\u0001\u0000\u0000\u0000\u0091"+
		"\u0094\u00034\u001a\u0000\u0092\u0094\u00036\u001b\u0000\u0093\u0091\u0001"+
		"\u0000\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u001d\u0001"+
		"\u0000\u0000\u0000\u0095\u0099\u0003 \u0010\u0000\u0096\u0099\u0003\""+
		"\u0011\u0000\u0097\u0099\u0003$\u0012\u0000\u0098\u0095\u0001\u0000\u0000"+
		"\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0097\u0001\u0000\u0000"+
		"\u0000\u0099\u001f\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0018\u0000"+
		"\u0000\u009b!\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0019\u0000\u0000"+
		"\u009d#\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u001a\u0000\u0000\u009f"+
		"\u00a0\u0005\u0017\u0000\u0000\u00a0\u00a1\u0003\f\u0006\u0000\u00a1\u00a2"+
		"\u0005\u0017\u0000\u0000\u00a2\u00a3\u0003\f\u0006\u0000\u00a3\u00a4\u0005"+
		"\u0017\u0000\u0000\u00a4\u00a5\u0003\f\u0006\u0000\u00a5\u00a6\u0005\u0017"+
		"\u0000\u0000\u00a6\u00a7\u0005\u0005\u0000\u0000\u00a7%\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a9\u0005\u0015\u0000\u0000\u00a9\u00aa\u0005\u0006\u0000"+
		"\u0000\u00aa\u00ab\u0005\u0017\u0000\u0000\u00ab\'\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0005\u0007\u0000\u0000\u00ad)\u0001\u0000\u0000\u0000\u00ae"+
		"\u00af\u0005\b\u0000\u0000\u00af+\u0001\u0000\u0000\u0000\u00b0\u00b5"+
		"\u0005\t\u0000\u0000\u00b1\u00b2\u0005\u0017\u0000\u0000\u00b2\u00b3\u0003"+
		"&\u0013\u0000\u00b3\u00b4\u0003:\u001d\u0000\u00b4\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b1\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b8-\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\n\u0000\u0000"+
		"\u00ba/\u0001\u0000\u0000\u0000\u00bb\u00c0\u0005\u000b\u0000\u0000\u00bc"+
		"\u00bd\u0005\u0017\u0000\u0000\u00bd\u00be\u0003&\u0013\u0000\u00be\u00bf"+
		"\u0003:\u001d\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00bc\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c31\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0005\f\u0000\u0000\u00c53\u0001\u0000\u0000"+
		"\u0000\u00c6\u00cb\u0005\r\u0000\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000"+
		"\u00c8\u00c9\u0003&\u0013\u0000\u00c9\u00ca\u0003:\u001d\u0000\u00ca\u00cc"+
		"\u0001\u0000\u0000\u0000\u00cb\u00c7\u0001\u0000\u0000\u0000\u00cc\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce"+
		"\u0001\u0000\u0000\u0000\u00ce5\u0001\u0000\u0000\u0000\u00cf\u00d4\u0005"+
		"\u000e\u0000\u0000\u00d0\u00d1\u0005\u0017\u0000\u0000\u00d1\u00d2\u0003"+
		"&\u0013\u0000\u00d2\u00d3\u0003:\u001d\u0000\u00d3\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d0\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u0017\u0000"+
		"\u0000\u00d9\u00df\u0005\u000f\u0000\u0000\u00da\u00db\u0005\u0017\u0000"+
		"\u0000\u00db\u00dc\u0003\f\u0006\u0000\u00dc\u00dd\u0005\u0017\u0000\u0000"+
		"\u00dd\u00de\u0003:\u001d\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df"+
		"\u00da\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1"+
		"\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2"+
		"7\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u0010\u0000\u0000\u00e4\u00e7"+
		"\u0003:\u001d\u0000\u00e5\u00e6\u0005\u0017\u0000\u0000\u00e6\u00e8\u0003"+
		":\u001d\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005\u0010"+
		"\u0000\u0000\u00ec9\u0001\u0000\u0000\u0000\u00ed\u00f0\u0003<\u001e\u0000"+
		"\u00ee\u00f0\u0003@ \u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00ee"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f9\u0001\u0000\u0000\u0000\u00f1\u00f3"+
		"\u0005\u0016\u0000\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f7"+
		"\u0005\u0017\u0000\u0000\u00f5\u00f8\u0003<\u001e\u0000\u00f6\u00f8\u0003"+
		"@ \u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f8\u00fa\u0001\u0000\u0000\u0000\u00f9\u00f2\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fe\u0003>\u001f\u0000\u00fe;\u0001\u0000\u0000\u0000\u00ff"+
		"\u0101\u0005\u0015\u0000\u0000\u0100\u00ff\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0102"+
		"\u0103\u0001\u0000\u0000\u0000\u0103=\u0001\u0000\u0000\u0000\u0104\u0105"+
		"\u0007\u0000\u0000\u0000\u0105?\u0001\u0000\u0000\u0000\u0106\u0108\u0005"+
		"\u0014\u0000\u0000\u0107\u0106\u0001\u0000\u0000\u0000\u0108\u0109\u0001"+
		"\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001"+
		"\u0000\u0000\u0000\u010aA\u0001\u0000\u0000\u0000\u0016Pboquw\u0087\u008f"+
		"\u0093\u0098\u00b7\u00c2\u00cd\u00d6\u00e1\u00e9\u00ef\u00f2\u00f7\u00fb"+
		"\u0102\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}