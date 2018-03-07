package com.usaco_pg.memoapp

import android.content.ContentValues
import android.database.DatabaseUtils
import android.os.Bundle
import android.support.v4.widget.SimpleCursorAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val memoOpenHelper = MemoOpenHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

//        val db = memoOpenHelper.readableDatabase
//
//        // 読み込みたいカラム名を指定する
//        val projection = arrayOf(
//                MemoContract.Memos._ID,
//                MemoContract.Memos.COLUMN_TITLE,
//                MemoContract.Memos.COLUMN_BODY,
//                MemoContract.Memos.COLUMN_CREATED,
//                MemoContract.Memos.COLUMN_UPDATED
//        )
//
//        // sort を設定する
//        val sortOrder = "${MemoContract.Memos.COLUMN_CREATED} DESC"
//
//        // クエリを実行
//        val cursor = db.query(
//                MemoContract.Memos.TABLE_NAME,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                sortOrder
//        )

//        // 全件をDumpする
//        Log.d("ActivityMain: onCreate", DatabaseUtils.dumpCursorToString(cursor))
//        // 1件ずつ表示する
//        while (cursor.moveToNext()) {
//            Log.d("ActivityMain: onCreate", cursor.getString(cursor.getColumnIndex(MemoContract.Memos.COLUMN_TITLE)))
//        }
//        cursor.close()

        showMemoList()

        fab.setOnClickListener { _ ->
//            insertMemoData()
            updateMemoData()
//            deleteMemoData()
        }
    }

    private fun showMemoList() {
        val db = memoOpenHelper.readableDatabase

        // 読み込みたいカラム名を指定する
        val projection = arrayOf(
                MemoContract.Memos._ID,
                MemoContract.Memos.COLUMN_TITLE,
                MemoContract.Memos.COLUMN_BODY,
                MemoContract.Memos.COLUMN_CREATED,
                MemoContract.Memos.COLUMN_UPDATED
        )

        // sort を設定する
        val sortOrder = "${MemoContract.Memos.COLUMN_CREATED} DESC"

        // クエリを実行
        val cursor = db.query(
                MemoContract.Memos.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        )
        val from = arrayOf(MemoContract.Memos.COLUMN_TITLE, MemoContract.Memos.COLUMN_UPDATED)
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                cursor,
                from,
                to,
                0
        )

        memoList.adapter = adapter as ListAdapter
    }

    private fun insertMemoData() {
        val db = memoOpenHelper.writableDatabase
        val count = DatabaseUtils.queryNumEntries(db, MemoContract.Memos.TABLE_NAME)
        val value = ContentValues()
        value.put(MemoContract.Memos.COLUMN_TITLE, "title${count+1}")
        value.put(MemoContract.Memos.COLUMN_BODY, "body4${count+1}")
        db.insert(
                MemoContract.Memos.TABLE_NAME,
                null,
                value
        )
        showMemoList()
    }

    private fun updateMemoData() {
        val db = memoOpenHelper.writableDatabase

        val updated = SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.JAPAN).format(Date())
        val value = ContentValues()
        value.put(MemoContract.Memos.COLUMN_TITLE, "title edit")
        value.put(MemoContract.Memos.COLUMN_UPDATED, updated)
        val selection = "${MemoContract.Memos._ID} = ?"
        val selectionArgs = arrayOf("2")
        db.update(
                MemoContract.Memos.TABLE_NAME,
                value,
                selection,
                selectionArgs
                )
        showMemoList()
    }

    private fun deleteMemoData() {
        val db = memoOpenHelper.writableDatabase
        val selection = "${MemoContract.Memos._ID} = ?"
        val selectionArgs = arrayOf("1")
        db.delete(
                MemoContract.Memos.TABLE_NAME,
                selection,
                selectionArgs
        )
        showMemoList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
