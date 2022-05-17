package com.umg.trains;

import static com.umg.trains.FeedReaderContract.FeedEntry.TABLE_NAME;


import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

import com.umg.trains.FeedReaderContract.FeedEntry;

import java.util.ArrayList;
import java.util.List;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "STATS";
    public static final Parcelable.Creator<ContentValues> CREATOR = new Parcelable.Creator<ContentValues>() {

        @Override
        public ContentValues createFromParcel(Parcel parcel) {
            return null;
        }

        @Override
        public ContentValues[] newArray(int i) {
            return new ContentValues[0];
        }
    };

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FeedReaderContract.SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL(String.format("ALTER TABLE%sADD COLUMN new_column_name INTEGER DEFAULT 0", TABLE_NAME));

        }
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

