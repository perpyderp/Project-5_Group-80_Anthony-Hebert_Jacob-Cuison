package project_5.android_activities;

import android.view.View;
import android.widget.AdapterView;

/**
The donutFlavorOnClickListener class listens for user selection of an item in OrderDonutsActivity.donutFlavorsLV
@author Anthony Hebert, Jacob Cuison
*/
public class donutFlavorOnClickListener implements AdapterView.OnItemClickListener {
    /**
    Upon user selection, the selected flavor is read and set to OrderDonutsActivity.selectedFlavor
    @param parent is the AdapterView of OrderDonutsActivity.donutFlavorsLV
    @param view is the View that triggers this method
    @param position is the index (position) of the item selected from OrderDonutsActivity.donutFlavorsLV
    @param id is the id of OrderDonutsActivity.donutFlavorsLV
    */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String flavor = parent.getItemAtPosition(position).toString();
        OrderDonutsActivity.selectedFlavor = flavor;
    }
}
