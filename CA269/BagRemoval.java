@SuppressWarnings("unchecked")
public class Bag<T>
{
   // Create an array of type T of 100 items (This is quite clumsy in Java)
   private T[] bag = (T[])(new Object[100]);
   private int numElements = 0;
   
   public void add(T x)
   { // put x in bag
      bag[numElements] = x;
      numElements++;
   }
   
   public void remove(T item)
   {
	   int i = 0;
	   while(i < bag.length && bag[i] != item)
		   i ++;
	   if(i < numElements)
	   {
		   for(int j = i; j < numElements; j ++)
		   {
			   bag[j] = bag[j+1];
		   }
		   numElements--;
	   }
   }
   
   public int count(T x)
   {
      int count = 0;
      for (int i = 0; i < numElements; i++)
         if (bag[i].equals(x)) // .equals because T a class 
            count++;
      return count;
   }

   public int length()
   {
      return numElements;
   }
}
