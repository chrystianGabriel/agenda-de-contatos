package com.example.agendadecontatos

import android.content.ContentValues
import android.content.Context
import android.os.Build.ID
import android.provider.BaseColumns

class AgendaDAO(context: Context) {

    val sqlite = SQLITE(context);
    fun salvarAgenda(agenda:Agenda){
        val db = this.sqlite.writableDatabase;
        db.execSQL("CREATE TABLE IF NOT EXISTS CONTATOS("          +
                        "ID INTEGER PRIMARY KEY," +
                        "NOME TEXT NULL,"              +
                        "TELEFONE TEXT NULL,"          +
                        "EMAIL TEXT NULL)");

        for(contato in agenda.contatos){
           val reg = ContentValues().apply{
               put("id",contato.id);
               put("nome",contato.nome);
               put("telefone",contato.telefone);
               put("email",contato.email);
           }

            val row = db.insert("CONTATOS",null,reg);
        }
    }

    fun recuperarAgenda():Agenda{
        var agenda = Agenda();
        val db = this.sqlite.readableDatabase;
        val cursor = db.query("CONTATOS",null,null,null,null,null,null);
        with(cursor){
            while(moveToNext()){
                var contato = Contatos();
                contato.id = getInt(0);
                contato.nome = getString(1);
                contato.telefone = getString(2)
                contato.email = getString(3);
                agenda.adicionarContato(contato);
            }
        }
        db.close();
        return agenda;
    }

    fun removerAgenda(){
        val db = this.sqlite.writableDatabase;
        db.execSQL("DROP TABLE CONTATOS");
        db.close();
    }

    fun atualizarContato(contato:Contatos){
        val db = this.sqlite.writableDatabase;
        val values = ContentValues();
        with(values){
            put("NOME",contato.nome);
            put("EMAIL",contato.email)
            put("TELEFONE",contato.telefone);
        }
        db.update("CONTATOS",values,"ID =? ",arrayOf(contato.id.toString()));
        db.close();
    }
}