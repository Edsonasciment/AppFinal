package com.mt.tecinfo.finalapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityMedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        final EditText n1 = (EditText) findViewById(R.id.editText8);
        final EditText n2 = (EditText) findViewById(R.id.editText12);
        final EditText n3 = (EditText) findViewById(R.id.editText10);
        final EditText n4 = (EditText) findViewById(R.id.editText11);
        final Button calc = (Button) findViewById(R.id.btn_calc);
        final EditText display = (EditText) findViewById(R.id.editText5);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double v1 = Double.parseDouble(n1.getText().toString());
                double v2 = Double.parseDouble(n2.getText().toString());
                double v3 = Double.parseDouble(n3.getText().toString());
                double v4 = Double.parseDouble(n4.getText().toString());

                double calculo = (v1+v2+v3+v4)/4;
                String resul = Double.toString(calculo);
                display.setText(resul);


            }
        });
    }
}
