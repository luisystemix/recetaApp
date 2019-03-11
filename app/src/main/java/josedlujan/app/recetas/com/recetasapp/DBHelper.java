package josedlujan.app.recetas.com.recetasapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jose on 11/05/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;

    public DBHelper(Context context){
        super(context,SQLConstants.DB,null,DB_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLConstants.SQL_CREATE_TABLE_RECETAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQLConstants.SQL_DELETE);
        onCreate(sqLiteDatabase);
    }
}
