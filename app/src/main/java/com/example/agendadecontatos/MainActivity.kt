package com.example.agendadecontatos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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

        val list : ListView = findViewById(R.id.list_contatos) as ListView
        val adapter = ListViewAdapater(this, R.layout.layout_contato, this.agenda?.contatos as ArrayList<Contatos>)
        list.adapter = adapter
        var itemDaLista:Contatos? = null;
        list.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                itemDaLista = list.getItemAtPosition(position) as Contatos;
                val intent = Intent(baseContext, activity_adicionar::class.java)
                intent.putExtra("CONTATOS",agenda?.getContato(itemDaLista?.id as Int));
                startActivity(intent)
                agenda =  dao?.recuperarAgenda();
            }
        }

    }

    fun click_adicionar(view : View){
        val intent = Intent(this, activity_adicionar::class.java)
        startActivity(intent)
        this.agenda =  this.dao?.recuperarAgenda();


    }

    fun click_editar(view:View){


    }
}
