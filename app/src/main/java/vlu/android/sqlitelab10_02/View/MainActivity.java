package vlu.android.sqlitelab10_02.View;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import vlu.android.sqlitelab10_02.Controller.KhoaHandler;
import vlu.android.sqlitelab10_02.Model.Khoa;
import vlu.android.sqlitelab10_02.R;

public class MainActivity extends AppCompatActivity {
    private static final String DB_NAME = "qlsv";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "Khoa";
    private static final String MK_COL = "makhoa";
    private static final String TK_COL = "tenkhoa";
    private static final String PATH =
            "/data/data/vlu.android.sqlitelab10_02/database/qlsv.db";

    EditText edtMK, edtTK;
    Button btnInsert, btnUpdate;
    ListView lvKhoa;
    ArrayList<String> dataLV = new ArrayList<>();
    ArrayAdapter<String>adapter;
    ArrayList<Khoa>lsKhoa = new ArrayList<>();
    KhoaHandler khoaHandler;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //------------
        addControl();
        //--------------------------------------
        khoaHandler = new KhoaHandler(getApplicationContext(),DB_NAME,null,DB_VERSION);
        khoaHandler.onCreate(sqLiteDatabase);
        khoaHandler.initData();
        lsKhoa=khoaHandler.loadAllDataOfKhoa();
        dataLV = convertData(lsKhoa);

        adapter = new ArrayAdapter<>(getApplicationContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,dataLV);
        lvKhoa.setAdapter(adapter);


    }

    ArrayList<String> convertData(ArrayList<Khoa>lsKhoa)
    {
        ArrayList<String> arrayListLV = new ArrayList<>();
        for (Khoa k:lsKhoa) {
            String s = k.getmKhoa() + " - " + k.getTenKhoa();
            arrayListLV.add(s);
        }
        return arrayListLV;
    }


    void addControl()
    {
        edtMK=(EditText) findViewById(R.id.edtMK);
        edtTK = (EditText) findViewById(R.id.edtTK);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnUpdate= (Button) findViewById(R.id.btnUpdate);
        lvKhoa = (ListView) findViewById(R.id.lvKhoa);
    }
}