import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class SemanticVisitor<T> extends calBaseVisitor<T>{
    private SymbolTable symbolTable;
    public SemanticVisitor() {
        symbolTable = new SymbolTable();
        symbolTable.openScope();
    }
    @Override
    public T visitCondition(calParser.ConditionContext ctx){
        //1: check that condition compares integer types
        try {
            if (ctx.comp_op().getText() != null) {
                if(ctx.expression(0).getText().toLowerCase().equals("true") || ctx.expression(0).getText().toLowerCase().equals("false") || ctx.expression(1).getText().toLowerCase().equals("true") || ctx.expression(1).getText().toLowerCase().equals("false") || ctx.expression(0).getText().toLowerCase().equals("void") || ctx.expression(1).getText().toLowerCase().equals("void"))
                {
                    System.out.println("Invalid comparison operation. Boolean/void type not supported for comparisons.");
                    System.exit(-1);
                }
                else if(symbolTable.getSymbol(ctx.expression(0).getText()) != null && symbolTable.getSymbol(ctx.expression(0).getText()).type.toLowerCase().equals("boolean")){
                    System.out.println("Invalid comparison operation. Boolean/void type not supported for comparisons.");
                    System.exit(-1);
                }
                else if(symbolTable.getSymbol(ctx.expression(1).getText()) != null && symbolTable.getSymbol(ctx.expression(1).getText()).type.toLowerCase().equals("boolean")){
                    System.out.println("Invalid comparison operation. Boolean/void type not supported for comparisons.");
                    System.exit(-1);
                }
                visitChildren(ctx.expression(0));
                visitChildren(ctx.expression(1));
            }
        }
        catch(Exception e){}
        return visitChildren(ctx);
    }
    @Override
    public T visitExpression1(calParser.Expression1Context ctx) {
        //1: Determine if both sides of the bin op are numbers
        try {
            Integer.parseInt(ctx.children.get(0).getText());
        }
        catch (Exception e) {
            if(symbolTable.getSymbol(ctx.children.get(0).getText()) == null && !ctx.children.get(0).getText().substring(0,1).equals("(")) {
                System.out.println("Non-numeric value assigned in arithmetic operation or variable provided not defined in scope.");
                System.exit(-1);
            }
        }
        try {
            Integer.parseInt(ctx.children.get(2).getText());
        }
        catch (Exception e) {
            if(symbolTable.getSymbol(ctx.children.get(2).getText()) == null && !ctx.children.get(2).getText().substring(0,1).equals("(")) {
                System.out.println("Non-numeric value assigned in arithmetic operation or variable provided not defined in scope.");
                System.exit(-1);
            }
        }
        //2: check that functions have correct return type
        try {
            String x = ctx.children.get(2).getText().split("\\(")[1];
            if(!symbolTable.getSymbol(x).cvf.equals("integer")) {
                System.out.println("Function " + x + " returns a type not supported for arithmetic operations.");
                System.exit(-1);
            }
        }
        catch (Exception e) { }
        //3: check if any children are variables with callflag yes1 set to yes2
        if(symbolTable.getSymbol(ctx.children.get(0).getText()) != null) {
            symbolTable.getSymbol(ctx.children.get(0).getText()).callflag = "Yes2";
        }
        else if(symbolTable.getSymbol(ctx.children.get(2).getText()) != null) {
            symbolTable.getSymbol(ctx.children.get(2).getText()).callflag = "Yes2";
        }
        return visitChildren(ctx);
    }
    @Override
    public T visitExpression3(calParser.Expression3Context ctx) {
        //1: Check that function exists in scope
        if(symbolTable.getSymbol(ctx.Id().toString()) == null) {
            System.out.println("Function " + ctx.Id().toString() + " has not been defined in current scope.");
            System.exit(-1);
        }
        //2: check that number of arguments provided matches number required
        String [] l = ctx.arg_list().getText().split(",");
        String [] l2 = symbolTable.getSymbol(ctx.Id().toString()).type.split(",");
        if(l.length != l2.length) {
            System.out.println("Incorrect number of arguments for function " + ctx.Id().getText());
            System.exit(-1);
        }
        //3: Check that args provided have been defined in scope
        for(String var : l) {
            //check if in scope
            if(symbolTable.getSymbol(var) == null) {
                System.out.println("Argument " + var + " used for function " + ctx.Id().getText() + " is not defined in the current scope.");
                System.exit(-1);
            }
        }
        //4: If function hasn't been used yet set call flag
        String flag = symbolTable.getSymbol(ctx.Id().toString()).callflag;
        if(flag.equals("No")) {
            symbolTable.getSymbol(ctx.Id().toString()).callflag = "Yes";
        }
        //5: for arguments check if any have callflag yes1 and set to yes2
        for(String var : l) {
            if(!symbolTable.getSymbol(var).callflag.equals("Yes2"))
                symbolTable.getSymbol(var).callflag = "Yes2";
        }
        return visitChildren(ctx);
    }
    @Override
    public T visitStatement2(calParser.Statement2Context ctx) {
        //1: Check that function exists in scope
        if(symbolTable.getSymbol(ctx.Id().toString()) == null) {
            System.out.println("Function " + ctx.Id().toString() + " has not been defined in current scope.");
            System.exit(-1);
        }
        //2: check that number of arguments provided matches number required
        String [] l = ctx.arg_list().getText().split(",");
        String [] l2 = symbolTable.getSymbol(ctx.Id().toString()).type.split(",");
        if(l.length != l2.length) {
            System.out.println("Incorrect number of arguments for function " + ctx.Id().getText());
            System.exit(-1);
        }
        //3: Check that args provided have been defined in scope
        for(String var : l) {
            if(symbolTable.getSymbol(var) == null) {
                System.out.println("Argument " + var + " used for function " + ctx.Id().getText() + " is not defined in the current scope.");
                System.exit(-1);
            }
        }
        //4: If function hasn't been used yet set call flag
        String flag = symbolTable.getSymbol(ctx.Id().toString()).callflag;
        if(flag.equals("No"))
        {
            symbolTable.getSymbol(ctx.Id().toString()).callflag = "Yes";
        }
        //5: for arguments check if any have callflag yes1 and set to yes2
        for(String var : l) {
            if(!symbolTable.getSymbol(var).callflag.equals("Yes2"))
                symbolTable.getSymbol(var).callflag = "Yes2";
        }
        return visitChildren(ctx);
    }
    @Override
    public T visitFunction(calParser.FunctionContext ctx) {
        //1: Add a function to the scope and raise the scope level
        String [] args = {};
        if(ctx.parameter_list().getText() != null) {
            args = ctx.parameter_list().nemp_parameter_list().getText().split(",");
        }
        StringBuilder out = new StringBuilder();
        for(String s : args) {
            String [] s2 = s.split(":");
            out.append(s2[1] + ",");
        }
        symbolTable.addSymbol(new Symbol(ctx.Id().getText(), out.toString(), ctx.type().getText()));
        symbolTable.openScope();
        return visitChildren(ctx);
    }
    @Override
    public T visitStatement1(calParser.Statement1Context ctx) {
        //1: Check that ID is in scope
        if(symbolTable.getSymbol(ctx.Id().getText()) == null) {
            System.out.println("The variable being assigned " + ctx.Id().getText() + " is not defined in the current scope.");
            System.exit(-1);
        }
        //2: Check what is being assigned to ID
        String x = ctx.expression().getChild(0).getText();
        if(symbolTable.getSymbol(x) != null && !symbolTable.getSymbol(x).cvf.equals("Variable") && !symbolTable.getSymbol(x).cvf.equals("Constant")) {
            String type1 = symbolTable.getSymbol(x).cvf;
            String type2 = symbolTable.getSymbol(ctx.Id().getText()).type;
            if(!type1.equals(type2)) {
                System.out.println("Function " + x + " whose value is being assigned to variable " + ctx.Id().getText() + " does not produce the correct type when called.");
                System.exit(-1);
            }
        }
        else {
            visitChildren(ctx); // if not function visit children to ensure all values fit
        }
        //3: set flag that variable has been assigned a value step 1/2
        Symbol current = symbolTable.getSymbol(ctx.Id().toString());
        if(current.callflag.equals("No")) {
            symbolTable.getSymbol(ctx.Id().toString()).callflag = "Yes1";
        }
        return visitChildren(ctx);
    }
    @Override
    public T visitEnd(calParser.EndContext ctx) {
        //1: check that every function and variable in top scope have been used and close that scope
        checkFunctionUsage();
        checkVariableUsage();
        symbolTable.closeScope();
        //2: if parent of end is main need to lower scope again to check functions in global scope have been used
        /*Will say variable is unused and unassigned if variable was redefined in a higher scope
        i.e i is defined globally and i is defined in main
        i is then assigned and used in the scope of main
        this would result in the global instance of i returning
        Warning: Variable i is defined without being assigned or used.
        this is referring to the i that was defined in the global context.*/
        if(ctx.getParent().getText().substring(0,4).equals("main")) {
            checkFunctionUsage();
            checkVariableUsage();
            symbolTable.closeScope();
        }
        return visitChildren(ctx);
    }
    public void checkVariableUsage() {//check variables in uin current scope have been used
        for(Symbol s : symbolTable.stack.peek().values()) {
            if(s.cvf.equals("Variable") && s.callflag.equals("No")) {
                System.out.println("Warning: Variable " + s.id + " is defined without being assigned or used.");
            }
            else if(s.cvf.equals("Variable") && s.callflag.equals("Yes1")) {
                System.out.println("Warning: Variable " + s.id + " is defined and assigned but is not used.");
            }
        }
    }
    public void checkFunctionUsage() {//check all functions have been used
        for(Symbol s : symbolTable.stack.peek().values()) {
            if(!s.cvf.equals("Variable") && !s.equals("Constant") && s.callflag.equals("No")) {
                System.out.println("Warning: Function " + s.id + " defined without being called.");
            }
        }
    }
    @Override
    public T visitProgram(calParser.ProgramContext ctx) {
        symbolTable.openScope();
        return visitChildren(ctx);
    }
    @Override
    public T visitVar_decl(calParser.Var_declContext ctx) {
        //1: If a variable is already declared in scope raises error otherwise adds variable to scope
        if(symbolTable.inLocal(ctx.Id().getText())) {
            System.out.println("Variable " + ctx.Id().getText() + " defined multiple times in current scope.");
            System.exit(-1);
        }
        symbolTable.addSymbol(new Symbol(ctx.Id().getText(), ctx.type().getText(), "Variable"));
        return visitChildren(ctx);
    }
    @Override
    public T visitConst_decl(calParser.Const_declContext ctx) {
        //1: If a constant is already declared in scope raises error otherwise adds variable to scope
        if(symbolTable.inLocal(ctx.Id().getText())) {
            System.out.println("Variable " + ctx.Id().getText() + " defined multiple times in current scope.");
            System.exit(-1);
        }
        symbolTable.addSymbol(new Symbol(ctx.Id().getText(), ctx.type().getText(), "Constant"));
        return visitChildren(ctx);
    }
    @Override
    public T visitMain(calParser.MainContext ctx) {
        symbolTable.openScope();
        return visitChildren(ctx);
    }
}
