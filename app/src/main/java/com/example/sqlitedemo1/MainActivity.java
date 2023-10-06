package com.example.sqlitedemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=openOrCreateDatabase("cocsit2.db",MODE_PRIVATE,null);

        db.execSQL("create table if not exists stud(rno int, name varchar(20))");



    }

    public void savefun1(View view) {

        EditText txt1=findViewById(R.id.txt1);
        EditText txt2=findViewById(R.id.txt2);
        int rno=Integer.parseInt(txt1.getText().toString());
        String name=txt2.getText().toString();
        db.execSQL("insert into stud values("+rno+",'"+ name+"')");
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();


    }

    public void nextfun1(View view) {
        Intent i=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
    }
}