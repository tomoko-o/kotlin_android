package com.usaco_pg.memoapp

import android.provider.BaseColumns

/**
 * Created by tomoko on 2017/10/10.
 */
class MemoContract {

    class Memos {
        companion object {
            val TABLE_NAME = "memos"
            val _ID = "_id"
            val COLUMN_TITLE = "title"
            val COLUMN_BODY = "body"
            val COLUMN_CREATED = "created"
            val COLUMN_UPDATED = "updated"
        }
    }
}