package com.weileng.self.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.weileng.self.db.bean.WeilengBean;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
	
	private static final String DB_NAME = "sqlite-wl.db";
	public DatabaseHelper(Context context) {
		this(context,1);
	}
	public DatabaseHelper(Context context,int databaseVersion) {
		super(context, DB_NAME, null, databaseVersion);
	}
	
	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource connectionSource) {
		try {
			//时间戳表必须最先建立
			TableUtils.createTable(connectionSource, WeilengBean.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource connectionSource, int arg2,
			int arg3) {
		System.out.println("update  db");
		//Toast.makeText(MsApplication.applicationContext, "数据库升级", 0).show();
		try {
			TableUtils.dropTable(connectionSource, WeilengBean.class, true);
			onCreate(arg0, connectionSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
}
