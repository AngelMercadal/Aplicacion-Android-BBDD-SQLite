package com.example.debugging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    EditText txtName,txtSurname,txtUser,txtPassword,txtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtName = findViewById(R.id.editTextTextPersonName);
        txtSurname = findViewById(R.id.editTextTextPersonSurName);
        txtUser = findViewById(R.id.editTextTextUserName);
        txtPassword = findViewById(R.id.editTextTextPassword);
        txtEmail = findViewById(R.id.editTextTextEmailAddress);




    }



    public void registrarseDb(View view){

    DbHelper dbHelper= new DbHelper(RegistroActivity.this);
        SQLiteDatabase db =dbHelper.getWritableDatabase();


        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("nombre", txtName.getText().toString());
        values.put("apellido", txtSurname.getText().toString());
        values.put("nombre_usuario", txtUser.getText().toString());
        values.put("contraseña", txtPassword.getText().toString());
        values.put("email", txtEmail.getText().toString());

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(dbHelper.TABLE_USERS, null, values);



        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);

}

}