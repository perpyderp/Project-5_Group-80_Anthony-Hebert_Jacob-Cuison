package project_5.ru_cafe;

/**
The Donut class creates a Donut object, which holds values representing a donut's type and flavor.
This class is a subclass of MenuItem.
@author Anthony Hebert, Jacob Cuison
*/

public class Donut extends MenuItem{

    private String flavor;
    private static final double BASE_PRICE = 1.39;

    /**
    Initializes a Donut using given values for Donut.flavor, and MenuItem.quantity. Sets MenuItem.price to 0.
    @param flavor is the flavor of the donut
    @param quantity is the quantity of the menu item
    */
    public Donut(String flavor, int quantity) {
        super(0, quantity);
        this.flavor = flavor;
    }

    /**
    Calculates and sets the price for a specified Donut object.
    */
    public void itemPrice(){
        double totalPrice = BASE_PRICE;
        if (this.getQuantity() != 0){
            totalPrice *= this.getQuantity();
        }
        this.setPrice(totalPrice);
    }

    /**
    Converts a Donut object to a String, which can then be printed.
    @return the String value of Donut
    */
    @Override
    public String toString() {
        String details = "";
        details += flavor;
        details += " donut (" + getQuantity() + ")";
        return details;
    }

}
