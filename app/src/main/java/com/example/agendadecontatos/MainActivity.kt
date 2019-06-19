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
    var adapter:ListViewAdapater? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.dao = AgendaDAO(applicationContext);
        this.agenda =  this.dao?.recuperarAgenda();

        val list : ListView = findViewById(R.id.list_contatos) as ListView
        this?.adapter = ListViewAdapater(this, R.layout.layout_contato, this.agenda?.contatos as ArrayList<Contatos>)
        list.adapter = this?.adapter
        var itemDaLista:Contatos? = null;

        list.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                itemDaLista = list.getItemAtPosition(position) as Contatos;
                val intent = Intent(baseContext, activity_adicionar::class.java)
                intent.putExtra("CONTATOS",agenda?.getContato(itemDaLista?.id as Int));
                startActivity(intent);
            }
        }


    }

    fun click_adicionar(view : View){
        val intent = Intent(this, activity_adicionar::class.java)
        startActivity(intent)



    }

    fun click_atualizar(view:View){
        this.agenda =  this.dao?.recuperarAgenda();
        this.adapter?.clear();
        this.adapter?.addAll(this.agenda?.contatos);
        this.adapter?.notifyDataSetChanged();


    }
}
