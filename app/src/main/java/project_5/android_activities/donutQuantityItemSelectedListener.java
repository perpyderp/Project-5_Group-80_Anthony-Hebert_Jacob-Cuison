package project_5.android_activities;

import android.view.View;
import android.widget.AdapterView;

/**
The donutQuantityItemSelectedListener class listens for user selection of an item in OrderDonutsActivity.donutQuantitySpinner.
@author Anthony Hebert, Jacob Cuison
*/
public class donutQuantityItemSelectedListener implements AdapterView.OnItemSelectedListener {

    /**
    Upon user selection, the selected quantity is read and set to OrderDonutsActivity.selectedQuantity.
    @param parent is the AdapterView of OrderDonutsActivity.donutQuantitySpinner
    @param view is the View that triggers this method
    @param position is the index (position) of the user selected item from OrderDonutsActivity.donutQuantitySpinner
    @param id is the id of the OrderDonutsActivity.donutQuantitySpinner
    */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int quantity = Integer.parseInt(parent.getItemAtPosition(position).toString());
        OrderDonutsActivity.selectedQuantity = quantity;
    }

    /**
    Does nothing when nothing is selected by the user.
    @param parent is the AdapterView of OrderDonutsActivity.donutQuantitySpinner
    */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //do nothing
    }
}
