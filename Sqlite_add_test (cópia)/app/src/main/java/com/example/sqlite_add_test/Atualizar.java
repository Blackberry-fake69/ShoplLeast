package com.example.sqlite_add_test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Atualizar extends AppCompatActivity {

    TextView Colunaprodutos,Colunapreco;

    //implementação extra
    Button  Deletar;
    String id,produto,preco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_atualizar);

        Colunaprodutos = findViewById(R.id.Nomeproduto2);
        Colunapreco = findViewById(R.id.Precoproduto2);
        Deletar = findViewById(R.id.deletar);
        pegaDadosDaIntent();


        Deletar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                BandoDeDados myDB = new BandoDeDados(Atualizar.this);
                myDB.DeletarDados(id);

                Intent intent = new Intent(Atualizar.this,MainActivity.class);
                startActivity(intent);

            }

        });



    }
    public void pegaDadosDaIntent(){

        if(getIntent().hasExtra("id") &&  getIntent().hasExtra("produto") &&  getIntent().hasExtra("preco") ){

            //Está pegando dados da intent

            id = getIntent().getStringExtra("id");
            produto = getIntent().getStringExtra("produto");
            preco = getIntent().getStringExtra("preco");

            //Colocando dados na itent
            Colunaprodutos.setText(produto);
            Colunapreco.setText(preco);

        }

        else{

            String nada = "Não tem nada";
            Toast.makeText(this, nada,Toast.LENGTH_SHORT).show();

        }
    }



}