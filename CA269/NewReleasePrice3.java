public class NewReleasePrice extends Price{
    public double getCharge(int num){
        return 3*num;
    }  
     public int getFrequentRenterPoints(int num){
        if (num>1){return 2;}
        return 1;
    }
}
