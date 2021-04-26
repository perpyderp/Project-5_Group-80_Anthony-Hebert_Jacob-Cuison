package project_5.ru_cafe;

import java.util.ArrayList;

/**
The Order class creates an Order object, which holds values representing an order's number, subtotal, and list of menu item's.
@author Anthony Hebert, Jacob Cuison
*/

public class Order implements Customizable{

    private static int orderNum = 0;
    private ArrayList<MenuItem> orderItems;
    private double orderSubtotal;
    private int orderNumber;

    /**
    Initializes an Order using default values for Order.orderItems, Order.orderSubtotal, and Order.orderNumber.
    */
    public Order() {
        this.orderItems = new ArrayList<MenuItem>();
        orderNum++;
        this.orderSubtotal = 0;
        this.orderNumber = orderNum;
    }

    /**
    Adds a selected MenuItem to the specified Order object.
    @param obj is the Order object the MenuItem will be added to.
    @return true if the menu item was successfully added, else false
    */
    public boolean add(Object obj){
        if(obj instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) obj;
            orderItems.add(menuItem);
            return true;
        }
        return false;
    }

    /**
    Removes a selected MenuItem from the specified Order object.
    @param obj is the Order object the MenuItem will be removed from.
    @return true if the menu item was successfully removed, else false
    */
    public boolean remove(Object obj){
        orderItems.remove(obj);
        return true;
    }

    /**
    Converts an Order object to a String, which can then be printed.
    @return the String value of Order
    */
    @Override
    public String toString() {
        return "Order #: " + orderNumber;
    }

    /**
    Gets the number of MenuItems in an Order.
    @return the int value of Order.orderItems.size()
    */
    public int getSize() { return orderItems.size(); }

    /**
    Gets the ArrayList of MenuItems from an Order.
    @return the ArrayList of Order.orderItems
    */
    public ArrayList<MenuItem> getOrderItems(){
        return this.orderItems;
    }

    /**
    Gets the subtotal of an Order.
    @return the double value of Order.subtotal
    */
    public double getOrderSubtotal(){
        return this.orderSubtotal;
    }

    /**
    Calculates the sales tax for an Order based off of Order.subtotal, and then adds the tax to the subtotal to return
    the total order price.
    @return the double value of Order.subtotal + the Order's sales tax
    */
    public double getOrderTotal() {  return getOrderSubtotal() + (getOrderSubtotal() * 0.06625); }

    /**
    Sets the Order.subtotal value of an Order object.
    @param subtotal is the subtotal for the Order
    */
    public void setOrderSubtotal(double subtotal){
        this.orderSubtotal = subtotal;
    }

    /**
    Gets the order number of an Order.
    @return the int value of Order.orderNumber
    */
    public int getOrderNum(){
        return this.orderNumber;
    }

}
