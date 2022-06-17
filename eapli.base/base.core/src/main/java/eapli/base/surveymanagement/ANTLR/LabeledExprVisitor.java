// Generated from C:/Users/PC/OneDrive - Instituto Superior de Engenharia do Porto/Desktop/Gustavo/ISEP/LAPR4/eapli.base/base.core/src/main/java/eapli/base/surveymanagement/ANTLR\LabeledExpr.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LabeledExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LabeledExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#questionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire(LabeledExprParser.QuestionnaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#list_of_sections}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_of_sections(LabeledExprParser.List_of_sectionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handleSection}
	 * labeled alternative in {@link LabeledExprParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandleSection(LabeledExprParser.HandleSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(LabeledExprParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#question_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion_struct(LabeledExprParser.Question_structContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printTitle}
	 * labeled alternative in {@link LabeledExprParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintTitle(LabeledExprParser.PrintTitleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printId}
	 * labeled alternative in {@link LabeledExprParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintId(LabeledExprParser.PrintIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link LabeledExprParser#welcome_message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(LabeledExprParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#section_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection_description(LabeledExprParser.Section_descriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(LabeledExprParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#final_message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinal_message(LabeledExprParser.Final_messageContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LabeledExprParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#repeatability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatability(LabeledExprParser.RepeatabilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#repeatable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatable(LabeledExprParser.RepeatableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#non_repeatable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_repeatable(LabeledExprParser.Non_repeatableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#obligatoriness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObligatoriness(LabeledExprParser.ObligatorinessContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#mandatory}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMandatory(LabeledExprParser.MandatoryContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#optional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptional(LabeledExprParser.OptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#cd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCd(LabeledExprParser.CdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(LabeledExprParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#free_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFree_text(LabeledExprParser.Free_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#numeric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric(LabeledExprParser.NumericContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#single_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_choice(LabeledExprParser.Single_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#single_choice_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_choice_input(LabeledExprParser.Single_choice_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#multiple_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice(LabeledExprParser.Multiple_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#multiple_choice_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_input(LabeledExprParser.Multiple_choice_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#sorting_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSorting_options(LabeledExprParser.Sorting_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#scaling_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScaling_options(LabeledExprParser.Scaling_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(LabeledExprParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(LabeledExprParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(LabeledExprParser.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#dot_mark}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot_mark(LabeledExprParser.Dot_markContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(LabeledExprParser.NumberContext ctx);
}