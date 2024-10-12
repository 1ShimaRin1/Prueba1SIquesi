package com.example.p1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText txtRut = findViewById(R.id.txtRut);
        Button btnRut = findViewById(R.id.btnRut);
        TextView txtValido = findViewById(R.id.txtValido);

        Button btnButton = findViewById(R.id.btnMenu2);

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnRut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rut = txtRut.getText().toString().trim();
                if (isValidRutFormat(rut)) {
                    txtValido.setText("Formato RUT válido");
                    txtValido.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                } else {
                    txtValido.setText("Formato RUT inválido");
                    txtValido.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        });
    }
    private boolean isValidRutFormat(String rut) {
        // Verificar si contiene puntos y guión
        if (!rut.contains(".") || !rut.contains("-")) {
            return false;
        }
        String rutSinPuntosGuion = rut.replace(".", "").replace("-", "").toUpperCase();
        if (rutSinPuntosGuion.length() < 8 || rutSinPuntosGuion.length() > 9) {
            return false;
        }
        char dvIngresado = rutSinPuntosGuion.charAt(rutSinPuntosGuion.length() - 1);
        return Character.isDigit(dvIngresado) || dvIngresado == 'K';
    }
}


