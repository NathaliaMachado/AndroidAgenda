package com.opensource.nathalia.myapplication;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathalia on 15/04/17.
 */

public class Controller {

    MainActivity mainActivity;


    public Controller(Object contatoActivity) {
        this.mainActivity = (MainActivity) contatoActivity;
    }

    public void add()
    {
        String value;
        EditText text;

        Contato contato = new Contato();
        text = (EditText) mainActivity.findViewById(R.id.editTextName);
        value = text.getText().toString();
        contato.setNome(value);
        text = (EditText)mainActivity.findViewById(R.id.editTextPhone);
        value = text.getText().toString();
        contato.setTelefone(value);
        text = (EditText)mainActivity.findViewById(R.id.editTextEmail);
        value = text.getText().toString();
        contato.setEmail(value);


        // TODO
        // codigo para passar objeto "contato" como parametro para o servlet

    }

    public Contato show()
    {
        List<Contato> contatos = new ArrayList<Contato>();
        contatos =
        return null;
    }

    public Contato find(String name)
    {
        // TODO
        // requisitar pag web > enviar a string como parametro > fazer um método
        // select no servlet para buscar no banco e retornar o objeto
        return null;
    }

    public void update(Contato contato)
    {
        // TODO
        // find(name);
        // namereturned.setName("");
        // namereturned.setPhone("");
        // namereturned.setEmail("");
    }

    public void remove()
    {

    }

}
