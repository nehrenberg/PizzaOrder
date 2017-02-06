package css.cis3334.nehrenberg.pizzaorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioButton rbSmall;
    RadioButton rbMedium;
    RadioButton rbLarge;
    CheckBox cbCheese;
    CheckBox cbDelivery;
    EditText etTotal;
    RadioGroup rgGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbLarge = (RadioButton) findViewById(R.id.radioButtonLarge);
        rbMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        rbSmall = (RadioButton) findViewById(R.id.radioButtonSmall);
        cbCheese = (CheckBox) findViewById(R.id.checkBoxExtraCheese);
        cbDelivery = (CheckBox) findViewById(R.id.checkBoxDelivery);
        etTotal = (EditText) findViewById(R.id.editTextTotal);
    }

    public void onClick(View view) {
        double total = 0;

        if (rbLarge.isChecked())  {
            rbMedium.setChecked(false);
            rbSmall.setChecked(false);
            total = total + 13.0;
        }
        if (rbMedium.isChecked())  {
            rbSmall.setChecked(false);
            rbLarge.setChecked(false);
            total = total + 9.0;
        }
        if (rbSmall.isChecked())  {
            rbLarge.setChecked(false);
            rbMedium.setChecked(false);
            total = total + 7.0;
        }
        if (cbCheese.isChecked()) {
            total = total + 1.75;
        }
        if (cbDelivery.isChecked()) {
            total = total + 2.50;
        }

        etTotal.setText(String.format("Total is $%.2f", total));
    }
}
