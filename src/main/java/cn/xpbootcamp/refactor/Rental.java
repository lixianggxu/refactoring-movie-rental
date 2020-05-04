package cn.xpbootcamp.refactor;

public class Rental {

    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    int getDaysRented() {
        return daysRented;
    }

    double getRentalMenoyforOneMovie(Movie movie, int daysRented){
        double rentalMenoy = 0d;
        switch (movie.getPriceCode()) {
            case Movie.HISTORY:
                rentalMenoy = 2;
                if (daysRented > 2)
                    rentalMenoy += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalMenoy = daysRented* 3;
                break;
            case Movie.CAMPUS:
                rentalMenoy = 1.5;
                if (daysRented > 3)
                    rentalMenoy += (daysRented - 3) * 1.5;
                break;
        }
        return rentalMenoy;
    }

    int getFrequentRenterPointsforOneMovie(Movie movie, int daysRented){
        int frequentRenterPoints = 0;
        if ((movie.getPriceCode() == Movie.NEW_RELEASE)&&(daysRented>1)){
            frequentRenterPoints = 2;
        }else{
            frequentRenterPoints = 1;
        }
        return frequentRenterPoints;

    }
}
