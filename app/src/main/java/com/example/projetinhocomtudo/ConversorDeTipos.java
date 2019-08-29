package com.example.projetinhocomtudo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;

public class ConversorDeTipos {

    @TypeConverter //Converter de String para Bitmap

    public static Bitmap stringParaBitmap(String s){

        try{

            byte[] encodeByte = Base64.decode(s, Base64.DEFAULT);
            Bitmap imagem = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return imagem;


        } catch (Exception e){
            e.getMessage();
            return null;
        }

    }

    @TypeConverter //De Bitmap para String

    public static String bitmapParaString(Bitmap imagemASerConvertida){

        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        imagemASerConvertida.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp=Base64.encodeToString(b, Base64.DEFAULT);
        return temp;

    }

}
