package com.example.debugging;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity  implements View.OnClickListener{

    TextView txtName,txtSurname,txtUser,txtPassword,txtEmail;
    Button play;
    Button stop;
    MediaPlayer mediaplayer;
    int cont=0; //contador para controlar el audio y que no se solapen las reproduciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);


        play= (Button)findViewById(R.id.play);
        stop= (Button)findViewById(R.id.stop);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);

        txtName = findViewById(R.id.nombre);
        txtSurname = findViewById(R.id.apellido);
        txtUser = findViewById(R.id.usuario);
        txtPassword = findViewById(R.id.contraseña);
        txtEmail = findViewById(R.id.email);

        String usuario = getIntent().getStringExtra("usuario");





        try {
            DbHelper dbHelper = new DbHelper(Activity4.this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            //Proyeccion en la cual elegimos las columnas a utilizar

            String[] projection = {"nombre","apellido","contraseña","email"};





            // Filter results WHERE "title" = 'My Title'
            String selection = "nombre_usuario" + " = ?";
            String[] selectionArgs = {usuario};


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

            txtName.setText(cursor.getString(0));
            txtSurname.setText(cursor.getString(1));
            txtUser.setText(usuario);
            txtPassword.setText(cursor.getString(2));
            txtEmail.setText(cursor.getString(3));


            cursor.close();


        }catch(Exception e){

            Toast.makeText(this, "Error al recuperar información del usuario", Toast.LENGTH_LONG).show();
        }

    }

    public void iniciarMediaplayer(){
        mediaplayer=null;
    mediaplayer=MediaPlayer.create(this, R.raw.song);}


    @Override
    public void onClick(View view) {
    //  Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente


        switch(view.getId()){
            case R.id.play:
                //Iniciamos el audio
                if (cont==0){
                    cont++;
                iniciarMediaplayer();
                mediaplayer.start();}
                else{}
                break;
            case R.id.stop:
                //paramos el audio
                cont=0;
                mediaplayer.stop();
                break;



}}}