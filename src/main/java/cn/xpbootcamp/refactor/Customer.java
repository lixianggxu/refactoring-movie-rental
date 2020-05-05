package cn.xpbootcamp.refactor;

import  java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Rental> rentals = new ArrayList<Rental>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    String statement() {
        double totalAmount = 0d;
        int frequentRenterPoints = 0;
        ArrayList<Rental> rentalsList = this.rentals;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "：\n");
        for(Rental each : rentalsList){
            Movie movie = each.getMovie();
            int retalDay = each.getDaysRented();
            //show figures for this rental
            //determine amounts for each line
            double thisAmount = 0d;
            thisAmount = each.getRentalMenoyforOneMovie(movie,retalDay);
            //add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPointsforOneMovie(movie,retalDay);

            //show figures for this rental
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}
