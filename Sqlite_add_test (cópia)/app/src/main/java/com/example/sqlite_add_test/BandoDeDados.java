package com.example.sqlite_add_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BandoDeDados extends SQLiteOpenHelper {

    private Context context;


    public static final String Bancodedados = "Banco.db";
    public static final int Bancodedadosversao = 1;



    public static final String Tabela = "MinhaLista";
    public static final String Colunaid = "_id";
    public static final String Colunaproduto = "Produto";
    public static final String Colunapreco = "Preço";

    //Teste para criar o consultar de forma dinâmica ( falhou, implemente de outra maneira )



    public BandoDeDados(@Nullable Context context) {

        super(context, Bancodedados, null, Bancodedadosversao);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Criação da minha ta
        String criandotable =

                "CREATE TABLE " + Tabela +
                        " (" + Colunaid + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Colunaproduto + " TEXT, " +
                        Colunapreco + " DECIMAL); ";

        db.execSQL(criandotable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int anterior, int atual) {

        //Remove a ta
        db.execSQL("DROP TABLE IF EXISTS " + Tabela);

        //Cria a ta
        onCreate(db);

    }

    //Lembrar de remover comentários na versão final
    //Bug q fazia o app crashar ( Resolvido )
    public boolean ListAdic(String produto, String preco){

        //Teste da implementação proposta pelo professor ( Funcionou )
        boolean confirmacao = true;


        // Teste anticrash ( Funcionou )
        if(produto.equals(""))
        {

            String nomeproduto = "Informe o nome do produto";
            Toast.makeText(context,nomeproduto,Toast.LENGTH_SHORT).show();

        }

        else if(preco.equals(""))
        {

            String precoproduto = "Informe o preço do produto";
            Toast.makeText(context,precoproduto,Toast.LENGTH_SHORT).show();

        }

        else
        {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues itensadicionados = new ContentValues();



            itensadicionados.put(Colunaproduto, produto);
            itensadicionados.put(Colunapreco, preco);


            //Teste para ver se o item foi adicionado de fato

            long result = db.insert(Tabela, null, itensadicionados);
            if ( result == -1 )
            {

                Toast.makeText(context, "Falhou seu corno", Toast.LENGTH_SHORT).show();

            }

            else
            {

                Toast.makeText(context, "TESTE: ADICIONOU O ITEM", Toast.LENGTH_SHORT).show();

            }
            //confirmação para checar se
            return confirmacao;
        }

        return !confirmacao;
    }

    // Tentar mod
   /* public boolean Confirmacao(boolean confirma){

        return confirma;
    } */

    Cursor LerTodoBanco() {

        String selecionatudodatabela = "SELECT * FROM " + Tabela;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null ;


        if(db != null){

            cursor = db.rawQuery(selecionatudodatabela, null);
        }


        return cursor;

    }


    public void DeletarDados(String row_id){

        //pega o id do item na tabela e deleta
        SQLiteDatabase  db = this.getWritableDatabase();
        long result = db.delete(Tabela, "_id=?", new String[]{row_id});

        if(result == -1)
        {
            String falhou = "Não foi possível deletar";
            Toast.makeText(context, falhou,Toast.LENGTH_SHORT).show();

        }

        else
        {
            String funcionou = "Deletou com sucesso";
            Toast.makeText(context, funcionou,Toast.LENGTH_SHORT).show();

        }

    }

    public void deletarTodosOsItens(){

        SQLiteDatabase db = this.getWritableDatabase();
        String apagartudo = " DELETE FROM " + Tabela;


       // db.execSQL(checagem);
        // db.execSQL(criartabela);
        db.execSQL(apagartudo);

        //emoji test
        String msgfinalizou = " Voce finalizou a lista \uD83D\uDC80";

        Toast.makeText(context,msgfinalizou,Toast.LENGTH_SHORT).show();



        
    }



}
