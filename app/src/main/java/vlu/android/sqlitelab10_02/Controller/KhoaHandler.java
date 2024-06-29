package vlu.android.sqlitelab10_02.Controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class KhoaHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "qlsv";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "Khoa";
    private static final String MK_COL = "makhoa";
    private static final String TK_COL = "tenkhoa";
    private static final String PATH =
            "/data/data/vlu.android.sqlitelab10_02/database/qlsv.db";


    public KhoaHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    //Tạo bảng Khoa trong CSDL
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase = SQLiteDatabase.openDatabase(PATH,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + MK_COL +" INTEGER NOT NULL UNIQUE, " +
                TK_COL + " TEXT NOT NULL UNIQUE, PRIMARY KEY(" + MK_COL + "))";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.close();
    }
    //Khoi tao du lieu ban dau cho bang Khoa
    public  void  initData()
    {
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(PATH,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql1 = "INSERT OR IGNORE INTO " + TABLE_NAME + " ("
                + MK_COL + ", " + TK_COL + ") Values ('1','CNTT')";
        sqLiteDatabase.execSQL(sql1);
        String sql2 = "INSERT OR IGNORE INTO " + TABLE_NAME + " ("
                + MK_COL + ", " + TK_COL + ") Values ('2','Dien - Dien Tu')";
        sqLiteDatabase.execSQL(sql2);
        String sql3 = "INSERT OR IGNORE INTO " + TABLE_NAME + " ("
                + MK_COL + ", " + TK_COL + ") Values ('3','Du Lich')";
        sqLiteDatabase.execSQL(sql3);
        String sql4 = "INSERT OR IGNORE INTO " + TABLE_NAME + " ("
                + MK_COL + ", " + TK_COL + ") Values ('4','TCKT')";
        sqLiteDatabase.execSQL(sql4);
        sqLiteDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
