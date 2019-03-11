package josedlujan.app.recetas.com.recetasapp;

/**
 * Created by jose on 11/05/17.
 */

public class SQLConstants {
    //DB
    public static final String DB = "bdrecetas.db";

    //TABLES
    public static final String tableRecetas = "recetas";

    //COLUMNS
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_PERSONAS = "personas";
    public static final String COLUMN_DESCRIPCION = "descripcion";
    public static final String COLUMN_PREPARACION = "preparacion";
    public static final String COLUMN_IMAGE = "imagenes";
    public static final String COLUMN_FAV = "fav";


    public static final  String WHERECLAUSE  = "nombre=? ";
    public static final  String FAVCLAUSE = "fav=?";
    public static final  String PERCLAUSE = "personas=?";


    //QUERIS

    public static final  String SQL_CREATE_TABLE_RECETAS =
            "CREATE TABLE " + tableRecetas + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NOMBRE + " TEXT," +
                    COLUMN_PERSONAS + " INT," +
                    COLUMN_DESCRIPCION + " TEXT," +
                    COLUMN_PREPARACION + " TEXT," +
                    COLUMN_IMAGE + " TEXT," +
                    COLUMN_FAV + " INT" + ");";

    public static final  String SQL_DELETE =
            "DROP TABLE "+ tableRecetas;

    public static final String[] ALL_COLUMNS = {COLUMN_ID,COLUMN_NOMBRE,COLUMN_PERSONAS,COLUMN_DESCRIPCION
    ,COLUMN_PREPARACION,COLUMN_IMAGE,COLUMN_FAV};





}
