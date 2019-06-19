package com.example.agendadecontatos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var dao:AgendaDAO? = null;
    var agenda:Agenda? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.dao = AgendaDAO(applicationContext);
        this.agenda =  this.dao?.recuperarAgenda();


        var c1 = Contatos()
        c1.nome = "Teste 1"
        c1.telefone = "Teste tel 1"
        c1.email = "Test email 1"
        var c2 = Contatos()
        c1.nome = "Teste 2"
        c1.telefone = "Teste tel 2"
        c1.email = "Test email 2"
        val dados = ArrayList<Contatos>()
        dados.add(c1)
        dados.add(c2)

        val list : ListView = findViewById(R.id.list_contatos) as ListView
        val adapter = ListViewAdapater(this, R.layout.layout_contato, dados)
        list.adapter = adapter
    }

    fun click_adicionar(view : View){
        val intent = Intent(this, activity_adicionar::class.java)
        startActivity(intent)
        this.agenda =  this.dao?.recuperarAgenda();


    }

    fun click_editar(view:View){
        val intent = Intent(this, activity_adicionar::class.java)
        intent.putExtra("CONTATOS",this.agenda?.getContato(2));
        startActivity(intent)
        this.agenda =  this.dao?.recuperarAgenda();
    }
}
