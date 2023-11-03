package com.example.sqlite_add_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Timer;

public class Add_lista extends AppCompatActivity {

    TextView Nomeproduto, Precoproduto,Testename;
    Button Add;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lista);

        Nomeproduto = findViewById(R.id.Nomeproduto);
        Precoproduto = findViewById(R.id.Precoproduto);


        Add = findViewById(R.id.atualizar);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                BandoDeDados myDB = new BandoDeDados(Add_lista.this);


              /*  myDB.Listaadd(

                        //Bug de espaço em branco no input ( Corrigido )
                        Nomeproduto.getText().toString().trim(),
                        String.valueOf(Precoproduto.getText().toString().trim())

                );*/


                //Implementação da solução proposta pelo professor ( Funcionou com bugs)
                //Correção ( Realizar adaptação )
                //adaptação realizada ( Concluido/Funcionou )
                if(myDB.ListAdic(Nomeproduto.getText().toString().trim(),
                        String.valueOf(Precoproduto.getText().toString().trim())))
                {

                    Intent intent = new Intent(Add_lista.this, MainActivity.class);
                    startActivity(intent);

                }



            }
        });

    }
}
