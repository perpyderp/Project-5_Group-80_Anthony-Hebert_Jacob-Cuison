package project_5.android_activities;

import android.view.View;
import android.widget.AdapterView;

/**
The coffeeQuantityItemSelectedListener listens for user selection of an item in OrderCoffeeActivity.coffeeQuantitySpinner
@author Anthony Hebert, Jacob Cuison
*/
public class coffeeQuantityItemSelectedListener implements AdapterView.OnItemSelectedListener {

    /**
    Upon user selection, the selected quantity is read and the method calls OrderCoffeeActivity.updateSubtotalQuantity.
    @param parent is the AdapterView of OrderCoffeeActivity.coffeeQuantitySpinner
    @param view is the View that triggers this method
    @param position is the index (position) of the user-selected item from OrderCoffeeActivity.coffeeQuantitySpinner
    @param id is the id of OrderCoffeeActivity.coffeeQuantitySpinner
    */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int quantity = Integer.parseInt(parent.getItemAtPosition(position).toString());
        OrderCoffeeActivity.updateSubtotalQuantity(quantity);
    }

    /**
    Does nothing when nothing is selected by the user.
    @param parent is the AdapterView of OrderCoffeeActivity.coffeeQuantitySpinner
    */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //do nothing
    }
}
