package project_5.android_activities;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import project_5.ru_cafe.Donut;

/**
The OrderDonutsActivity class handles all user activity for ordering donuts via an Android Activity.
OrderDonutsActivity is linked to the ordering_donuts.xml file which OrderDonutsActivity's methods control.
It takes in commands from the user, and then calls the appropriate methods in order to carry out the
task inputted by the user.
*/
public class OrderDonutsActivity extends AppCompatActivity {
    private ListView donutFlavorsLV, donutsInOrderLV;
    private ArrayList<String> donutFlavors;
    private Spinner donutQuantitySpinner;
    private ArrayAdapter<String> donutFlavorsAdapter;
    private ArrayAdapter<Donut> donutsToOrder;
    private ArrayAdapter<Integer> quantityAdapter;
    private ArrayList<Donut> donutOrder = new ArrayList<>();
    private ArrayList<Integer> quantities;
    private TextView subtotalTextView;
    private double subtotal = 0;
    public static String selectedFlavor;
    public static int selectedQuantity;
    public static Donut selectedDonut;
    private static final int INVALID = -1;
    public static int selectedDonutIndex = INVALID;
    private static final String ZERO_BALANCE = "0.00";
    private static final String NEGATIVE_ZERO_BALANCE = "-0.00";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordering_donuts);
        donutFlavorsLV = findViewById(R.id.donutFlavors);
        donutQuantitySpinner = findViewById(R.id.donutQuantitySpinner);
        subtotalTextView = findViewById(R.id.donutSubtotalTextVIew);
        donutsInOrderLV = findViewById(R.id.donutsInOrder);
        donutFlavorsLV.setOnItemClickListener(new donutFlavorOnClickListener());
        initializeQuantitiesAndFlavors();
        donutFlavorsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, donutFlavors);
        donutFlavorsLV.setAdapter(donutFlavorsAdapter);
        donutsToOrder = new ArrayAdapter<Donut>(this, android.R.layout.simple_list_item_1, donutOrder);
        donutsInOrderLV.setAdapter(donutsToOrder);
        quantityAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, quantities);
        quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        donutQuantitySpinner.setAdapter(quantityAdapter);
        donutQuantitySpinner.setOnItemSelectedListener(new donutQuantityItemSelectedListener());
        subtotalTextView.setText(MainMenuActivity.moneyFormat.format(subtotal));
        donutsInOrderLV.setOnItemClickListener(new donutsInOrderOnClickListener());
    }

    /**
    Moves the selected Donut from DonutFlavorsLV to DonutsInOrderLV and updates the subtotal accordingly.
    The ArrayList<Donut>donutOrder is updated and ArrayAdapter<Donut> is set to a new adapter
    @param view is the View that triggers this method
    */
    public void addDonut(View view) {
        try {
            if (selectedFlavor == null) {
                Toast.makeText(getApplicationContext(), R.string.no_flavor_selected, Toast.LENGTH_SHORT).show();
                return;
            }
            Donut newDonut = new Donut(selectedFlavor, selectedQuantity);
            donutOrder.add(newDonut);
            donutsToOrder = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, donutOrder);
            donutsInOrderLV.setAdapter(donutsToOrder);
            newDonut.itemPrice();
            subtotal += newDonut.getPrice();
            subtotalTextView.setText(MainMenuActivity.moneyFormat.format(subtotal));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
    Removes the selectedDonut in DonutsInOrderLV and updates the subtotal. The ArrayList<Donut>donutOrder is updated
    and ArrayAdapter<Donut> is set to a new adapter
    @param view is the View that triggers this method
    */
    public void removeDonut(View view) {
        try {
            if (selectedDonut == null) {
                Toast.makeText(getApplicationContext(), R.string.no_donut_selected, Toast.LENGTH_SHORT).show();
                return;
            }
            selectedDonutIndex = INVALID;
            subtotal -= selectedDonut.getPrice();
            subtotalTextView.setText(MainMenuActivity.moneyFormat.format(subtotal));
            if(subtotalTextView.getText().equals(NEGATIVE_ZERO_BALANCE)) {
                subtotalTextView.setText(ZERO_BALANCE);
            }
            donutOrder.remove(selectedDonut);
            selectedDonut = null;
            donutsToOrder = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, donutOrder);
            donutsInOrderLV.setAdapter(donutsToOrder);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
    Adds the donuts in donutOrder to MainMenuActivity.order and clears donutOrder as well as donutsInOrderLV to be
    empty when the user orders donuts again
    @param view is the View that triggers this method
    */
    public void addToOrder(View view) {
        try {
            if (donutOrder.size() == 0) {
                Toast.makeText(getApplicationContext(), R.string.no_donuts_on_order, Toast.LENGTH_SHORT).show();
                return;
            }
            int index = 0;
            while (index < donutOrder.size()) {
                MainMenuActivity.addToOrder(donutOrder.get(index));
                index++;
            }
            donutOrder.clear();
            donutsToOrder = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, donutOrder);
            donutsInOrderLV.setAdapter(donutsToOrder);
            subtotalTextView.setText("");
            Toast.makeText(getApplicationContext(), R.string.donuts_ordered, Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
    Initializes the flavors and quantities ArrayList to be used by donutQuantitySpinner and DonutFlavorsLV
    */
    private void initializeQuantitiesAndFlavors() {
        quantities = new ArrayList<>();
        quantities.add(1);
        quantities.add(2);
        quantities.add(3);
        quantities.add(4);
        quantities.add(5);
        quantities.add(6);
        quantities.add(7);
        quantities.add(8);
        quantities.add(9);
        donutFlavors = new ArrayList<>();
        donutFlavors.add("Glazed");
        donutFlavors.add("Chocolate Frosted");
        donutFlavors.add("Boston Cream");
        donutFlavors.add("Powdered");
        donutFlavors.add("Chocolate");
    }
}
