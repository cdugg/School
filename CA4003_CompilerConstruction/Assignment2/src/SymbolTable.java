import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class SymbolTable {
    public Stack<HashMap<String, Symbol>> stack = new Stack<HashMap<String, Symbol>>();
    public SymbolTable()
    {
        stack = new Stack <HashMap<String, Symbol>>();
    }
    public void openScope()
    {
        stack.push(new HashMap<>());
    }
    public void closeScope()
    {
        stack.pop();
    }
    public Symbol getSymbol(String id)
    {
        //System.out.println(stack);
        int [] ints = {stack.size()-1, 1};
        for(int i : ints)
        {
            //System.out.println(stack.toString());
            Symbol sym = stack.elementAt(i).get(id);
            if(sym != null)
                return sym;
        }
        return null;
    }
    public void addSymbol(Symbol sym)
    {
        stack.peek().put(sym.id, sym);
    }
    public void print()
    {
        for (int i = stack.size() - 1; i > 0; i --)
        {
            System.out.println(Arrays.asList(stack.elementAt(i)));
        }
    }
    public boolean inLocal(String id)
    {
        return stack.peek().containsKey(id);
    }
}
