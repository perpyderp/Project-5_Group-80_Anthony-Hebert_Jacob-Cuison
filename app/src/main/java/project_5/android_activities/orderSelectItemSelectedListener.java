package project_5.android_activities;

import android.view.View;
import android.widget.AdapterView;

/**
The orderSelectItemSelectedListener listens for user selection of an item in StoreOrdersActivity.viewOrderListView
@author Anthony Hebert, Jacob Cuison
*/
public class orderSelectItemSelectedListener implements AdapterView.OnItemSelectedListener {

    /**
    Upon user selection, the selected order item is read and the method calls OrderCoffeeActivity.updateSubtotalQuantity
    @param parent is the AdapterView of StoreOrdersActivity.viewOrderListView
    @param view is the View that triggers this method
    @param position is the index (position) which the user selected from StoreOrdersActivity.viewOrderListView
    @param id is the id of StoreOrdersActivity.viewOrderListView
    */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int orderNum = Integer.parseInt((String) parent.getItemAtPosition(position));
        StoreOrdersActivity.setSelectedOrder(orderNum);
        StoreOrdersActivity.orderTotalTextView.setText(MainMenuActivity.moneyFormat.format(StoreOrdersActivity.selectedOrder.getOrderTotal()));
    }

    /**
    Does nothing when nothing is selected by the user.
    @param parent is the AdapterView of StoreOrdersActivity.viewOrderListView
    */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //do nothing
    }
}
