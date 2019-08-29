package com.example.projetinhocomtudo;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

//ESSA É A INTERFACE QUE REPRESENTA O DATA ACCESS OBJECT DO BANCO DE DADOS DOS USUÁRIOS

@Dao
public interface UsuarioDAO {

    //Inserir um ou mais elementos
    @Insert
    void insert(Usuario... usuario);

    //Deletar Tudo
    @Query("DELETE FROM usuario")
    void apagarTudo();

    //Pegar todos os elementos e guardá-los em uma lista retornada pelo método getUsuarios()
    @Query("SELECT * FROM usuario")
    List<Usuario> getUsuarios();

}
