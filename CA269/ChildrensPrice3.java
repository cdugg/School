public class ChildrensPrice extends Price{
    public double getCharge(int num){
        if (num>3){
            return 1.5+((num-3)*1.5);
        }
        return 1.5;
    }
    public int getFrequentRenterPoints(int num){
        return 1;
    }
}
