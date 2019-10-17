package com.renecabanas.testrappi.themoviedb.data.movie;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import io.reactivex.Flowable;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMovie;

  public MovieDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovie = new EntityInsertionAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `movies`(`id`,`originalTitle`,`posterPath`,`overview`,`voteAverage`,`popularity`,`releaseDate`,`favorite`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getOriginalTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOriginalTitle());
        }
        if (value.getPosterPath() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPosterPath());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getVoteAverage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getVoteAverage());
        }
        if (value.getPopularity() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getPopularity());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getReleaseDate());
        }
        if (value.getFavorite() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getFavorite());
        }
      }
    };
  }

  @Override
  public void insertAll(List<Movie> arg0) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMovie.insert(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertMovie(Movie arg0) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMovie.insert(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<Movie>> loadPopular() {
    final String _sql = "SELECT * FROM movies ORDER BY popularity DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"movies"}, new Callable<List<Movie>>() {
      public List<Movie> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfOriginalTitle = _cursor.getColumnIndexOrThrow("originalTitle");
          final int _cursorIndexOfPosterPath = _cursor.getColumnIndexOrThrow("posterPath");
          final int _cursorIndexOfOverview = _cursor.getColumnIndexOrThrow("overview");
          final int _cursorIndexOfVoteAverage = _cursor.getColumnIndexOrThrow("voteAverage");
          final int _cursorIndexOfPopularity = _cursor.getColumnIndexOrThrow("popularity");
          final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
          final int _cursorIndexOfFavorite = _cursor.getColumnIndexOrThrow("favorite");
          final List<Movie> _result = new ArrayList<Movie>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Movie _item;
            _item = new Movie();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpOriginalTitle;
            _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
            _item.setOriginalTitle(_tmpOriginalTitle);
            final String _tmpPosterPath;
            _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            _item.setPosterPath(_tmpPosterPath);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            _item.setOverview(_tmpOverview);
            final Double _tmpVoteAverage;
            if (_cursor.isNull(_cursorIndexOfVoteAverage)) {
              _tmpVoteAverage = null;
            } else {
              _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            }
            _item.setVoteAverage(_tmpVoteAverage);
            final Double _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            }
            _item.setPopularity(_tmpPopularity);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            _item.setReleaseDate(_tmpReleaseDate);
            final Integer _tmpFavorite;
            if (_cursor.isNull(_cursorIndexOfFavorite)) {
              _tmpFavorite = null;
            } else {
              _tmpFavorite = _cursor.getInt(_cursorIndexOfFavorite);
            }
            _item.setFavorite(_tmpFavorite);
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

  @Override
  public Flowable<List<Movie>> loadTopRated() {
    final String _sql = "SELECT * FROM movies ORDER BY voteAverage DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"movies"}, new Callable<List<Movie>>() {
      public List<Movie> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfOriginalTitle = _cursor.getColumnIndexOrThrow("originalTitle");
          final int _cursorIndexOfPosterPath = _cursor.getColumnIndexOrThrow("posterPath");
          final int _cursorIndexOfOverview = _cursor.getColumnIndexOrThrow("overview");
          final int _cursorIndexOfVoteAverage = _cursor.getColumnIndexOrThrow("voteAverage");
          final int _cursorIndexOfPopularity = _cursor.getColumnIndexOrThrow("popularity");
          final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
          final int _cursorIndexOfFavorite = _cursor.getColumnIndexOrThrow("favorite");
          final List<Movie> _result = new ArrayList<Movie>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Movie _item;
            _item = new Movie();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpOriginalTitle;
            _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
            _item.setOriginalTitle(_tmpOriginalTitle);
            final String _tmpPosterPath;
            _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            _item.setPosterPath(_tmpPosterPath);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            _item.setOverview(_tmpOverview);
            final Double _tmpVoteAverage;
            if (_cursor.isNull(_cursorIndexOfVoteAverage)) {
              _tmpVoteAverage = null;
            } else {
              _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            }
            _item.setVoteAverage(_tmpVoteAverage);
            final Double _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            }
            _item.setPopularity(_tmpPopularity);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            _item.setReleaseDate(_tmpReleaseDate);
            final Integer _tmpFavorite;
            if (_cursor.isNull(_cursorIndexOfFavorite)) {
              _tmpFavorite = null;
            } else {
              _tmpFavorite = _cursor.getInt(_cursorIndexOfFavorite);
            }
            _item.setFavorite(_tmpFavorite);
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

  @Override
  public Flowable<List<Movie>> loadFavorite() {
    final String _sql = "SELECT * FROM movies WHERE favorite=1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"movies"}, new Callable<List<Movie>>() {
      public List<Movie> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfOriginalTitle = _cursor.getColumnIndexOrThrow("originalTitle");
          final int _cursorIndexOfPosterPath = _cursor.getColumnIndexOrThrow("posterPath");
          final int _cursorIndexOfOverview = _cursor.getColumnIndexOrThrow("overview");
          final int _cursorIndexOfVoteAverage = _cursor.getColumnIndexOrThrow("voteAverage");
          final int _cursorIndexOfPopularity = _cursor.getColumnIndexOrThrow("popularity");
          final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
          final int _cursorIndexOfFavorite = _cursor.getColumnIndexOrThrow("favorite");
          final List<Movie> _result = new ArrayList<Movie>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Movie _item;
            _item = new Movie();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpOriginalTitle;
            _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
            _item.setOriginalTitle(_tmpOriginalTitle);
            final String _tmpPosterPath;
            _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            _item.setPosterPath(_tmpPosterPath);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            _item.setOverview(_tmpOverview);
            final Double _tmpVoteAverage;
            if (_cursor.isNull(_cursorIndexOfVoteAverage)) {
              _tmpVoteAverage = null;
            } else {
              _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            }
            _item.setVoteAverage(_tmpVoteAverage);
            final Double _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            }
            _item.setPopularity(_tmpPopularity);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            _item.setReleaseDate(_tmpReleaseDate);
            final Integer _tmpFavorite;
            if (_cursor.isNull(_cursorIndexOfFavorite)) {
              _tmpFavorite = null;
            } else {
              _tmpFavorite = _cursor.getInt(_cursorIndexOfFavorite);
            }
            _item.setFavorite(_tmpFavorite);
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

  @Override
  public Flowable<List<Movie>> loadById(long arg0) {
    final String _sql = "SELECT * FROM movies WHERE id=? LIMIT 0,1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, arg0);
    return RxRoom.createFlowable(__db, new String[]{"movies"}, new Callable<List<Movie>>() {
      public List<Movie> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfOriginalTitle = _cursor.getColumnIndexOrThrow("originalTitle");
          final int _cursorIndexOfPosterPath = _cursor.getColumnIndexOrThrow("posterPath");
          final int _cursorIndexOfOverview = _cursor.getColumnIndexOrThrow("overview");
          final int _cursorIndexOfVoteAverage = _cursor.getColumnIndexOrThrow("voteAverage");
          final int _cursorIndexOfPopularity = _cursor.getColumnIndexOrThrow("popularity");
          final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
          final int _cursorIndexOfFavorite = _cursor.getColumnIndexOrThrow("favorite");
          final List<Movie> _result = new ArrayList<Movie>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Movie _item;
            _item = new Movie();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpOriginalTitle;
            _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
            _item.setOriginalTitle(_tmpOriginalTitle);
            final String _tmpPosterPath;
            _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            _item.setPosterPath(_tmpPosterPath);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            _item.setOverview(_tmpOverview);
            final Double _tmpVoteAverage;
            if (_cursor.isNull(_cursorIndexOfVoteAverage)) {
              _tmpVoteAverage = null;
            } else {
              _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            }
            _item.setVoteAverage(_tmpVoteAverage);
            final Double _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            }
            _item.setPopularity(_tmpPopularity);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            _item.setReleaseDate(_tmpReleaseDate);
            final Integer _tmpFavorite;
            if (_cursor.isNull(_cursorIndexOfFavorite)) {
              _tmpFavorite = null;
            } else {
              _tmpFavorite = _cursor.getInt(_cursorIndexOfFavorite);
            }
            _item.setFavorite(_tmpFavorite);
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
