package project_5.android_activities;

import android.content.Context;
import android.view.View;
import android.widget.Spinner;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import project_5.ru_cafe.MenuItem;
import project_5.ru_cafe.Order;
import java.util.ArrayList;

/**
The StoreOrdersActivity class handles user input for viewing the current order via an Android Activity.
StoreOrdersActivity is linked to the store_orders.xml file which StoreOrdersActivity's methods control.
It takes in commands from the user, and then calls the appropriate methods in order to carry out the
task inputted by the user.
@author Anthony Hebert, Jacob Cuison
*/
public class StoreOrdersActivity extends AppCompatActivity{

    private Spinner orderSelectSpinner;

    private static ListView viewOrderListView;

    public static TextView orderTotalTextView;

    private static Context context;

    private static ArrayAdapter selectedOrderAdapter;

    private ArrayAdapter<String> orderNumsAdapter;

    public static Order selectedOrder = new Order();

    private static ArrayList<MenuItem> orderItems;

    private static int numOfOrders;

    private ArrayList<String> orderNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);
        if (MainMenuActivity.storeOrders.isEmpty()){
            Toast.makeText(getApplicationContext(), R.string.empty_order_list, Toast.LENGTH_SHORT).show();
            finish();
        }
        orderSelectSpinner = findViewById(R.id.orderSelectSpinner);
        viewOrderListView = findViewById(R.id.viewOrderListView);
        orderTotalTextView = findViewById(R.id.orderTotalTextView);
        context = this;
        setOrderNums();
        orderNumsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, orderNumbers);
        orderNumsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderSelectSpinner.setAdapter(orderNumsAdapter);
        orderSelectSpinner.setOnItemSelectedListener(new orderSelectItemSelectedListener());
        orderItems = selectedOrder.getOrderItems();
        selectedOrderAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, orderItems);
        viewOrderListView.setAdapter(selectedOrderAdapter);
    }

    /**
    Cancels the current selected order from orderSelectSpinner by removing it
    from MainMenuActivity.storeOrders.
    @param view is the View that triggers this method
    */
    public void cancelOrder(View view) {
        numOfOrders--;
        orderNumbers.remove(String.valueOf(selectedOrder.getOrderNum()));
        orderItems = new ArrayList<MenuItem>();
        selectedOrderAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, orderItems);
        viewOrderListView.setAdapter(selectedOrderAdapter);
        MainMenuActivity.storeOrders.remove(selectedOrder);
        orderTotalTextView.setText("");
    }

    /**
    Sets the StoreOrdersActivity.selectedOrder.
    @param orderNum is the int value for the order number user-selected order
    */
    public static void setSelectedOrder(int orderNum){
        for (int i = 0; i < numOfOrders; i++){
            if (MainMenuActivity.storeOrders.getOrderList().get(i).getOrderNum() == orderNum){
                selectedOrder = MainMenuActivity.storeOrders.getOrderList().get(i);
                break;
            }
        }
        orderItems = selectedOrder.getOrderItems();
        selectedOrderAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, orderItems);
        viewOrderListView.setAdapter(selectedOrderAdapter);
    }

    /**
    Sets the StoreOrdersActivity.orderNumbers ArrayList<String> values.
    */
    private void setOrderNums(){
        numOfOrders = MainMenuActivity.storeOrders.getSize();
        orderNumbers = new ArrayList<String>();
        int cnt = 0;
        while (cnt < numOfOrders){
            orderNumbers.add(String.valueOf(MainMenuActivity.storeOrders.getOrderList().get(cnt).getOrderNum()));
            cnt++;
        }
    }
}
