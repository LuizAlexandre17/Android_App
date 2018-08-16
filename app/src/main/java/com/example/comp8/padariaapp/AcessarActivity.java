package com.example.comp8.padariaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AcessarActivity extends AppCompatActivity {

    private TextView btn_cad;
    private EditText log_user;
    private EditText log_senha;
    private Button btn_entrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acessar);

        btn_cad = (TextView) findViewById(R.id.tv_cad);
        log_user = (EditText) findViewById(R.id.log_user);
        log_senha = (EditText) findViewById(R.id.log_senha);
        btn_entrar = (Button) findViewById(R.id.btn_continuar);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AcessarActivity.this, "Autenticando", Toast.LENGTH_SHORT).show();
                if (log_user.getText().toString().matches("admin") && (log_senha.getText().toString().matches("admin"))) {
                    Intent it = new Intent(AcessarActivity.this, mainActivity.class);
                    startActivity(it);
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(AcessarActivity.this).create();
                    alertDialog.setTitle("Alerta de Senha");
                    alertDialog.setMessage("Usuario ou Senha Incorretos");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Tentar Novamente",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });

    }


    public void onClick(View view) {
        Intent it = new Intent(AcessarActivity.this, CadastroActivity.class);
        startActivity(it);
    }
}
