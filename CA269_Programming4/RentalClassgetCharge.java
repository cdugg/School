 class Rental {
    private Movie _movie;
    private int _daysRented;
    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }
    public int getDaysRented() {
        return _daysRented;
    }
    public Movie getMovie() {
        return _movie;
    }
    public String toString(){
        return _movie.toString()+" ["+_daysRented+"]";//_movie;
    }
    public double getCharge(){
        double amount_owed=0;
        switch(_movie.getPriceCode()){
                case Movie.REGULAR:
                    amount_owed+=2;
                    if(_daysRented>2){
                        amount_owed+= (_daysRented-2)*1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    amount_owed+= _daysRented*3;
                    break;
                case Movie.CHILDRENS:
                    amount_owed+=1.5;
                    if (_daysRented>3){
                        amount_owed+= (_daysRented-3)*1.5;
                    }
                    break;
            }
        return amount_owed;
    }
 }
