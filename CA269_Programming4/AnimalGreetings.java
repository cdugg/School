public class Animal
{
    String name;
    public Animal(String a)
    {
        name = a;
    }
    public String greeting()
    {
        String s = "Hello, my name is " + name;
        return s;
    }
}
