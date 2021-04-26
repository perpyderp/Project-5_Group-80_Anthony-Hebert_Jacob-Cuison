package project_5.ru_cafe;

/**
The MenuItem class creates a generic MenuItem object, which holds values representing a menu item's price and quantity.
This class is the parent of Coffee and Donut.
@author Anthony Hebert, Jacob Cuison
*/

public class MenuItem {

    private double price;
    private int quantity;

    /**
    Initializes a MenuItem using given values for MenuItem.price and MenuItem.quantity.
    @param price is the price of the menu item
    @param quantity is the quantity of the menu item
    */
    public MenuItem(double price, int quantity){
        this.price = price;
        this.quantity = quantity;
    }

    /**
    Sets the MenuItem.price value of a MenuItem object.
    @param price is the calculated price for a menu item
    */
    public void setPrice(double price){
        this.price = price;
    }

    /**
    Gets the price of a MenuItem object.
    @return the double value of MenuItem.price
    */
    public double getPrice(){
        return this.price;
    }

    /**
    Gets the quantity of a MenuItem object.
    @return the int value of MenuItem.quantity
    */
    public int getQuantity(){
        return this.quantity;
    }

    /**
    Sets the MenuItem.quantity value of a MenuItem object.
    @param quantity is the quantity for a menu item
    */
    public void setQuantity(int quantity) { this.quantity = quantity; }

}
