package project_5.android_activities;

import android.view.View;
import android.widget.AdapterView;
import project_5.ru_cafe.MenuItem;

/**
The currentOrderOnClickListener listens for user selection of an item in CurrentOrderDetailActivity.currentOrderListView
@author Anthony Hebert, Jacob Cuison
*/
public class currentOrderOnClickListener implements AdapterView.OnItemClickListener {

    /**
    Upon user click, the clicked MenuItem is read and set to CurrentOrderDetailActivity.selectedItem
    @param parent is the AdapterView of CurrentOrderDetailActivity.currentOrderListView
    @param view is the view that triggers this method
    @param position is the index which the user selected from CurrentOrderDetailActivity.currentOrderListView
    @param id is the id of CurrentOrderDetailActivity.currentOrderListView
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CurrentOrderDetailActivity.setSelectedItem((MenuItem) parent.getItemAtPosition(position), position);
    }
}
