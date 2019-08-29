package com.example.projetinhocomtudo;

import android.database.Cursor;
import android.graphics.Bitmap;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class UsuarioDAO_Impl implements UsuarioDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUsuario;

  private final SharedSQLiteStatement __preparedStmtOfApagarTudo;

  public UsuarioDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUsuario = new EntityInsertionAdapter<Usuario>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Usuario`(`id`,`nome`,`sobreNome`,`usuario`,`email`,`senha`,`foto`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Usuario value) {
        stmt.bindLong(1, value.getId());
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        if (value.getSobreNome() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSobreNome());
        }
        if (value.getUsuario() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUsuario());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEmail());
        }
        if (value.getSenha() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSenha());
        }
        final String _tmp;
        _tmp = ConversorDeTipos.bitmapParaString(value.getFoto());
        if (_tmp == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp);
        }
      }
    };
    this.__preparedStmtOfApagarTudo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM usuario";
        return _query;
      }
    };
  }

  @Override
  public void insert(Usuario... usuario) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUsuario.insert(usuario);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void apagarTudo() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfApagarTudo.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfApagarTudo.release(_stmt);
    }
  }

  @Override
  public List<Usuario> getUsuarios() {
    final String _sql = "SELECT * FROM usuario";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNome = _cursor.getColumnIndexOrThrow("nome");
      final int _cursorIndexOfSobreNome = _cursor.getColumnIndexOrThrow("sobreNome");
      final int _cursorIndexOfUsuario = _cursor.getColumnIndexOrThrow("usuario");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfSenha = _cursor.getColumnIndexOrThrow("senha");
      final int _cursorIndexOfFoto = _cursor.getColumnIndexOrThrow("foto");
      final List<Usuario> _result = new ArrayList<Usuario>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Usuario _item;
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        final String _tmpSobreNome;
        _tmpSobreNome = _cursor.getString(_cursorIndexOfSobreNome);
        final String _tmpUsuario;
        _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpSenha;
        _tmpSenha = _cursor.getString(_cursorIndexOfSenha);
        final Bitmap _tmpFoto;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfFoto);
        _tmpFoto = ConversorDeTipos.stringParaBitmap(_tmp);
        _item = new Usuario(_tmpNome,_tmpSobreNome,_tmpUsuario,_tmpEmail,_tmpSenha,_tmpFoto);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
