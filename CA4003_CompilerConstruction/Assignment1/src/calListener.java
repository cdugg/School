// Generated from cal.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link calParser}.
 */
public interface calListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link calParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(calParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(calParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#decl_list}.
	 * @param ctx the parse tree
	 */
	void enterDecl_list(calParser.Decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#decl_list}.
	 * @param ctx the parse tree
	 */
	void exitDecl_list(calParser.Decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(calParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(calParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(calParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(calParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#const_decl}.
	 * @param ctx the parse tree
	 */
	void enterConst_decl(calParser.Const_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#const_decl}.
	 * @param ctx the parse tree
	 */
	void exitConst_decl(calParser.Const_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#function_list}.
	 * @param ctx the parse tree
	 */
	void enterFunction_list(calParser.Function_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#function_list}.
	 * @param ctx the parse tree
	 */
	void exitFunction_list(calParser.Function_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(calParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(calParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(calParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(calParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(calParser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(calParser.Parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#nemp_parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterNemp_parameter_list(calParser.Nemp_parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#nemp_parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitNemp_parameter_list(calParser.Nemp_parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(calParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(calParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void enterStatement_block(calParser.Statement_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void exitStatement_block(calParser.Statement_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(calParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(calParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(calParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(calParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#binary_arith_op}.
	 * @param ctx the parse tree
	 */
	void enterBinary_arith_op(calParser.Binary_arith_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#binary_arith_op}.
	 * @param ctx the parse tree
	 */
	void exitBinary_arith_op(calParser.Binary_arith_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#frag}.
	 * @param ctx the parse tree
	 */
	void enterFrag(calParser.FragContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#frag}.
	 * @param ctx the parse tree
	 */
	void exitFrag(calParser.FragContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(calParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(calParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterComp_op(calParser.Comp_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitComp_op(calParser.Comp_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(calParser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(calParser.Arg_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link calParser#nemp_arg_list}.
	 * @param ctx the parse tree
	 */
	void enterNemp_arg_list(calParser.Nemp_arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link calParser#nemp_arg_list}.
	 * @param ctx the parse tree
	 */
	void exitNemp_arg_list(calParser.Nemp_arg_listContext ctx);
}