package com.example.agendadecontatos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import java.security.AccessControlContext

class SQLITE(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private val SQL_CREATE_ENTRIES =
                                            "CREATE TABLE CONTATOS("          +
                                                "ID INTEGER PRIMARY KEY," +
                                                "NOME TEXT NULL,"              +
                                                "TELEFONE TEXT NULL,"          +
                                                "EMAIL TEXT NULL)";

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS CONTATOS";

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "FeedReader.db"
    }

}