package com.example.agendadecontatos

class Agenda{
    var contatos = ArrayList<Contatos>();

    fun adicionarContato(contato:Contatos){
        this.contatos.add(contato);
    }

    fun removerContato(contato:Contatos){
        this.contatos.remove(contato);
    }

    fun getContato(id:Int):Contatos{
        return Contatos();
    }

    fun alterarContato(id:Int,contato:Contatos){
        val c = this.contatos.filter { contato -> contato.id == id }.single();
        c.nome     = contato.nome;
        c.email    = contato.email;
        c.telefone = contato.telefone;
    }
}