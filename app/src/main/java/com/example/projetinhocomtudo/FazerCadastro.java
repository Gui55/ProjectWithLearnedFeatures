package com.example.projetinhocomtudo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FazerCadastro extends AppCompatActivity {

    EditText editNome, editSobrenome, editEmail, editSenha, editConfirmaSenha; //OS EDIT TEXTS

    Button botaoCadastro; //BOTÃO DE CADASTRO
    UsuarioDAO usuarioDAO; //OBJETO DAO PARA ACESSAR O BANCO DE DADOS DO USUÁRIO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_cadastro);


        //COLOCANDO O OBJETO DAO EM UMA VARIÁVEL

        usuarioDAO = Room.databaseBuilder(this, UsuarioDatabase.class, "userDB")
                .allowMainThreadQueries().build().usuarioDAO();



        //COLOCANDO OS EDITTEXTS NAS VARIÁVEIS

        editNome = (EditText)findViewById(R.id.enterCadastroNome);
        editSobrenome = (EditText)findViewById(R.id.enterCadastroSobrenome);
        editEmail = (EditText)findViewById(R.id.enterCadastroEmail);


        //COLOCANDO OS BOTÕES NAS VARIÁVEIS

        botaoCadastro=(Button)findViewById(R.id.buttonCadastrar);


        //AÇÃO DO BOTÃO DE CADASTRO

        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FazerCadastro.class));
            }
        });
    }
}
