package com.renecabanas.testrappi.themoviedb.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import com.renecabanas.testrappi.themoviedb.data.movie.MovieDao;
import com.renecabanas.testrappi.themoviedb.data.movie.MovieDao_Impl;
import com.renecabanas.testrappi.themoviedb.data.review.ReviewDao;
import com.renecabanas.testrappi.themoviedb.data.review.ReviewDao_Impl;
import com.renecabanas.testrappi.themoviedb.data.trailer.TrailerDao;
import com.renecabanas.testrappi.themoviedb.data.trailer.TrailerDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

public class ReneDB_Impl extends ReneDB {
  private volatile MovieDao _movieDao;

  private volatile ReviewDao _reviewDao;

  private volatile TrailerDao _trailerDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate() {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `movies` (`id` INTEGER, `originalTitle` TEXT, `posterPath` TEXT, `overview` TEXT, `voteAverage` REAL, `popularity` REAL, `releaseDate` TEXT, `favorite` INTEGER, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `reviews` (`id` TEXT, `movieId` INTEGER, `author` TEXT, `content` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `trailers` (`id` TEXT, `movieId` INTEGER, `key` TEXT, `name` TEXT, `site` TEXT, `type` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"b6131058342579ccadc18394353c3a2f\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `movies`");
        _db.execSQL("DROP TABLE IF EXISTS `reviews`");
        _db.execSQL("DROP TABLE IF EXISTS `trailers`");
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMovies = new HashMap<String, TableInfo.Column>(8);
        _columnsMovies.put("id", new TableInfo.Column("id", "INTEGER", 1));
        _columnsMovies.put("originalTitle", new TableInfo.Column("originalTitle", "TEXT", 0));
        _columnsMovies.put("posterPath", new TableInfo.Column("posterPath", "TEXT", 0));
        _columnsMovies.put("overview", new TableInfo.Column("overview", "TEXT", 0));
        _columnsMovies.put("voteAverage", new TableInfo.Column("voteAverage", "REAL", 0));
        _columnsMovies.put("popularity", new TableInfo.Column("popularity", "REAL", 0));
        _columnsMovies.put("releaseDate", new TableInfo.Column("releaseDate", "TEXT", 0));
        _columnsMovies.put("favorite", new TableInfo.Column("favorite", "INTEGER", 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMovies = new HashSet<TableInfo.ForeignKey>(0);
        final TableInfo _infoMovies = new TableInfo("movies", _columnsMovies, _foreignKeysMovies);
        final TableInfo _existingMovies = TableInfo.read(_db, "movies");
        if (! _infoMovies.equals(_existingMovies)) {
          throw new IllegalStateException("Migration didn't properly handle movies(com.renecabanas.testrappi.themoviedb.data.movie.Movie).\n"
                  + " Expected:\n" + _infoMovies + "\n"
                  + " Found:\n" + _existingMovies);
        }
        final HashMap<String, TableInfo.Column> _columnsReviews = new HashMap<String, TableInfo.Column>(4);
        _columnsReviews.put("id", new TableInfo.Column("id", "TEXT", 1));
        _columnsReviews.put("movieId", new TableInfo.Column("movieId", "INTEGER", 0));
        _columnsReviews.put("author", new TableInfo.Column("author", "TEXT", 0));
        _columnsReviews.put("content", new TableInfo.Column("content", "TEXT", 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReviews = new HashSet<TableInfo.ForeignKey>(0);
        final TableInfo _infoReviews = new TableInfo("reviews", _columnsReviews, _foreignKeysReviews);
        final TableInfo _existingReviews = TableInfo.read(_db, "reviews");
        if (! _infoReviews.equals(_existingReviews)) {
          throw new IllegalStateException("Migration didn't properly handle reviews(com.renecabanas.testrappi.themoviedb.data.review.Review).\n"
                  + " Expected:\n" + _infoReviews + "\n"
                  + " Found:\n" + _existingReviews);
        }
        final HashMap<String, TableInfo.Column> _columnsTrailers = new HashMap<String, TableInfo.Column>(6);
        _columnsTrailers.put("id", new TableInfo.Column("id", "TEXT", 1));
        _columnsTrailers.put("movieId", new TableInfo.Column("movieId", "INTEGER", 0));
        _columnsTrailers.put("key", new TableInfo.Column("key", "TEXT", 0));
        _columnsTrailers.put("name", new TableInfo.Column("name", "TEXT", 0));
        _columnsTrailers.put("site", new TableInfo.Column("site", "TEXT", 0));
        _columnsTrailers.put("type", new TableInfo.Column("type", "TEXT", 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrailers = new HashSet<TableInfo.ForeignKey>(0);
        final TableInfo _infoTrailers = new TableInfo("trailers", _columnsTrailers, _foreignKeysTrailers);
        final TableInfo _existingTrailers = TableInfo.read(_db, "trailers");
        if (! _infoTrailers.equals(_existingTrailers)) {
          throw new IllegalStateException("Migration didn't properly handle trailers(com.renecabanas.testrappi.themoviedb.data.trailer.Trailer).\n"
                  + " Expected:\n" + _infoTrailers + "\n"
                  + " Found:\n" + _existingTrailers);
        }
      }
    }, "b6131058342579ccadc18394353c3a2f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .version(1)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "movies","reviews","trailers");
  }

  @Override
  public MovieDao movieDao() {
    if (_movieDao != null) {
      return _movieDao;
    } else {
      synchronized(this) {
        if(_movieDao == null) {
          _movieDao = new MovieDao_Impl(this);
        }
        return _movieDao;
      }
    }
  }

  @Override
  public ReviewDao reviewDao() {
    if (_reviewDao != null) {
      return _reviewDao;
    } else {
      synchronized(this) {
        if(_reviewDao == null) {
          _reviewDao = new ReviewDao_Impl(this);
        }
        return _reviewDao;
      }
    }
  }

  @Override
  public TrailerDao trailerDao() {
    if (_trailerDao != null) {
      return _trailerDao;
    } else {
      synchronized(this) {
        if(_trailerDao == null) {
          _trailerDao = new TrailerDao_Impl(this);
        }
        return _trailerDao;
      }
    }
  }
}
