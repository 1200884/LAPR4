// Generated from C:/Users/marga/OneDrive - ISEP/ISEP/2ºANO/lei21_22_s4_2db_01/eapli.base/base.core/src/main/java/eapli/base/surveymanagement\LabeledExpr.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LabeledExprParser}.
 */
public interface LabeledExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(LabeledExprParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(LabeledExprParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#list_of_sections}.
	 * @param ctx the parse tree
	 */
	void enterList_of_sections(LabeledExprParser.List_of_sectionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#list_of_sections}.
	 * @param ctx the parse tree
	 */
	void exitList_of_sections(LabeledExprParser.List_of_sectionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(LabeledExprParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(LabeledExprParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(LabeledExprParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(LabeledExprParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#question_struct}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_struct(LabeledExprParser.Question_structContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#question_struct}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_struct(LabeledExprParser.Question_structContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(LabeledExprParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(LabeledExprParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(LabeledExprParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(LabeledExprParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#welcome_message}.
	 * @param ctx the parse tree
	 */
	void enterWelcome_message(LabeledExprParser.Welcome_messageContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#welcome_message}.
	 * @param ctx the parse tree
	 */
	void exitWelcome_message(LabeledExprParser.Welcome_messageContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#section_description}.
	 * @param ctx the parse tree
	 */
	void enterSection_description(LabeledExprParser.Section_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#section_description}.
	 * @param ctx the parse tree
	 */
	void exitSection_description(LabeledExprParser.Section_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(LabeledExprParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(LabeledExprParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#final_message}.
	 * @param ctx the parse tree
	 */
	void enterFinal_message(LabeledExprParser.Final_messageContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#final_message}.
	 * @param ctx the parse tree
	 */
	void exitFinal_message(LabeledExprParser.Final_messageContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LabeledExprParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LabeledExprParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#repeatability}.
	 * @param ctx the parse tree
	 */
	void enterRepeatability(LabeledExprParser.RepeatabilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#repeatability}.
	 * @param ctx the parse tree
	 */
	void exitRepeatability(LabeledExprParser.RepeatabilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#repeatable}.
	 * @param ctx the parse tree
	 */
	void enterRepeatable(LabeledExprParser.RepeatableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#repeatable}.
	 * @param ctx the parse tree
	 */
	void exitRepeatable(LabeledExprParser.RepeatableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#non_repeatable}.
	 * @param ctx the parse tree
	 */
	void enterNon_repeatable(LabeledExprParser.Non_repeatableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#non_repeatable}.
	 * @param ctx the parse tree
	 */
	void exitNon_repeatable(LabeledExprParser.Non_repeatableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void enterObligatoriness(LabeledExprParser.ObligatorinessContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void exitObligatoriness(LabeledExprParser.ObligatorinessContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#mandatory}.
	 * @param ctx the parse tree
	 */
	void enterMandatory(LabeledExprParser.MandatoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#mandatory}.
	 * @param ctx the parse tree
	 */
	void exitMandatory(LabeledExprParser.MandatoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#optional}.
	 * @param ctx the parse tree
	 */
	void enterOptional(LabeledExprParser.OptionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#optional}.
	 * @param ctx the parse tree
	 */
	void exitOptional(LabeledExprParser.OptionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#cd}.
	 * @param ctx the parse tree
	 */
	void enterCd(LabeledExprParser.CdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#cd}.
	 * @param ctx the parse tree
	 */
	void exitCd(LabeledExprParser.CdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#free_text}.
	 * @param ctx the parse tree
	 */
	void enterFree_text(LabeledExprParser.Free_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#free_text}.
	 * @param ctx the parse tree
	 */
	void exitFree_text(LabeledExprParser.Free_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#numeric}.
	 * @param ctx the parse tree
	 */
	void enterNumeric(LabeledExprParser.NumericContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#numeric}.
	 * @param ctx the parse tree
	 */
	void exitNumeric(LabeledExprParser.NumericContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#single_choice}.
	 * @param ctx the parse tree
	 */
	void enterSingle_choice(LabeledExprParser.Single_choiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#single_choice}.
	 * @param ctx the parse tree
	 */
	void exitSingle_choice(LabeledExprParser.Single_choiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#single_choice_input}.
	 * @param ctx the parse tree
	 */
	void enterSingle_choice_input(LabeledExprParser.Single_choice_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#single_choice_input}.
	 * @param ctx the parse tree
	 */
	void exitSingle_choice_input(LabeledExprParser.Single_choice_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#multiple_choice}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice(LabeledExprParser.Multiple_choiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#multiple_choice}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice(LabeledExprParser.Multiple_choiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#multiple_choice_input}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_input(LabeledExprParser.Multiple_choice_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#multiple_choice_input}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_input(LabeledExprParser.Multiple_choice_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#sorting_options}.
	 * @param ctx the parse tree
	 */
	void enterSorting_options(LabeledExprParser.Sorting_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#sorting_options}.
	 * @param ctx the parse tree
	 */
	void exitSorting_options(LabeledExprParser.Sorting_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#scaling_options}.
	 * @param ctx the parse tree
	 */
	void enterScaling_options(LabeledExprParser.Scaling_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#scaling_options}.
	 * @param ctx the parse tree
	 */
	void exitScaling_options(LabeledExprParser.Scaling_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(LabeledExprParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(LabeledExprParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(LabeledExprParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(LabeledExprParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(LabeledExprParser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(LabeledExprParser.WordContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#dot_mark}.
	 * @param ctx the parse tree
	 */
	void enterDot_mark(LabeledExprParser.Dot_markContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#dot_mark}.
	 * @param ctx the parse tree
	 */
	void exitDot_mark(LabeledExprParser.Dot_markContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(LabeledExprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(LabeledExprParser.NumberContext ctx);
}