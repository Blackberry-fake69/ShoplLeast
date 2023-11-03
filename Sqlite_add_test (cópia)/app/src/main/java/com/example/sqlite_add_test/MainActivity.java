package com.example.sqlite_add_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button AdicionarTeste,ConcluirLista;

    TextView Testename;


    BandoDeDados Mydb;
    ArrayList <String> Colunaid, Colunaproduto, Colunapreco;

    Adaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);

        Testename = findViewById(R.id.testename);


        AdicionarTeste = findViewById(R.id.AdicionarTest);

        AdicionarTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Funcionalidade extra teste

                Intent intent = new Intent(MainActivity.this, Add_lista.class);
                startActivity(intent);



            }
        });

        ConcluirLista = findViewById(R.id.btnConcluirLista);

        ConcluirLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Mydb.deletarTodosOsItens();

                Intent intent = new Intent(MainActivity.this, TelaInicial.class);
                startActivity(intent);


            }
        });




        Mydb = new BandoDeDados(MainActivity.this);
        Colunaid = new ArrayList<>();
        Colunaproduto = new ArrayList<>();
        Colunapreco = new ArrayList<>();

        armazenadorDeDadosDeArray();

        adaptador = new Adaptador(MainActivity.this,Colunaid,Colunaproduto,Colunapreco);
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager( new LinearLayoutManager(MainActivity.this));



    }

    public void armazenadorDeDadosDeArray(){
        Cursor cursor = Mydb.LerTodoBanco();

        if(cursor.getCount() == 0){

            Toast.makeText(this, "Sem nenhum dado", Toast.LENGTH_SHORT).show();

        }
        else
        {

            while(cursor.moveToNext()){

                //Bug que ocorreu devido a remoção da coluna categoria ( ???? )
                //Não está afetando as funcionalidades ( olhar dps )
                Colunaid.add(cursor.getString(0));
                Colunaproduto.add(cursor.getString(2));
                Colunapreco.add(cursor.getString(3));

            }

        }

    }

}