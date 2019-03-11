package josedlujan.app.recetas.com.recetasapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose on 11/05/17.
 */

public class Data {
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;

    public Data(Context context){
        this.context = context;
        sqLiteOpenHelper = new DBHelper(context);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }
    public void close(){
        sqLiteOpenHelper.close();
    }

    public void insertReceta(Receta receta){
        ContentValues values = receta.toValues();
        sqLiteDatabase.insert(SQLConstants.tableRecetas,null,values);
    }

    public long getItemsCount(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstants.tableRecetas);
    }

    public void insertRecetas(List<Receta> recetas){
        long items = getItemsCount();
        if(items == 0){
            for (Receta receta: recetas){
                try {
                    insertReceta(receta);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Receta> getAll(){
        List<Receta> recetas = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(SQLConstants.tableRecetas,SQLConstants.ALL_COLUMNS,
                null,null,null,null,null);

        while (cursor.moveToNext()){
            Receta receta = new Receta();
            receta.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            receta.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            receta.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            receta.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            receta.setPreparacion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_PREPARACION)));
            receta.setImage(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGE)));
            receta.setFav(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            recetas.add(receta);
        }
        return recetas;
    }

    public List<Receta> getFav(){
        List<Receta> recetas = new ArrayList<>();
        String[] whereArgs = new String[] {String.valueOf(1)};

        Cursor cursor = sqLiteDatabase.query(SQLConstants.tableRecetas,SQLConstants.ALL_COLUMNS,SQLConstants.FAVCLAUSE,whereArgs,null,null,null);

        while (cursor.moveToNext()){
            Receta receta = new Receta();
            receta.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            receta.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            receta.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            receta.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            receta.setPreparacion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_PREPARACION)));
            receta.setImage(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGE)));
            receta.setFav(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            Log.e("TAG",receta.getNombre());
            recetas.add(receta);
        }
        return recetas;
    }


    public List<Receta> getPer(int p){
        List<Receta> recetas = new ArrayList<>();
        String[] whereArgs = new String[] {String.valueOf(p)};

        Cursor cursor = sqLiteDatabase.query(SQLConstants.tableRecetas,SQLConstants.ALL_COLUMNS,SQLConstants.PERCLAUSE,whereArgs,null,null,null);

        while (cursor.moveToNext()){
            Receta receta = new Receta();
            receta.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            receta.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            receta.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            receta.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            receta.setPreparacion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_PREPARACION)));
            receta.setImage(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGE)));
            receta.setFav(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            Log.e("TAG",receta.getNombre());
            recetas.add(receta);
        }
        return recetas;
    }

    public void deleteItem(String id){
        String[] whereArgs = new String[] {String.valueOf(id)};
        sqLiteDatabase.delete(SQLConstants.tableRecetas,SQLConstants.WHERECLAUSE,whereArgs);


    }
}
