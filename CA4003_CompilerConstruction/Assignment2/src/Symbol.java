public class Symbol {
    String id;
    String type;
    String cvf;
    String callflag;
    public Symbol(String id, String type, String cvf)
    {
        this.id = id;
        this.type = type; //for functions input types separated by ,
        this.cvf = cvf; //for function return type
        this.callflag = "No";
    }
    public void printSymbol()
    {
        System.out.println("ID: " + this.id + "\nType: " + this.type + "\nCVF: " + this.cvf + this.callflag);
    }
}
