import java.util.*;
class Customer {
    private String _name;
    private List<Rental> _rentals;
    public Customer (String name, List<Rental> list){
        _name = name;
        _rentals=list;
    }
  
    public String getName(){
        return _name;
    }
    public List<Rental> getRentals(){
        return _rentals;
    }
    public String toString(){
        return _name+": "+_rentals.toString();
    }
    public String statement(){
        double totalAmount =0;
        int frequent=0;
        String result="";
        for (Rental rental:_rentals){
            frequent+=getFrequentRenterPoints(rental);
            result+="  "+ rental.getMovie().getTitle()+"  "+String.valueOf(getTotal(rental))+"\n";
            totalAmount+=getTotal(rental);
        }
        result += "Amount owed is " + String.valueOf(totalAmount) +"\n";
        result += "You earned " + String.valueOf(frequent)+" frequent renter points"+"\n";
        return result;
    }
    public double getTotal(Rental rental){
        return rental.getCharge();
    }
    public int getFrequentRenterPoints(Rental rental){
        int points=1;
        if ((rental.getMovie().getPriceCode()==Movie.NEW_RELEASE)&&rental.getDaysRented()>1){points++;}
        return points;
    }
    public double getTotalCharge(){
         double totalAmount =0;
         for (Rental rental:_rentals){
             totalAmount+=getTotal(rental);
         }
        return totalAmount;
    }
    public int getTotalFrequentRenterPoints(){
         int frequent=0;
         for (Rental rental:_rentals){
            frequent+=getFrequentRenterPoints(rental);
         }
        return frequent;
    }
}
