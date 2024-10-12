package com.example.p1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText txtPeso = findViewById(R.id.txtPeso);
        EditText txtAltura = findViewById(R.id.txtAltura);
        Button btnCalcularIMC = findViewById(R.id.btnCalcularIMC);
        TextView txtResultadoIMC = findViewById(R.id.txtResultadoIMC);
        TextView txtClasificacionIMC = findViewById(R.id.txtClasificacionIMC);

        Button buttonScreen = findViewById(R.id.btnMenu3);

        buttonScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnCalcularIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesoStr = txtPeso.getText().toString().trim();
                String alturaStr = txtAltura.getText().toString().trim();

                if (!pesoStr.isEmpty() && !alturaStr.isEmpty()) {
                    double peso = Double.parseDouble(pesoStr);
                    double altura = Double.parseDouble(alturaStr);

                    double imc = calcularIMC(peso, altura);
                    String clasificacion = clasificarIMC(imc);

                    // Mostrar el resultado del IMC y la clasificación
                    txtResultadoIMC.setText(String.format("IMC: %.2f", imc));
                    txtClasificacionIMC.setText("Clasificación: " + clasificacion);
                } else {
                    txtResultadoIMC.setText("Por favor, ingrese peso y altura.");
                    txtClasificacionIMC.setText("");
                }
            }
        });
    }

    // Método para calcular el IMC
    private double calcularIMC(double peso, double altura) {
        return peso / (altura * altura); // Formula IMC = peso / altura^2
    }

    // Método para clasificar el IMC según los rangos establecidos
    private String clasificarIMC(double imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
