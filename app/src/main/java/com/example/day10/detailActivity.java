package com.example.day10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {

    private TextView tvWelcome, tvMembership, tvCartype, tvCity, tvDayOfRent, tvDiskon, tvTotalBayar, tvThanks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Inisialisasi TextView
        tvWelcome = findViewById(R.id.tvWelcome);
        tvMembership = findViewById(R.id.tvMembership);
        tvCartype = findViewById(R.id.Cartype);
        tvCity = findViewById(R.id.city);
        tvDayOfRent = findViewById(R.id.Day_of_rent);
        tvDiskon = findViewById(R.id.tvDiskon);
        tvTotalBayar = findViewById(R.id.tvTotalBayar);
        tvThanks = findViewById(R.id.tvThanks);

        // Mengambil data yang dikirimkan dari MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int selectedCarId = extras.getInt("selectedCar");
            int selectedCityId = extras.getInt("selectedCity");
            String totalDays = extras.getString("Days");
            double totalRent = extras.getDouble("totalRent");

            // Set teks untuk ditampilkan di TextView
            tvWelcome.setText("Welcome");
            tvMembership.setText("Membership");

            tvDayOfRent.setText("Day Of Rent : " + totalDays);
            tvDiskon.setText("Disc : " + calculateDiscount(totalRent));
            tvTotalBayar.setText("Total Bayar : " + calculateTotalBayar(totalRent));
            tvThanks.setText("Thanks");

        }
    }



    // Metode untuk menghitung diskon berdasarkan total sewa
    private String calculateDiscount(double totalRent) {
        if (totalRent > 10000000) {
            return "7%";
        } else if (totalRent > 5000000) {
            return "5%";
        } else {
            return "0%";
        }
    }

    // Metode untuk menghitung total bayar setelah diskon
    private double calculateTotalBayar(double totalRent) {
        double diskon = 0;
        if (totalRent > 10000000) {
            diskon = totalRent * 0.07;
        } else if (totalRent > 5000000) {
            diskon = totalRent * 0.05;
        }
        return totalRent - diskon;
    }
}
