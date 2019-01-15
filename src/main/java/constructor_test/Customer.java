package constructor_test;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    /**
     * 生成详细清单
     */
    public String stateMent() {
        double total_amount = 0;
        int frequent_renter_points = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName();
        while (rentals.hasMoreElements()) {
            double this_amount = 0;
            Rental each = (Rental) rentals.nextElement();

            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    this_amount += 2;
                    if (each.getDaysRented() > 2) {
                        this_amount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    this_amount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    this_amount += 1.5;
                    if (each.getDaysRented() > 3) {
                        this_amount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

            // add frequent renter points
            frequent_renter_points++;

            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequent_renter_points++;
            }

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(this_amount) + "\n";

            total_amount += this_amount;
        }
        // addd footer lines
        result += "Amount owed is " + String.valueOf(total_amount) + "\n";
        result += "You earned " + String.valueOf(frequent_renter_points) + " frequent renter points";
        return result;
    }
}