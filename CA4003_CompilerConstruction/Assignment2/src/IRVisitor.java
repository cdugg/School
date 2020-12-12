import java.util.Arrays;

public class IRVisitor<T> extends calBaseVisitor<T>{
    public SymbolTable symbolTable;
    private int indent = 0;
    public IRVisitor() {
        symbolTable = new SymbolTable();
        symbolTable.openScope();
    }
    @Override
    public T visitMain(calParser.MainContext ctx){
        System.out.println("main:");
        indent = indent + 3;
        return visitChildren(ctx);
    }
    @Override
    public T visitEnd(calParser.EndContext ctx){
        String currentIndent = new String(new char[indent]).replace("\0", " ");
        //pop symboltab scope
        //if parent is a function then get return value
        try {
            if (ctx.getParent().getText().split("\\(")[0].substring(0, 7).toLowerCase().equals("integer") || ctx.getParent().getText().split("\\(")[0].substring(0, 7).toLowerCase().equals("boolean") || ctx.getParent().getText().split("\\(")[0].substring(0, 4).toLowerCase().equals("void")) {
                System.out.println(currentIndent + "return"); //return variable
            }
        }
        catch (Exception e){}
        symbolTable.closeScope();
        indent = indent - 3;
        return visitChildren(ctx);
    }
    @Override
    public T visitStatement1(calParser.Statement1Context ctx){
        String currentIndent = new String(new char[indent]).replace("\0", " ");
        System.out.print(currentIndent + ctx.Id().getText() + " = "); //+ whatever is on the other side in terms of temps, variables, number, or parameters on stack
        try {
            if(symbolTable.getSymbol(ctx.expression().children.toArray()[0].toString()) != null)
            {
                //pass
            }
            else
            {
                System.out.println("This is an assignment");
                //if it is normal assignment x = y op z
                //if assignment of -y then x = 0 - y
            }
        } catch (Exception e) {}

        return visitChildren(ctx);
    }
    @Override
    public T visitStatement2(calParser.Statement2Context ctx){
        String currentIndent = new String(new char[indent]).replace("\0", " ");
        String [] l = ctx.arg_list().getText().split(",");
        System.out.println(currentIndent + "call " + ctx.Id().getText() + ", " + l.length);
        return visitChildren(ctx);
    }
    @Override
    public T visitExpression3(calParser.Expression3Context ctx){
        String currentIndent = new String(new char[indent]).replace("\0", " ");
        if(ctx.getParent() != null){
            System.out.println("call " + ctx.Id().getText() + ", " + symbolTable.getSymbol(ctx.Id().getText()).type.split(",").length);// + number of args
        }
        else {
            System.out.println(currentIndent + "call " + ctx.Id().getText());
        }
        return visitChildren(ctx);
    }
    @Override
    public T visitVar_decl(calParser.Var_declContext ctx) {
        //1: If a variable is already declared in scope raises error otherwise adds variable to scope
        symbolTable.addSymbol(new Symbol(ctx.Id().getText(), ctx.type().getText(), "Variable"));
        return visitChildren(ctx);
    }
    @Override
    public T visitConst_decl(calParser.Const_declContext ctx) {
        //1: If a constant is already declared in scope raises error otherwise adds variable to scope
        symbolTable.addSymbol(new Symbol(ctx.Id().getText(), ctx.type().getText(), "Constant"));
        return visitChildren(ctx);
    }
    @Override
    public T visitFunction(calParser.FunctionContext ctx) {
        System.out.println(ctx.Id().getText() + ":");
        indent = indent + 3;
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
    public T visitProgram(calParser.ProgramContext ctx) {
        symbolTable.openScope();
        return visitChildren(ctx);
    }
}
