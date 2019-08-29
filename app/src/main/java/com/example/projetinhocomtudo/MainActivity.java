package com.example.projetinhocomtudo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static UsuarioDAO usuarioDAO; // OBJETO DAO PARA ACESSAR O BANCO DE DADOS DE USUÁRIO

    private Button btnTelaCadastro, botaoLogin; //BOTÕES
    private EditText enterUsuario, enterSenha; //OS CAMPOS DE ENTRADA DE TEXTO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //COLOCANDO UM DAO NA VARIÁVEL

        usuarioDAO = Room.databaseBuilder(getApplicationContext(),
                UsuarioDatabase.class, "userDB").allowMainThreadQueries().build()
                .usuarioDAO();


        //COLOCANDO OS BOTÕES NAS VARIÁVEIS

        btnTelaCadastro =(Button)findViewById(R.id.buttonParaTelaDeCadastro);
        botaoLogin=(Button)findViewById(R.id.loginButton);


        //COLOCANDO OS EDITTEXTS NAS VARIÁVEIS

        enterUsuario=(EditText)findViewById(R.id.enterUser);
        enterSenha=(EditText)findViewById(R.id.enterPassWord);


        //AÇÃO DO BOTÃO PARA IR À ACTIVITY DE CADASTRO

        btnTelaCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),FazerCadastro.class));

            }
        });

    }
}
