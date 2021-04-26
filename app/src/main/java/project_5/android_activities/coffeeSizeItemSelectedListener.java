package project_5.android_activities;

import android.view.View;
import android.widget.AdapterView;

/**
The coffeeSizeItemSelectedListener listens for user selection of an item in OrderCoffeeActivity.coffeeSizeSpinner
@author Anthony Hebert, Jacob Cuison
*/
public class coffeeSizeItemSelectedListener implements AdapterView.OnItemSelectedListener {

    /**
    Upon user selection, the selected quantity is read and the method calls OrderCoffeeActivity.updateSubtotalSize
    @param parent is the AdapterView of OrderCoffeeActivity.coffeeSizeSpinner
    @param view is the View that triggers this method
    @param position is the index (position) which the user selected from OrderCoffeeActivity.coffeeSizeSpinner
    @param id is the id of OrderCoffeeActivity.coffeeSizeSpinner
    */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String size = parent.getItemAtPosition(position).toString();
        OrderCoffeeActivity.updateSubtotalSize(size);
    }

    /**
    Does nothing when nothing is selected by the user.
    @param parent is the AdapterView of OrderCoffeeActivity.coffeeSizeSpinner
    */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //do nothing
    }
}
