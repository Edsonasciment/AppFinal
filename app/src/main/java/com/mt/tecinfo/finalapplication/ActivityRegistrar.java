package com.mt.tecinfo.finalapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegistrar extends AppCompatActivity {

    SharedPreferences meusDados;
    public static final String mypreference = "call";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        meusDados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        final EditText novoEmail = findViewById(R.id.edt_novoEmail);
        final EditText novaSenha = findViewById(R.id.edt_NovaSenha);
        final EditText nome = (EditText) findViewById(R.id.edit_nome);
        final EditText cidade = (EditText) findViewById(R.id.edt_cidade);
        final EditText estado = (EditText) findViewById(R.id.edt_estado);
        final EditText endereco = (EditText) findViewById(R.id.edt_end);
        final EditText pais = (EditText) findViewById(R.id.edt_pais);
        final EditText ConfirmaSenha = findViewById(R.id.edt_Confirmar);
        Button cadastrar = findViewById(R.id.btn_Cadastrar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaSenha.getText().toString().equals(ConfirmaSenha.getText().toString())) {

                    SharedPreferences.Editor editor = meusDados.edit();
                    editor.putString("email", novoEmail.getText().toString());
                    editor.putString("senha", novaSenha.getText().toString());
                    editor.putString("nome", nome.getText().toString());
                    editor.putString("cidade", cidade.getText().toString());
                    editor.putString("estado", estado.getText().toString());
                    editor.putString("end", endereco.getText().toString());
                    editor.putString("pais", pais.getText().toString());

                    editor.commit();

                    Toast.makeText(getApplicationContext(),
                            "Dados salvos com sucesso!", Toast.LENGTH_LONG);

                    Intent intent = new Intent(ActivityRegistrar.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(),
                            "As senhas não conferem", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

}
