package com.example.agendadecontatos

class Contatos{

    var nome = "";
    var email = "";
    var telefone = "";
    var id = 0;

    constructor(){

    }
    constructor(nome:String,email:String,telefone:String){
        this.nome     = nome;
        this.email    = email;
        this.telefone = telefone;
    }
}