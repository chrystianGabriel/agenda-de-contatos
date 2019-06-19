package com.example.agendadecontatos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {
    var dao:AgendaDAO? = null;
    var agenda:Agenda? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.dao = AgendaDAO(applicationContext);
        this.agenda =  this.dao?.recuperarAgenda();
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
