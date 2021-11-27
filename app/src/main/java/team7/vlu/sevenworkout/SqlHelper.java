package team7.vlu.sevenworkout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "TimeResource";
    static final String TABLE_NAME = "tblTime";
    public static final String COLUMN_NAME_TIME = "time";
    static final int version = 1;


    public SqlHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlText = "CREATE TABLE tblTime(_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "TextTimer TEXT NOT NULL)";
        sqLiteDatabase.execSQL(sqlText);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
