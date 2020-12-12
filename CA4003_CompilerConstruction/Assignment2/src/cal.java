import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.FileInputStream;
import java.io.InputStream;

public class cal {
    int i = 0;

    public static void main(String[] args) throws Exception {
        String inputFile = null;

        if (args.length > 0)
            inputFile = args[0];

        InputStream is = System.in;
        if (inputFile != null)
            is = new FileInputStream(inputFile);

        calLexer lexer = new calLexer(CharStreams.fromStream(is));
        //lexer.removeErrorListener(ConsoleErrorListener.INSTANCE);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        calParser parser = new calParser(tokens);

        parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                System.out.println(args[0] + " has not parsed");
                System.exit(1);
            }
        });
        ParseTree tree = parser.program();
        System.out.println(args[0] + " parsed successfully");

        SemanticVisitor semantics = new SemanticVisitor();
        semantics.visit(tree);

        System.out.println("Writing ir code to " + args[1]);
        IRVisitor ir = new IRVisitor();
        ir.visit(tree);

    }
}