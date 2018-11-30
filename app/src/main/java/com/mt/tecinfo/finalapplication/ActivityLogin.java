package com.mt.tecinfo.finalapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {
    SharedPreferences meusDados;
    public static final String mypreference = "call";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        meusDados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        Button btnLogin = findViewById(R.id.btn_Login);
        TextView btn_Cadastrar = findViewById(R.id.txt_Registrar);
        final EditText email = findViewById(R.id.edt_Email);
        final EditText senha = findViewById(R.id.edt_NovaSenha);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String meuEmail = email.getText().toString();
                String minhaSenha = senha.getText().toString();

                if (meusDados.contains("email") && meusDados.contains("senha")) {

                    if (meuEmail.equals(meusDados.getString("email", ""))
                            && minhaSenha.equals(meusDados.getString("senha", "")) ) {

                        Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Email ou senha invalidos", Toast.LENGTH_LONG).show();

                    }



                } else {
                    Toast.makeText(getApplicationContext(),"Não existem cadastros!", Toast.LENGTH_LONG).show();

                }



            }
        });

        btn_Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityRegistrar.class);
                startActivity(intent);
                finish();
            }
        });




    }
}
