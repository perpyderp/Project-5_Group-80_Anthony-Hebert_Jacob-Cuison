package project_5.android_activities;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import project_5.ru_cafe.Coffee;
import project_5.ru_cafe.MenuItem;
import project_5.ru_cafe.Order;
import project_5.ru_cafe.Donut;
import java.util.ArrayList;

/**
The CurrentOrderDetailActivity class handles user input for viewing the current order via an Android Activity.
CurrentOrderDetailActivity is linked to the current_order_detail.xml file which CurrentOrderDetailActivity's methods control.
It takes in commands from the user, and then calls the appropriate methods in order to carry out the
task inputted by the user.
@author Anthony Hebert, Jacob Cuison
*/
public class CurrentOrderDetailActivity extends AppCompatActivity {

    private Order order;

    private ArrayList<MenuItem> orderItems;

    private static MenuItem selectedItem;

    private static int itemPosition;

    private ListView currentOrderListView;

    private TextView currentOrderSubtotalTextView, currentOrderTaxTextView, currentOrderTotalTextView;

    private ArrayAdapter adapter;

    private static final int INVALID = -1;
    private static final double SALES_TAX = 0.06625;
    private static final String ZERO_BALANCE = "0.00";
    private static final String NEGATIVE_ZERO_BALANCE = "-0.00";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order_detail);
        currentOrderListView = findViewById(R.id.currentOrderListView);
        currentOrderSubtotalTextView = findViewById(R.id.currentOrderSubtotalTextView);
        currentOrderTaxTextView = findViewById(R.id.currentOrderTaxTextView);
        currentOrderTotalTextView = findViewById(R.id.currentOrderTotalTextView);
        order = MainMenuActivity.getOrder();
        orderItems = order.getOrderItems();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, orderItems);
        currentOrderListView.setAdapter(adapter);
        currentOrderListView.setOnItemClickListener(new currentOrderOnClickListener());
        setSubtotalFields();
    }

    /**
    Adds the order to MainMenuActivity.storeOrders and notifies the user the order has been placed via a Toast.
    @param view is the View that triggers this method
    */
    public void placeOrder(View view) {
        if (order.getOrderItems().size() == 0){
            Toast.makeText(getApplicationContext(), R.string.no_items_added, Toast.LENGTH_SHORT).show();
            return;
        }
        MainMenuActivity.addOrderToStoreOrders(order);
        Toast.makeText(getApplicationContext(), R.string.order_placed, Toast.LENGTH_SHORT).show();
        finish();
    }

    /**
    Removes the selected item from currentOrderListView.
    @param view is the View that triggers this method
    */
    public void removeItem(View view) {
        if (selectedItem instanceof Coffee){
            Coffee coffeeToRemove = (Coffee) selectedItem;
            adapter.remove(itemPosition);
            currentOrderListView.invalidateViews();
            orderItems.remove(coffeeToRemove);
            order.setOrderSubtotal(order.getOrderSubtotal() - coffeeToRemove.getPrice());
            setSubtotalFields();
        }
        else if (selectedItem instanceof Donut){
            Donut donutToRemove = (Donut) selectedItem;
            adapter.remove(itemPosition);
            currentOrderListView.invalidateViews();
            orderItems.remove(donutToRemove);
            order.setOrderSubtotal(order.getOrderSubtotal() - donutToRemove.getPrice());
            setSubtotalFields();
        }
        selectedItem = null;
        itemPosition = INVALID;
        Toast.makeText(getApplicationContext(), R.string.item_removed, Toast.LENGTH_SHORT).show();
    }

    /**
    Calculates and sets the values for subtotalTextField, salesTaxTextField, and orderTotalTextField by calling the
    appropriate methods in main_menu.mainController and ru_cafe.Order.
    */
    private void setSubtotalFields(){
        currentOrderSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(order.getOrderSubtotal()));
        currentOrderTaxTextView.setText(MainMenuActivity.moneyFormat.format(order.getOrderSubtotal() * SALES_TAX));
        currentOrderTotalTextView.setText(MainMenuActivity.moneyFormat.format(order.getOrderSubtotal() + (order.getOrderSubtotal() * SALES_TAX)));
        if (currentOrderSubtotalTextView.getText().equals(NEGATIVE_ZERO_BALANCE)){
            currentOrderSubtotalTextView.setText(ZERO_BALANCE);
            currentOrderTaxTextView.setText(ZERO_BALANCE);
            currentOrderTotalTextView.setText(ZERO_BALANCE);
        }
    }

    /**
    Sets the CurrentOrderDetailActivity.selectedItem and CurrentOrderDetailActivity.itemPosition values.
    @param selectedItemFromClick is the user-selected item
    @param position is the position of the user-selected item
    */
    public static void setSelectedItem(MenuItem selectedItemFromClick, int position) {
        selectedItem = selectedItemFromClick;
        itemPosition = position;
    }
}
