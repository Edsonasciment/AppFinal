package com.mt.tecinfo.finalapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityChamada extends AppCompatActivity {

    String memoria = "";
    TextView text_Numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamada);

        text_Numero = (TextView) findViewById(R.id.text_Numero);
        final Button btn_Apagar = (Button) findViewById(R.id.btn_Apagar);

        final Button btn_N1 = (Button) findViewById(R.id.btn_N1);
        final Button btn_N2 = (Button) findViewById(R.id.btn_N2);
        final Button btn_N3 = (Button) findViewById(R.id.btn_N3);
        final Button btn_N4 = (Button) findViewById(R.id.btn_N4);
        final Button btn_N5 = (Button) findViewById(R.id.btn_N5);
        final Button btn_N6 = (Button) findViewById(R.id.btn_N6);
        final Button btn_N7 = (Button) findViewById(R.id.btn_N7);
        final Button btn_N8 = (Button) findViewById(R.id.btn_N8);
        final Button btn_N9 = (Button) findViewById(R.id.btn_N9);

        final Button btn_Ponto = (Button) findViewById(R.id.btn_Ponto);
        final Button btn_0 = (Button) findViewById(R.id.btn_0);
        final Button btn_Ast = (Button) findViewById(R.id.btn_Ast);
        final Button btn_Ligar = (Button) findViewById(R.id.btn_Ligar);


        btn_0.setOnClickListener(myListener);
        btn_N1.setOnClickListener(myListener);
        btn_N2.setOnClickListener(myListener);
        btn_N3.setOnClickListener(myListener);
        btn_N4.setOnClickListener(myListener);
        btn_N5.setOnClickListener(myListener);
        btn_N6.setOnClickListener(myListener);
        btn_N7.setOnClickListener(myListener);
        btn_N8.setOnClickListener(myListener);
        btn_N9.setOnClickListener(myListener);
        btn_Ponto.setOnClickListener(myListener);
        btn_Ast.setOnClickListener(myListener);
        btn_Apagar.setOnClickListener(myListener);
        btn_Ligar.setOnClickListener(myListener);


    }

    private View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_0:
                    setDisplayText("0");
                    break;
                case R.id.btn_N1:
                    setDisplayText("1");
                    break;
                case R.id.btn_N2:
                    setDisplayText("2");
                    break;
                case R.id.btn_N3:
                    setDisplayText("3");
                    break;
                case R.id.btn_N4:
                    setDisplayText("4");
                    break;
                case R.id.btn_N5:
                    setDisplayText("5");
                    break;
                case R.id.btn_N6:
                    setDisplayText("6");
                    break;
                case R.id.btn_N7:
                    setDisplayText("7");
                    break;
                case R.id.btn_N8:
                    setDisplayText("8");
                    break;
                case R.id.btn_N9:
                    setDisplayText("9");
                    break;
                case R.id.btn_Ast:
                    setDisplayText("*");
                    break;
                case R.id.btn_Ponto:
                    setDisplayText(".");
                    break;
                case R.id.btn_Apagar:
                    if (memoria.length()>0){
                        memoria = memoria.substring(0, memoria.length() -1);
                        text_Numero.setText(memoria);
                    }
                    break;

                case R.id.btn_Ligar:

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + memoria));

                    if (ActivityCompat.checkSelfPermission(ActivityChamada.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(ActivityChamada.this,
                                new String[]{Manifest.permission.CALL_PHONE}, 0);
                    }

                    startActivity(intent);


                    break;


            }
        }
    };

    private void setDisplayText(String valor) {
        memoria = memoria + valor;
        text_Numero.setText(memoria);
    }
}
