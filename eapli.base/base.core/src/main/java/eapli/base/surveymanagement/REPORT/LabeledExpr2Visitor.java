// Generated from C:/Users/marga/OneDrive - ISEP/ISEP/2ºANO/lei21_22_s4_2db_01/eapli.base/base.core/src/main/java/eapli/base/surveymanagement/REPORT\LabeledExpr2.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.REPORT;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LabeledExpr2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LabeledExpr2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code handleClients}
	 * labeled alternative in {@link LabeledExpr2Parser#survey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandleClients(LabeledExpr2Parser.HandleClientsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#list_of_clients}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_of_clients(LabeledExpr2Parser.List_of_clientsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#client}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClient(LabeledExpr2Parser.ClientContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#list_of_sections}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_of_sections(LabeledExpr2Parser.List_of_sectionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(LabeledExpr2Parser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(LabeledExpr2Parser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#question_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion_struct(LabeledExpr2Parser.Question_structContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(LabeledExpr2Parser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(LabeledExpr2Parser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LabeledExpr2Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#free_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFree_text(LabeledExpr2Parser.Free_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#numeric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric(LabeledExpr2Parser.NumericContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#single_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_choice(LabeledExpr2Parser.Single_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#multiple_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice(LabeledExpr2Parser.Multiple_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#sorting_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSorting_options(LabeledExpr2Parser.Sorting_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#scaling_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScaling_options(LabeledExpr2Parser.Scaling_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(LabeledExpr2Parser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(LabeledExpr2Parser.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#dot_mark}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot_mark(LabeledExpr2Parser.Dot_markContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExpr2Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(LabeledExpr2Parser.NumberContext ctx);
}