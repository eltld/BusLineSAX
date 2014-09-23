package com.gdd.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

	public DbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);

	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
//		String sql = "CREATE TABLE pic (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , fileName VARCHAR, description VARCHAR)";
		String sql = "CREATE TABLE bus_line(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , bus_id INTEGER , 	bus_site VARCHAR)";
		arg0.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
