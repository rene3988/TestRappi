package com.renecabanas.testrappi.themoviedb.data.review;

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

public class ReviewDao_Impl implements ReviewDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfReview;

  public ReviewDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReview = new EntityInsertionAdapter<Review>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `reviews`(`id`,`movieId`,`author`,`content`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Review value) {
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
        if (value.getAuthor() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAuthor());
        }
        if (value.getContent() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getContent());
        }
      }
    };
  }

  @Override
  public void insertAll(List<Review> arg0) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfReview.insert(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<Review>> loadReviews(long arg0) {
    final String _sql = "SELECT * FROM reviews WHERE movieId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, arg0);
    return RxRoom.createFlowable(__db, new String[]{"reviews"}, new Callable<List<Review>>() {
      public List<Review> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfMovieId = _cursor.getColumnIndexOrThrow("movieId");
          final int _cursorIndexOfAuthor = _cursor.getColumnIndexOrThrow("author");
          final int _cursorIndexOfContent = _cursor.getColumnIndexOrThrow("content");
          final List<Review> _result = new ArrayList<Review>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Review _item;
            _item = new Review();
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
            final String _tmpAuthor;
            _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            _item.setAuthor(_tmpAuthor);
            final String _tmpContent;
            _tmpContent = _cursor.getString(_cursorIndexOfContent);
            _item.setContent(_tmpContent);
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
