package project_5.ru_cafe;

import java.util.ArrayList;

/**
The Coffee class creates a Coffee object, which holds values representing a coffee's size, number of add-ins, and list
of add-ins. This class is a subclass of MenuItem.
@author Anthony Hebert, Jacob Cuison
*/

public class Coffee extends MenuItem implements Customizable{

    private String size;
    private ArrayList<String> addIns;

    private static final double BASE_PRICE = 1.99;
    private static final String SHORT = "Short";
    private static final String TALL = "Tall";
    private static final double TALL_UPGRADE = 0.50;
    private static final String GRANDE = "Grande";
    private static final double GRANDE_UPGRADE = 1.00;
    private static final String VENTI = "Venti";
    private static final double VENTI_UPGRADE = 1.50;
    public static final String CREAM = "Cream";
    public static final String SYRUP = "Syrup";
    public static final String MILK = "Milk";
    public static final String CARAMEL = "Caramel";
    public static final String WHIPPED_CREAM = "Whipped Cream";
    private static final double PRICE_OF_ADDIN = 0.20;

    /**
    Initializes a Coffee using default values for all instance variables.
    */
    public Coffee(){
        super(0, 1);
        this.size = "";
        this.addIns = new ArrayList<String>();
    }

    /**
    Initializes a Coffee using given values for Coffee.size and MenuItem.quantity. Sets MenuItem.price to the base
    price (minimum price) for a coffee.
    @param size is the size of the coffee
    @param quantity is the quantity of the menu item
    */
    public Coffee(String size, int quantity){
        super(BASE_PRICE, quantity);
        this.size = size;
        this.addIns = new ArrayList<String>();
    }

    /**
    Adds a selected add-in to the specified Coffee object.
    @param obj is the Coffee object the add-in will be added to
    @return true if the add-in was successfully added, else false
    */
    public boolean add(Object obj){  //adds an add-in
        String addIn = "";
        if (obj instanceof String){
            addIn = (String) obj;
        }
        else return false;
        if (addIn.equals(CREAM)){
            addIns.add(CREAM);
            this.setPrice(this.getPrice() + PRICE_OF_ADDIN);
            return true;
        }
        else if (addIn.equals(SYRUP)){
            addIns.add(SYRUP);
            this.setPrice(this.getPrice() + PRICE_OF_ADDIN);
            return true;
        }
        else if (addIn.equals(MILK)){
            addIns.add(MILK);
            this.setPrice(this.getPrice() + PRICE_OF_ADDIN);
            return true;
        }
        else if (addIn.equals(CARAMEL)){
            addIns.add(CARAMEL);
            this.setPrice(this.getPrice() + PRICE_OF_ADDIN);
            return true;
        }
        else if (addIn.equals(WHIPPED_CREAM)){
            addIns.add(WHIPPED_CREAM);
            this.setPrice(this.getPrice() + PRICE_OF_ADDIN);
            return true;
        }
        return false;
    }

    /**
    Removes a selected add-in from the specified Coffee object.
    @param obj is the Coffee object the add-in will be removed from
    @return true if the add-in was successfully removed, else false
    */
    public boolean remove(Object obj) {  //removes an add-in
        String addIn = "";
        if (obj instanceof String) {
            addIn = (String) obj;
        }
        else return false;
        addIns.remove(addIn);
        this.setPrice(this.getPrice() - PRICE_OF_ADDIN);
        return true;
    }

    /**
    Calculates and sets the price for a specified Coffee object.
    */
    public void itemPrice(){
        double totalPrice = BASE_PRICE;
        if (this.size.equals(TALL)){
            totalPrice += TALL_UPGRADE;
        }
        else if (this.size.equals(GRANDE)){
            totalPrice += GRANDE_UPGRADE;
        }
        else if (this.size.equals(VENTI)){
            totalPrice += VENTI_UPGRADE;
        }
        if (addIns.size() != 0){
            totalPrice  += addIns.size() * PRICE_OF_ADDIN;
        }
        if (this.getQuantity() != 0){
            totalPrice *= this.getQuantity();
        }
        this.setPrice(totalPrice);
    }

    /**
    Converts a Coffee object to a String, which can then be printed.
    @return the String value of Coffee
    */
    @Override
    public String toString(){
        String coffee = "";
        if (this.size.equals(SHORT)){ coffee += SHORT; }
        else if (this.size.equals(TALL)){ coffee += TALL; }
        else if (this.size.equals(GRANDE)){ coffee += GRANDE; }
        else if (this.size.equals(VENTI)){ coffee += VENTI; }
        coffee += " coffee with ";
        if (addIns.size() == 0){
            coffee += "no add-ins";
            coffee += " (" + this.getQuantity() + ")";
            return coffee;
        }
        else if (addIns.size() == 1){
            coffee += addIns.get(0);
            coffee += " (" + this.getQuantity() + ")";
            return coffee;
        }
        for (int i = 0; i < addIns.size(); i++){
            if (i != 0){
                coffee += " and ";
            }
            coffee += addIns.get(i);
        }
        coffee += " (" + this.getQuantity() + ")";
        return coffee;
    }

    /**
    Gets the size of a Coffee object.
    @return the String value of Coffee.size
    */
    public String getSize(){ return this.size; }

    /**
    Sets the Coffee.size value of a Coffee object.
    @param newSize is the size for a coffee
    */
    public void setSize(String newSize){ this.size = newSize; }

    /**
    Sets the MenuItem.quantity value of a Coffee object.
    @param quantity is the quantity for a coffee
    */
    public void setQuantity(int quantity){ super.setQuantity(quantity); }
}
