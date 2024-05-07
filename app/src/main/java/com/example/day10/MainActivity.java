package com.example.day10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup rgCarType, rgCity;
    private EditText ettotalDay;
    private Button btnRent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgCarType = findViewById(R.id.rgCarType);
        rgCity = findViewById(R.id.rgCity);
        ettotalDay = findViewById(R.id.ettotalDay);
        btnRent = findViewById(R.id.btnRent);

        btnRent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String TotalDay = ettotalDay.getText().toString().trim();
        String CarType = "";
        String City = "";
        int selectedId = rgCarType.getCheckedRadioButtonId();
        int selecCity = rgCity.getCheckedRadioButtonId();
        RadioButton selectedRadioButtonType = findViewById(selectedId);
        RadioButton selectedRadioButtonCity = findViewById(selecCity);
        CarType = selectedRadioButtonType.getText().toString();
        City = selectedRadioButtonCity.getText().toString();
        int Day = Integer.parseInt(TotalDay);

        int hargarent = 0;
        switch (CarType) {
            case "Pajero":
                hargarent = 2400000;
                break;
            case "Alphard":
                hargarent = 1550000;
                break;
            case "Inova":
                hargarent = 850000;
                break;
            case "Brio":
                hargarent = 550000;
                break;
            default:
                break;
        }
        double totalPrice = hargarent * Day;

        double Disc = 0;
        double Total_Rent = Integer.parseInt(TotalDay) * hargarent;
        if (Total_Rent > 10000000) {
            Disc = 0.07;
        } else if (Total_Rent > 5000000) {
            Disc = 0.05;
        }

        if (selecCity == R.id.btnInsideCity) {
            Total_Rent += 135000;
        } else if (selecCity == R.id.btnOutsideCity) {
            Total_Rent += 250000;
        }

        double TotalBayar = Total_Rent - Disc;

        Intent intent = new Intent(MainActivity.this, detailActivity.class);
        intent.putExtra("selectedCar", selectedId);
        intent.putExtra("selectedCity", selecCity);
        intent.putExtra("Days", TotalDay);
        intent.putExtra("totalRent", totalPrice);
        intent.putExtra("TotalBayar", TotalBayar); // Kirim total bayar sebagai double
        startActivity(intent);
    }
}
