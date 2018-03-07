package com.usaco_pg.memoapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcel
import android.os.Parcelable
import android.provider.BaseColumns

/**
 * Created by tomoko on 2017/10/10.
 */
class MemoOpenHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "memo.db"
        val DB_VERSION = 1

        private val PRIMARY_KEY = " integer primary key autoincrement"
        private val TEXT_TYPE = " text"
        private val DATETIME_TYPE = " datetime default current_timestamp"

        private val SQL_CREATE_TABLE = "create table ${MemoContract.Memos.TABLE_NAME} (" +
                "${MemoContract.Memos._ID} $PRIMARY_KEY, " +
                "${MemoContract.Memos.COLUMN_TITLE} $TEXT_TYPE, " +
                "${MemoContract.Memos.COLUMN_BODY} $TEXT_TYPE, " +
                "${MemoContract.Memos.COLUMN_CREATED} $DATETIME_TYPE, " +
                "${MemoContract.Memos.COLUMN_UPDATED} $DATETIME_TYPE" +
                ")"

        private val SQL_INIT_TABLE = "insert into ${MemoContract.Memos.TABLE_NAME} (${MemoContract.Memos.COLUMN_TITLE}, ${MemoContract.Memos.COLUMN_BODY}) values " +
            "('title1', 'body1'), " +
            "('title2', 'body2'), " +
            "('title3', 'body3') "

        private val SQL_DROP_TABLE = "drop table if exists ${MemoContract.Memos.TABLE_NAME}"
    }

//    override fun onCreate(p0: SQLiteDatabase?) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE)
        db?.execSQL(SQL_INIT_TABLE)
    }

//    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DROP_TABLE)
        onCreate(db)
    }

}