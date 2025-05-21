package com.example.naty;

import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText numero1, numero2;
    Button suma,resta, multiplicacion, division;
    Double resultado, num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.txtNum1);
        numero2 = findViewById(R.id.txtNum2);

        suma=findViewById(R.id.btnSuma);
        resta= findViewById(R.id.btnResta);
        multiplicacion=findViewById(R.id.btnMulti);
        division = findViewById(R.id.btnDivision);

        suma.setOnClickListener(view -> {//uno de los parametros q tiene el evento
            operacionesMathematicas("suma");
        });

        resta.setOnClickListener(view -> {
            operacionesMathematicas("resta");

        });

        multiplicacion.setOnClickListener(view -> {
            operacionesMathematicas("multiplicacion");

        });

        division.setOnClickListener(view -> {
            operacionesMathematicas("division");
        });

    }

    public void operacionesMathematicas(String operacion){
        if(numero1.getText().toString().isEmpty() || numero2.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingresa los numeros", Toast.LENGTH_SHORT).show();
            return;
        }

        num1 = Double.parseDouble(numero1.getText().toString());
        num2 = Double.parseDouble(numero2.getText().toString());

        switch (operacion){
            case "suma":
                resultado = num1 + num2;
                break;
            case "resta":
                resultado = num1 - num2;
                break;
            case "multiplicacion":
                resultado = num1 * num2;
                break;
            case "division":
                if (num2 == 0) {
                    Toast.makeText(this,
                            "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
                    return;
                }

                resultado = num1 / num2;
                break;
            default:
                resultado = 0.0;
                break;

        }
        Intent intent = new Intent(this, Resultado.class);
        intent.putExtra("resultado", resultado.toString());
        startActivity(intent);
    }


}
