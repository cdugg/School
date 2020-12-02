public class RegularPrice extends Price{
    public double getCharge(int num){
        if (num>2){
            return 2+((num-2)*1.5);
        }
        return 2;
    }   
     public int getFrequentRenterPoints(int num){
        return 1;
    }
}
