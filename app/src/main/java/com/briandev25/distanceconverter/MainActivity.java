package com.briandev25.distanceconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
   Button ansButton, rptButton;
   EditText getDistance;
   TextView showAns;
   RadioButton d2m,m2d;
   Double x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansButton = (Button)findViewById(R.id.ansButton);
        rptButton = (Button)findViewById(R.id.rptButton);
        getDistance = (EditText)findViewById(R.id.getDistance);
        showAns = (TextView)findViewById(R.id.showAns);
        d2m = (RadioButton)findViewById(R.id.d2m);
        m2d = (RadioButton)findViewById(R.id.m2d);
        ansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getDistance.getText().toString().isEmpty()){
                    showAns.setText("Please Enter Distance");
                }
                else{
                    x = Double.parseDouble(String.valueOf(getDistance.getText()));
                    if(d2m.isChecked()){
                        x = (x * 0.621371);
                        x = Double.parseDouble(new DecimalFormat("##.HHH").format(x));
                        showAns.setText(String.valueOf(x) + "Miles");
                    }
                    else if(m2d.isChecked()){
                        x = (x * 1.60934);
                        x = Double.parseDouble(new DecimalFormat("##.HHH").format(x));
                        showAns.setText(String.valueOf(x) + "Kilometers");
                    }
                    else{
                        showAns.setText("Please select an option");
                    }
                }
            }
        });
        rptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAns.setText("0.0");
                getDistance.setText("Enter Distance");
                d2m.setChecked(false);
                m2d.setChecked(false);
            }
        });
    }
}