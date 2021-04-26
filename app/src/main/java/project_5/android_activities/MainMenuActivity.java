package project_5.android_activities;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import project_5.ru_cafe.StoreOrders;
import project_5.ru_cafe.Order;
import project_5.ru_cafe.Coffee;
import project_5.ru_cafe.Donut;
import project_5.ru_cafe.MenuItem;
import java.text.DecimalFormat;

/**
The MainMenuActivity class handles user input on a main menu via an Android Activity. MainMenuActivity is linked to the
main_menu.xml file which MainMenuActivity's methods control. It takes in commands from the user, and then calls the
appropriate Activity to open the store's other menus as inputted by the user.
@author Anthony Hebert, Jacob Cuison
*/
public class MainMenuActivity extends AppCompatActivity {

    public static StoreOrders storeOrders = new StoreOrders();
    private static Order order = new Order();
    public static final DecimalFormat moneyFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
    }

    /**
    Opens a new window, which allows the user to add donuts to their order. This is accomplished by loading
    OrderDonutsActivity.java, which is linked to project_5.res.layout.ordering_donuts.xml.
    @param view is the View that triggers this method
    */
    public void openDonutsActivity(View view) {
        Intent openDonuts = new Intent(this, OrderDonutsActivity.class);
        startActivity(openDonuts);
    }

    /**
    Opens a new window, which allows the user to add coffee to their order. This is accomplished by loading
    OrderCoffeeActivity.java, which is linked to project_5.res.layout.ordering_coffee.xml.
    @param view is the View that triggers this method
    */
    public void openCoffeeActivity(View view) {
        Intent openDonuts = new Intent(this, OrderCoffeeActivity.class);
        startActivity(openDonuts);
    }

    /**
    Opens a new window, which allows the user to view their current order. This is accomplished by loading
    CurrentOrderDetailActivity.java, which is linked to project_5.res.layout.current_order_detail.xml.
    @param view is the View that triggers this method
    */
    public void openCurrentOrderActivity(View view) {
        Intent openDonuts = new Intent(this, CurrentOrderDetailActivity.class);
        startActivity(openDonuts);
    }

    /**
    Opens a new window, which allows the user to view all orders placed at the store. This is accomplished by loading
    StoreOrdersActivity.java, which is linked to project_5.res.layout.store_orders.xml.
    @param view is the View that triggers this method
    */
    public void openStoreOrdersActivity(View view) {
        Intent openStoreOrders = new Intent(this, StoreOrdersActivity.class);
        startActivity(openStoreOrders);
    }

    /**
    Adds the specified order to storeOrders by calling the appropriate method in ru_cafe.StoreOrders.java.
    @param orderToAdd is the Order to be added to storeOrders
    */
    public static void addOrderToStoreOrders(Object orderToAdd) {
        storeOrders.add(orderToAdd);
        order = new Order();
    }

    /**
    Updates the order subtotal and adds the specified menu item to order by calling the appropriate methods in ru_cafe.Order.java.
    @param item is the MenuItem to be added to order
    */
    public static void addToOrder(MenuItem item){
        if (item instanceof Coffee){
            Coffee coffee = (Coffee) item;
            order.add(coffee);
            order.setOrderSubtotal(order.getOrderSubtotal() + coffee.getPrice());
        }
        else if (item instanceof Donut){
            Donut donut = (Donut) item;
            order.add(donut);
            order.setOrderSubtotal(order.getOrderSubtotal() + donut.getPrice());
        }
    }

    /**
    Gets the Order object order.
    @return the Order object order
    */
    public static Order getOrder(){
        return order;
    }
}