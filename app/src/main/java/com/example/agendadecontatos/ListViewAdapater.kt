package com.example.agendadecontatos
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapater(
    private val getContext: Context,
    private val customLayoutId : Int,
    private val contatos_list : ArrayList<Contatos>)
    : ArrayAdapter<Contatos>(getContext, customLayoutId, contatos_list)
    {
        override  fun getView(position: Int, convertView : View?, parent: ViewGroup?) : View {
            var row = convertView
            var holder = ViewHolder()

            val inflater = (getContext as Activity).layoutInflater
            row = inflater!!.inflate(customLayoutId, parent, false)
            holder.nome = row!!.findViewById(R.id.textView_nome) as TextView
            holder.telefone = row!!.findViewById(R.id.textView_telefone) as TextView
            holder.email = row!!.findViewById(R.id.textView_email) as TextView

            val contato = contatos_list[position]
            holder.nome?.setText(contato.nome)
            holder.telefone?.setText(contato.telefone)
            holder.email?.setText(contato.email)
            return row

        }

        class ViewHolder
        {
            internal var nome : TextView? = null
            internal var telefone : TextView? = null
            internal var email : TextView? = null

        }
    }