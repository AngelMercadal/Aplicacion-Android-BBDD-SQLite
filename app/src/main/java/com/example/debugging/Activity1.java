package com.example.debugging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Activity1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
    }


    public void registrarse(View view){

        Intent intent=new Intent(this,RegistroActivity.class);
        startActivity(intent);

    }


    public void iniciarSesion(View view){

        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);

    }
    

}

