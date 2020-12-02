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
        int frequentRenterPoints=0;
        String result="";
        for (Rental rental:_rentals){
            double currentAm=0;
            switch(rental.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    currentAm+=2;
                    if(rental.getDaysRented()>2){
                        currentAm+= (rental.getDaysRented()-2)*1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    currentAm+= rental.getDaysRented()*3;
                    break;
                case Movie.CHILDRENS:
                    currentAm+=1.5;
                    if (rental.getDaysRented()>3){
                        currentAm+= (rental.getDaysRented()-3)*1.5;
                    }
                    break;
            } 
            frequentRenterPoints++;
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented()>1){frequentRenterPoints++;}
            result+="  "+ rental.getMovie().getTitle()+"  "+String.valueOf(currentAm)+"\n";
            totalAmount+=currentAm;
        }
        result += "Amount owed is " + String.valueOf(totalAmount) +"\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)+" frequent renter points"+"\n";
        return result;
    }

}
