package com.example.projetinhocomtudo;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

//CLASSE QUE REPRESENTA O BANCO DE DADOS DOS USUÁRIOS

//AQUI SE ENCONTRA UM OBJETO DAO, INSTANCIADO DA INTERFACE UsuarioDAO

@Database(entities = {Usuario.class}, version = 1, exportSchema = false)

@TypeConverters({ConversorDeTipos.class})
public abstract class UsuarioDatabase extends RoomDatabase {

    public abstract UsuarioDAO usuarioDAO();

}
