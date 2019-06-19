package com.example.agendadecontatos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_adicionar.*
import java.lang.Math.random

class activity_adicionar : AppCompatActivity() {

    var contato:Contatos? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar)

        if(intent.extras != null){
            this.contato = intent.extras.get("CONTATOS") as Contatos?;
            editText_nome.setText(this.contato?.nome);
            editText_email.setText(this.contato?.email);
            editText_telefone.setText(this.contato?.telefone);
            txtTitulo.text = "Editar Contato";
            button_confirmar.setOnClickListener{atualizarContato()};
            button_remover.visibility = View.VISIBLE;
        }else{
            txtTitulo.text = "Cadastrar Contato";
            button_confirmar.setOnClickListener{cadastrarContato()};
            button_remover.visibility = View.INVISIBLE;
        }
    }

    fun cadastrarContato(){
        var contato = Contatos();
        var dao = AgendaDAO(applicationContext);
        contato.id = (0..1000).random();
        contato.nome = editText_nome.text.toString();
        contato.email = editText_email.text.toString();
        contato.telefone = editText_telefone.text.toString();
        dao.salvarContato(contato);
        finish();
    }

    fun cancelar(view:View){
        finish();
    }

    fun atualizarContato(){
        var dao = AgendaDAO(applicationContext);
        this.contato?.nome = editText_nome.text.toString();
        this.contato?.email = editText_email.text.toString();
        this.contato?.telefone = editText_telefone.text.toString();
        dao.atualizarContato(this.contato as Contatos);
        finish();
    }

    fun removerContato(view:View){
        var dao = AgendaDAO(applicationContext);
        dao.removerContato(this.contato?.id as Int);
        finish();

    }
}
