package team7.vlu.sevenworkout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DBcontext {
    SqlHelper helper;
    Context context;
    SQLiteDatabase db;
    static final String TABLE_NAME = "tblTime";
    public static final String COLUMN_NAME_TIME = "time";

    public DBcontext(Context context) {
        this.context = context;
    }

    public DBcontext open() throws SQLiteException {
        helper = new SqlHelper(this.context);
        db = helper.getWritableDatabase();
        return this;
    }

    public void close(){
        if(db != null)
            db.close();
    }

    public Cursor selectAll(){
        String[] columns = new String[]{"_ID", COLUMN_NAME_TIME};
        Cursor cursor = db.query(TABLE_NAME, columns,
                null,null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public void insert(String textTime){
        ContentValues values = new ContentValues();
        values.put("TextTime", textTime);
        db.insert(TABLE_NAME,null, values );


    }

    public void update(long id, String textTime){
        ContentValues values = new ContentValues();
        values.put(TABLE_NAME, textTime);

        open();
        db.update(TABLE_NAME,values,"_ID = " + id, null);
        close();
    }

    public void delete(long id) {
        open();
        db.delete(TABLE_NAME, "_ID = " + id, null);
        close();
    }

}
