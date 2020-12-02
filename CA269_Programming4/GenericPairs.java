public class Pair<TYPE, TYPE2> {
	TYPE part1;
	TYPE2 part2;
	public Pair(TYPE name, TYPE2 num)
	{
		part1 = name;
		part2 = num;
	}
	public String toString()
	{
		return part1 + " " + part2;
	}
}
