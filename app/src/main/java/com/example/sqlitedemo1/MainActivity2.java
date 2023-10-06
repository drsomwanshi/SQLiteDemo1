package com.example.sqlitedemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {
    SQLiteDatabase db=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db=openOrCreateDatabase("cocsit2.db",MODE_PRIVATE,null);

        Cursor c=db.rawQuery("select * from stud", null);
        String s[]=new String[c.getCount()];
        String d="";
        int i=0;
        while(c.moveToNext())
        {
            d= c.getInt(0) + "\t" + c.getString(1);

            s[i]=d;
            i++;
        }
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,s);
        ListView lst2=findViewById(R.id.lst2);
        lst2.setAdapter(adapter);

    }
}