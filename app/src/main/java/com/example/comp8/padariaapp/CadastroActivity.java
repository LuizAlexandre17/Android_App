package com.example.comp8.padariaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {
    private EditText cad_nome;
    private EditText cad_email;
    private EditText cad_sobrenome;
    private EditText cad_senha;
    private Button btn_cad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        cad_nome = (EditText) findViewById(R.id.cadastro_nome);
        cad_sobrenome = (EditText) findViewById(R.id.cadastro_sobrenome);
        cad_email = (EditText) findViewById(R.id.cadastro_email);
        cad_senha = (EditText) findViewById(R.id.cadastro_senha);
        btn_cad = (Button) findViewById(R.id.btn_continuar);

        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(CadastroActivity.this);
        cad_nome.setText(preferences.getString(Util.KEY_USER,"NAO EXISTE CHAVE"));

        btn_cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cad_nome.getText().toString().isEmpty() || cad_email.getText().toString().isEmpty() || cad_senha.getText().toString().isEmpty() || cad_sobrenome.getText().toString().isEmpty()){

                }
                else {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(CadastroActivity.this);
                    SharedPreferences.Editor edit = preferences.edit();
                    edit.putString(Util.KEY_USER,cad_nome.getText().toString());
                    edit.putString(Util.KEY_SENHA,cad_senha.getText().toString());
                    edit.putString(Util.KEY_EMAIL,cad_email.getText().toString());
                    edit.putString(Util.KEY_SOBRENOME,cad_sobrenome.getText().toString());
                    Toast.makeText(CadastroActivity.this, "Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();

                    edit.apply();

                    Intent it = new Intent(CadastroActivity.this, mainActivity.class);
                    startActivity(it);
                }
            }
        });
    }
}
