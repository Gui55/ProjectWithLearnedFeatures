package com.example.projetinhocomtudo;


import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//CLASSE QUE REPRESENTA UMA TABELA/ENTIDADE DO BANCO DE DADOS DOS USUÁRIOS

@Entity
public class Usuario {

    //ATRIBUTOS

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String sobreNome;
    private String usuario;
    private String email;
    private String senha;

    private Bitmap foto;

    public Usuario(String nome, String sobreNome, String usuario, String email, String senha, Bitmap foto) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.foto = foto;
    }


    //GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

}
