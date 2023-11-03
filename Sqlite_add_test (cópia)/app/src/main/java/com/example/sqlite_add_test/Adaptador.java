package com.example.sqlite_add_test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {

    Context context;
    ArrayList colunaid, colunaproduto, colunapreco;

    //Apagar no adaptador ( Falhou )
 //  Button Apagar;


    Adaptador(Context context,
              ArrayList colunaid,
              ArrayList colunaproduto,
              ArrayList colunapreco)
    {

        this.context = context;
        this.colunaid = colunaid;
        this.colunaproduto = colunaproduto;
        this.colunapreco = colunapreco;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {


        holder.Colunaid_txt.setText(String.valueOf(colunaid.get(position)));
        holder.Colunaproduto_txt.setText(String.valueOf(colunaproduto.get(position)));
        holder.Colunapreco_txt.setText(String.valueOf(colunapreco.get(position)));

        //Bu
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Atualizar.class);

                intent.putExtra("id", String.valueOf(colunaid.get(position)));
                intent.putExtra("produto", String.valueOf(colunaproduto.get(position)));
                intent.putExtra("preco", String.valueOf(colunapreco.get(position)));

                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return colunaid.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Colunaid_txt, Colunaproduto_txt, Colunapreco_txt;
        //Button Apagar;
        LinearLayout mainLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Colunaid_txt = itemView.findViewById(R.id.Colunaid_txt);
            Colunaproduto_txt = itemView.findViewById(R.id.Colunanome_txt);
            Colunapreco_txt = itemView.findViewById(R.id.Colunapreco_txt);
            mainLayout = itemView.findViewById(R.id.linearLayout);


        }
    }

}
