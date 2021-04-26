package project_5.android_activities;

import android.view.View;
import android.widget.AdapterView;
import project_5.ru_cafe.Donut;

/**
The donutsInOrderOnClickListener listens for user click of an item in OrderDonutsActivity.donutsInOrderLV
@author Anthony Hebert, Jacob Cuison
*/
public class donutsInOrderOnClickListener implements AdapterView.OnItemClickListener {

    /**
    Upon user click, the clicked value is read and set to OrderDonutsActivity.selectedDonut
    @param parent is the AdapterView of OrderDonutsActivity.donutsInOrderLV
    @param view is the View that triggers this method
    @param position is the index (position) of the item selected from OrderDonutsActivity.donutsInOrderLV
    @param id is the id of OrderDonutsActivity.donutsInOrderLV
    */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Donut donut = (Donut) parent.getItemAtPosition(position);
        OrderDonutsActivity.selectedDonut = donut;
        OrderDonutsActivity.selectedDonutIndex = position;
    }
}
