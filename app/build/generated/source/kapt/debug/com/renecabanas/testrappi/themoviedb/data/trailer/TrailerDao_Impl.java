package com.renecabanas.testrappi.themoviedb.data.trailer;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import io.reactivex.Flowable;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class TrailerDao_Impl implements TrailerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTrailer;

  public TrailerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrailer = new EntityInsertionAdapter<Trailer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `trailers`(`id`,`movieId`,`key`,`name`,`site`,`type`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Trailer value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getMovieId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getMovieId());
        }
        if (value.getKey() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getKey());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getSite() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSite());
        }
        if (value.getType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getType());
        }
      }
    };
  }

  @Override
  public void insertAll(List<Trailer> arg0) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrailer.insert(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<Trailer>> loadTrailers(long arg0) {
    final String _sql = "SELECT * FROM trailers WHERE movieId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, arg0);
    return RxRoom.createFlowable(__db, new String[]{"trailers"}, new Callable<List<Trailer>>() {
      public List<Trailer> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfMovieId = _cursor.getColumnIndexOrThrow("movieId");
          final int _cursorIndexOfKey = _cursor.getColumnIndexOrThrow("key");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfSite = _cursor.getColumnIndexOrThrow("site");
          final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
          final List<Trailer> _result = new ArrayList<Trailer>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Trailer _item;
            _item = new Trailer();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final Long _tmpMovieId;
            if (_cursor.isNull(_cursorIndexOfMovieId)) {
              _tmpMovieId = null;
            } else {
              _tmpMovieId = _cursor.getLong(_cursorIndexOfMovieId);
            }
            _item.setMovieId(_tmpMovieId);
            final String _tmpKey;
            _tmpKey = _cursor.getString(_cursorIndexOfKey);
            _item.setKey(_tmpKey);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpSite;
            _tmpSite = _cursor.getString(_cursorIndexOfSite);
            _item.setSite(_tmpSite);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            _item.setType(_tmpType);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
