package com.example.debugging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txtUser,txtPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = findViewById(R.id.editTextTextPersonName);
        txtPassword = findViewById(R.id.editTextTextPassword);

    }


    public void logearseDb(View view) {


        try {
            DbHelper dbHelper = new DbHelper(LoginActivity.this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            //Proyeccion en la cual elegimos las columnas a utilizar

            String[] projection = {


                    "contraseña"
            };

            // Filter results WHERE "title" = 'My Title'
            String selection = "nombre_usuario" + " = ?";
            String[] selectionArgs = {txtUser.getText().toString()};


            Cursor cursor = db.query(
                    DbHelper.TABLE_USERS,  // The table to query
                    projection,             // The array of columns to return (pass null to get all)
                    selection,              // The columns for the WHERE clause
                    selectionArgs,          // The values for the WHERE clause
                    null,                   // don't group the rows
                    null,                   // don't filter by row groups
                    null
            );

            cursor.moveToFirst();

            String password = cursor.getString(0);

            cursor.close();


            if (password.equals(txtPassword.getText().toString())) {

                Intent intent = new Intent(this, Activity4.class);
                intent.putExtra("usuario", selectionArgs[0]);
                startActivity(intent);

            } else {
                Toast.makeText(this, "No se ha podido iniciar sesión en la aplicación. Contraseña incorrecta", Toast.LENGTH_LONG).show();
            }

        }catch(Exception e){

            Toast.makeText(this, "No se ha podido iniciar sesión en la aplicación", Toast.LENGTH_LONG).show();
        }

    }
}