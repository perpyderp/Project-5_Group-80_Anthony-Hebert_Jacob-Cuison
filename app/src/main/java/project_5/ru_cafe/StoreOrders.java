package project_5.ru_cafe;

import java.util.ArrayList;

/**
The StoreOrders class creates a StoreOrders object, which holds values representing a store's number of orders
and list of orders.
@author Anthony Hebert, Jacob Cuison
*/

public class StoreOrders implements Customizable {

    private ArrayList<Order> orderList;
    private int numOfOrders = 0;

    /**
    Initializes a StoreOrders using default values for StoreOrders.orderList and StoreOrders.numOfOrders.
    */
    public StoreOrders() {
        this.orderList = new ArrayList<Order>();
    }

    /**
    Adds an Order to the specified StoreOrders object.
    @param obj is the Order object that will be added to the specific StoreOrders.orderList
    @return true if the Order was successfully added, else false
    */
    public boolean add(Object obj){
        if(obj instanceof Order) {
            Order order = (Order) obj;
            orderList.add(order);
            numOfOrders++;
            return true;
        }
        return false;
    }

    /**
    Removes a selected Order from the specified StoreOrders object.
    @param obj is the Order object to be removed from the StoreOrders
    @return true if the Order was successfully removed, else false
    */
    public boolean remove(Object obj){
        if(obj instanceof Order) {
            Order order = (Order) obj;
            orderList.remove(order);
            numOfOrders--;
            return true;
        }
        return false;
    }

    /**
    Converts a StoreOrders object to a String, which can then be printed.
    @return the String value of StoreOrders
    */
    @Override
    public String toString() {
        String message = "";
        for(int i = 0; i < getSize(); i++) {
            message += (orderList.get(i).toString() + "\n");
        }
        return message;
    }

    /**
    Checks if the StoreOrders has no orders contained within it.
    @return true if StoreOrders.numOfOrders equals 0, else false
    */
    public boolean isEmpty() {
        if(numOfOrders == 0) return true;
        else return false;
    }

    /**
    Gets the size of StoreOrders.orderList.
    @return the int value of StoreOrders.orderList.size()
    */
    public int getSize() { return orderList.size(); }

    /**
    Gets the order list of a StoreOrders object.
    @return the ArrayList of StoreOrders.orderList
    */
    public ArrayList<Order> getOrderList(){
        return this.orderList;
    }
}
