package com.rixx.testtestweather;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rixx.metaweatherlibrary.MetaWeather;

public class MainActivity extends AppCompatActivity {
    EditText addCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCity = findViewById(R.id.inputcity);
    }

    public void getWeatherDetails(View view) {
        String city = addCity.getText().toString().trim();
        String ttt = MetaWeather.getCurrentWeather(city, getApplicationContext());
        Log.d("pogoda", ttt);
        if (!ttt.isEmpty()){
            openDialog(ttt, city);
        }
    }

    private void openDialog(String weatherOfCity, String city) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Погода в городе " + city);
        builder.setMessage(weatherOfCity + " ℃");
        builder.setNegativeButton("Закрыть", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}