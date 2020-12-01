public abstract class Animal
{
    public Animal(String name)
    {
        this.name = name;
    }
    private String name;
    public abstract String hello();
    public String greeting()
    {
        return hello() + ", my name is " + name;
    }
}
