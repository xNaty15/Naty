package com.example.naty;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resultado extends AppCompatActivity {

    TextView Rezu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resultado);

        Rezu = findViewById(R.id.viewResultado);

        Intent anteriorIntent = getIntent();//obtengo el intent actua (la acitvity de resultado) pa los parametros
        //almacenados en la activyt

        String resultado = anteriorIntent.getStringExtra("resultado");
        Rezu.setText(resultado.toString());


    }

}