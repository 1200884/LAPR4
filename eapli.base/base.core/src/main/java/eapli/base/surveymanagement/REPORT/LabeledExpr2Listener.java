// Generated from C:/Users/marga/OneDrive - ISEP/ISEP/2ºANO/lei21_22_s4_2db_01/eapli.base/base.core/src/main/java/eapli/base/surveymanagement/REPORT\LabeledExpr2.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.REPORT;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LabeledExpr2Parser}.
 */
public interface LabeledExpr2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code handleClients}
	 * labeled alternative in {@link LabeledExpr2Parser#survey}.
	 * @param ctx the parse tree
	 */
	void enterHandleClients(LabeledExpr2Parser.HandleClientsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code handleClients}
	 * labeled alternative in {@link LabeledExpr2Parser#survey}.
	 * @param ctx the parse tree
	 */
	void exitHandleClients(LabeledExpr2Parser.HandleClientsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#list_of_clients}.
	 * @param ctx the parse tree
	 */
	void enterList_of_clients(LabeledExpr2Parser.List_of_clientsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#list_of_clients}.
	 * @param ctx the parse tree
	 */
	void exitList_of_clients(LabeledExpr2Parser.List_of_clientsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#client}.
	 * @param ctx the parse tree
	 */
	void enterClient(LabeledExpr2Parser.ClientContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#client}.
	 * @param ctx the parse tree
	 */
	void exitClient(LabeledExpr2Parser.ClientContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#list_of_sections}.
	 * @param ctx the parse tree
	 */
	void enterList_of_sections(LabeledExpr2Parser.List_of_sectionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#list_of_sections}.
	 * @param ctx the parse tree
	 */
	void exitList_of_sections(LabeledExpr2Parser.List_of_sectionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(LabeledExpr2Parser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(LabeledExpr2Parser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(LabeledExpr2Parser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(LabeledExpr2Parser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#question_struct}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_struct(LabeledExpr2Parser.Question_structContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#question_struct}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_struct(LabeledExpr2Parser.Question_structContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(LabeledExpr2Parser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(LabeledExpr2Parser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(LabeledExpr2Parser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(LabeledExpr2Parser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LabeledExpr2Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LabeledExpr2Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#free_text}.
	 * @param ctx the parse tree
	 */
	void enterFree_text(LabeledExpr2Parser.Free_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#free_text}.
	 * @param ctx the parse tree
	 */
	void exitFree_text(LabeledExpr2Parser.Free_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#numeric}.
	 * @param ctx the parse tree
	 */
	void enterNumeric(LabeledExpr2Parser.NumericContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#numeric}.
	 * @param ctx the parse tree
	 */
	void exitNumeric(LabeledExpr2Parser.NumericContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#single_choice}.
	 * @param ctx the parse tree
	 */
	void enterSingle_choice(LabeledExpr2Parser.Single_choiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#single_choice}.
	 * @param ctx the parse tree
	 */
	void exitSingle_choice(LabeledExpr2Parser.Single_choiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#multiple_choice}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice(LabeledExpr2Parser.Multiple_choiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#multiple_choice}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice(LabeledExpr2Parser.Multiple_choiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#sorting_options}.
	 * @param ctx the parse tree
	 */
	void enterSorting_options(LabeledExpr2Parser.Sorting_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#sorting_options}.
	 * @param ctx the parse tree
	 */
	void exitSorting_options(LabeledExpr2Parser.Sorting_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#scaling_options}.
	 * @param ctx the parse tree
	 */
	void enterScaling_options(LabeledExpr2Parser.Scaling_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#scaling_options}.
	 * @param ctx the parse tree
	 */
	void exitScaling_options(LabeledExpr2Parser.Scaling_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(LabeledExpr2Parser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(LabeledExpr2Parser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(LabeledExpr2Parser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(LabeledExpr2Parser.WordContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#dot_mark}.
	 * @param ctx the parse tree
	 */
	void enterDot_mark(LabeledExpr2Parser.Dot_markContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#dot_mark}.
	 * @param ctx the parse tree
	 */
	void exitDot_mark(LabeledExpr2Parser.Dot_markContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExpr2Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(LabeledExpr2Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExpr2Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(LabeledExpr2Parser.NumberContext ctx);
}