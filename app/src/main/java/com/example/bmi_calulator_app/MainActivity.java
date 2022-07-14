package com.example.bmi_calulator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtHeightInches, edtWeight, edtHeightFeet;
    Button btnBMI;
    TextView txtResult;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWeight = (EditText)findViewById(R.id.edtWeight);
        edtHeightFeet = (EditText)findViewById(R.id.edtHeightFeet);
        edtHeightInches = (EditText)findViewById(R.id.edtHeightInches);
        btnBMI = (Button)findViewById(R.id.btnBMI);
        layout = (LinearLayout)findViewById(R.id.linearLayout);
        txtResult = (TextView)findViewById(R.id.txtResult);



        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight = Integer.parseInt(edtWeight.getText().toString());
                int heightFeet = Integer.parseInt(edtHeightFeet.getText().toString());
                int heightInches = Integer.parseInt(edtHeightInches.getText().toString());

                int totalInches = (heightFeet * 12) + heightInches;
                double totalInCentiMeter = (totalInches * 2.53);
                double totalInMeter = (totalInCentiMeter/100);

                double BMI = weight/(totalInMeter * totalInMeter);

                if(BMI > 25)
                {
                    txtResult.setText("You Are OverWeighted!");
                    layout.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else if (BMI < 18)
                {
                    txtResult.setText("You Are UnderWeighted!");
                    layout.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else
                {
                    txtResult.setText("You Are Healthy!");
                    layout.setBackgroundColor(getResources().getColor(R.color.blue));

                }

            }
        });
    }
}