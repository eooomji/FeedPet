package com.example.hello;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // DB name, version 설정
    public static final String dbName = "FeedPet.db";
    public static int VERSION = 1;

    // DatabaseHelper 생성자
    public DatabaseHelper(Context context) {
        super(context, dbName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE AllUserInfo(id INT PRIMARY KEY AUTOINCREMENT, userID TEXT, userPW TEXT, userName TEXT)");
    }

    // open
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS AllUserInfo");
        onCreate(db);
    }

    // Insert
    public void insert(String userID, String userPW, String userName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO AllUserInfo VALUES('" + userID + "', '" + userPW + "', '" + userName + "')");
        db.close();
    }

    // Update : 업뎃 할 게 있남.. ㅎ 일단 형식상 이름 변경?
    public void Update(String userID, String userName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE AllUserInfo SET userName = '" + userName + "'" + " WHERE userID = '" + userID + "'");
    }

    // Delete
    public void Delete(String userID) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE AllUserInfo WHERE userID = '" + userID + "'");
    }

    // AllUserInfo table ID 데이터 조회
    public String[] getIDResult() {
        SQLiteDatabase db = getReadableDatabase();
        String[] result = new String[100];
        int i = 0;

        if(result.length == 0) return null;
        else {
            Cursor cursor = db.rawQuery("SELECT userID FROM AllUserInfo", null);
            while(cursor.moveToNext()) {
                result[i] = cursor.getString(i);
                i++;
            }
            return result;
        }
    }

    // AllUserInfo table PW 데이터 조회
    public String[] getPWResult() {
        SQLiteDatabase db = getReadableDatabase();
        String[] result = new String[100];
        int i = 0;

        Cursor cursor = db.rawQuery("SELECT userPW FROM AllUserInfo", null);
        while(cursor.moveToNext()) {
            result[i] = cursor.getString(i);
            i++;
        }
        return result;
    }

    // AllUserInfo table userName 데이터 조회
    public String getNameResult() {
        SQLiteDatabase db = getReadableDatabase();
        String[] result = new String[100];
        int i = 0;

        Cursor cursor = db.rawQuery("SELECT userName FROM AllUserInfo", null);
        String userTxt = cursor.toString();
        return userTxt;
    }


    // AllUserInfo table 모든 데이터 조회
    public String getAllResult() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM AllUserInfo", null);
        while(cursor.moveToNext()) {
            result += "id : " + cursor.getString(0) + ", userID : " + cursor.getString(1) + ", userPW: " + cursor.getString(2) + ", userName : " + cursor.getString(3) + "\n";
        }
        return result;
    }
}
