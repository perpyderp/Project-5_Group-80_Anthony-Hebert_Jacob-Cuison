package project_5.android_activities;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import project_5.ru_cafe.Coffee;

/**
The OrderCoffeeActivity class handles user input for ordering coffee via an Android Activity.
OrderCoffeeActivity is linked to the ordering_donuts.xml file which OrderCoffeeActivity's methods control.
It takes in commands from the user, and then calls the appropriate methods in order to carry out the
task inputted by the user.
@author Anthony Hebert, Jacob Cuison
*/
public class OrderCoffeeActivity extends AppCompatActivity {

    private static Coffee coffee = new Coffee();

    private Spinner coffeeSizeSpinner, coffeeQuantitySpinner;

    private CheckBox syrupCheckBox, milkCheckBox,creamCheckBox, caramelCheckBox, whippedCreamCheckBox;

    private static TextView coffeeSubtotalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordering_coffee);
        coffeeSizeSpinner = findViewById(R.id.coffeeSizeSpinner);
        coffeeQuantitySpinner = findViewById(R.id.coffeeQuantitySpinner);
        syrupCheckBox = findViewById(R.id.syrupCheckBox);
        milkCheckBox = findViewById(R.id.milkCheckBox);
        creamCheckBox = findViewById(R.id.creamCheckBox);
        caramelCheckBox = findViewById(R.id.caramelCheckBox);
        whippedCreamCheckBox = findViewById(R.id.whippedCreamCheckBox);
        coffeeSubtotalTextView = findViewById(R.id.coffeeSubtotalTextVIew);
        ArrayAdapter<CharSequence> coffeeSizeAdapter = ArrayAdapter.createFromResource(this, R.array.coffee_sizes, android.R.layout.simple_spinner_item);
        coffeeSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coffeeSizeSpinner.setAdapter(coffeeSizeAdapter);
        coffeeSizeSpinner.setOnItemSelectedListener(new coffeeSizeItemSelectedListener());
        ArrayAdapter<CharSequence> quantityAdapter = ArrayAdapter.createFromResource(this,R.array.quantities, android.R.layout.simple_spinner_item);
        quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coffeeQuantitySpinner.setAdapter(quantityAdapter);
        coffeeQuantitySpinner.setOnItemSelectedListener(new coffeeQuantityItemSelectedListener());
    }

    /**
    Adds the syrup add-in to coffee and updates the subtotal accordingly by calling the appropriate methods in ru_cafe.Coffee.
    @param view is the View that triggers this method
    */
    public void addSyrup(View view) {
        if (!syrupCheckBox.isChecked()){
            coffee.remove(Coffee.SYRUP);
            coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
            return;
        }
        coffee.add(Coffee.SYRUP);
        coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
    }

    /**
    Adds the cream add-in to coffee and updates the subtotal accordingly by calling the appropriate methods in ru_cafe.Coffee.
    @param view is the View that triggers this method
    */
    public void addCream(View view) {
        if (!creamCheckBox.isChecked()){
            coffee.remove(Coffee.CREAM);
            coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
            return;
        }
        coffee.add(Coffee.CREAM);
        coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
    }

    /**
    Adds the whipped cream add-in to coffee and updates the subtotal accordingly by calling the appropriate methods in ru_cafe.Coffee.
    @param view is the View that triggers this method
    */
    public void addWhippedCream(View view) {
        if (!whippedCreamCheckBox.isChecked()){
            coffee.remove(Coffee.WHIPPED_CREAM);
            coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
            return;
        }
        coffee.add(Coffee.WHIPPED_CREAM);
        coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
    }

    /**
    Adds the milk add-in to coffee and updates the subtotal accordingly by calling the appropriate methods in ru_cafe.Coffee.
    @param view is the View that triggers this method
    */
    public void addMilk(View view) {
        if (!milkCheckBox.isChecked()){
            coffee.remove(Coffee.MILK);
            coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
            return;
        }
        coffee.add(Coffee.MILK);
        coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
    }

    /**
    Adds the caramel add-in to coffee and updates the subtotal accordingly by calling the appropriate methods in ru_cafe.Coffee.
    @param view is the View that triggers this method
    */
    public void addCaramel(View view) {
        if (!caramelCheckBox.isChecked()){
            coffee.remove(Coffee.CARAMEL);
            coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
            return;
        }
        coffee.add(Coffee.CARAMEL);
        coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
    }

    /**
    Updates the subtotal of coffee when a new quantity is selected and sets coffee.quantity by calling the appropriate methods in ru_cafe.Coffee.
    @param quantity is the int value of the quantity of the coffee selected by the user
    */
    public static void updateSubtotalQuantity(int quantity){
        coffee.setQuantity(quantity);
        coffee.itemPrice();
        coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
    }

    /**
    Updates the subtotal of coffee when a new quantity is selected and sets coffee.size by calling the appropriate methods in ru_cafe.Coffee.
    @param size is the String value of the size of the coffee selected by the user
    */
    public static void updateSubtotalSize(String size) {
        coffee.setSize(size);
        coffee.itemPrice();
        coffeeSubtotalTextView.setText(MainMenuActivity.moneyFormat.format(coffee.getPrice()));
    }

    /**
    Adds the user's selected Coffee to MainMenuActivity.order by calling the appropriate method in MainMenuActivity.java.
    @param view is the View that triggers this method
    */
    public void addToOrder(View view) {
        MainMenuActivity.addToOrder(coffee);
        Toast.makeText(getApplicationContext(), R.string.coffee_added, Toast.LENGTH_SHORT).show();
        coffee = new Coffee();
        finish();
    }
}