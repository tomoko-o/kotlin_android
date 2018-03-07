package com.usaco_pg.memoapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by tomoko on 2017/10/10.
 */

class TestOpenHelper(c: Context) : SQLiteOpenHelper(c, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
        db.execSQL(INIT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }

    companion object {
        val DB_NAME = "myapp.db"
        val DB_VERSION = 1

        val CREATE_TABLE = "create table memos (" +
                "_id integer primary key autoincrement, " +
                "title text, " +
                "body text, " +
                "created datetime default current_timestamp, " +
                "updated datetime default current_timestamp)"
        val INIT_TABLE = "insert into memos (title, body) values " +
                "('t1', 'b1'), " +
                "('t2', 'b2'), " +
                "('t3', 'b3')"
        val DROP_TABLE = "drop table if exists memo"
    }
}
