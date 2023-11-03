package com.example.sqlite_add_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicial extends AppCompatActivity {

    Button lista, consultar;
    BandoDeDados myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        lista = findViewById(R.id.criarLista);
        consultar = findViewById(R.id.consultarListas);


        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TelaInicial.this, MainActivity.class);
                startActivity(intent);

            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(TelaInicial.this, ConsultarLista.class);
                startActivity(intent);

            }
        });




    }
}