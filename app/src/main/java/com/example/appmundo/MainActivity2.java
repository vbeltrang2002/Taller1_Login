package com.example.appmundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText etUsuario, etClave;
    private Button btnIngresar, btnAtras, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etUsuario = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etClave);
        btnIngresar = findViewById(R.id.btnAceptar);
        btnAtras = findViewById(R.id.btnAtras);
        btnCancelar = findViewById(R.id.btnCancelar); // Enlazamos el botón "Cancelar"

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString().trim();
                String clave = etClave.getText().toString().trim();

                if (usuario.isEmpty()) {
                    etUsuario.setError("Usuario requerido");
                    return;
                }

                if (clave.isEmpty()) {
                    etClave.setError("Clave requerida");
                    return;
                }

                Toast.makeText(MainActivity2.this, "Usted ha sido iniciado correctamente", Toast.LENGTH_LONG).show();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // ✅ Programación del botón "Cancelar"
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUsuario.setText("");
                etClave.setText("");
            }
        });
    }
}
