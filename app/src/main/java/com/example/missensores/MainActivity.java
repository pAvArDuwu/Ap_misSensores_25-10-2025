package com.example.missensores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerSensores; // Cambiado a RecyclerView
    private Button btnActualizar;
    private SensorManager gestorSensores;
    private SensorAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerSensores = findViewById(R.id.recyclerSensores);
        btnActualizar = findViewById(R.id.btnActualizar);

        // --- LA MAGIA PARA LAS DOS COLUMNAS ---
        // 1. Crear el GridLayoutManager. El '2' significa 2 columnas.
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        // 2. Asignar el LayoutManager al RecyclerView.
        recyclerSensores.setLayoutManager(gridLayoutManager);

        // Llamar al servicio de sensores
        gestorSensores = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Cargar los sensores al iniciar
        cargarSensores();

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarSensores();
                Toast.makeText(MainActivity.this, "Lista actualizada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarSensores() {
        // Obtener la lista completa de objetos Sensor
        List<Sensor> lista = gestorSensores.getSensorList(Sensor.TYPE_ALL);

        // Crear una instancia de nuestro nuevo adaptador con la lista
        adaptador = new SensorAdapter(lista);

        // Asignar el adaptador al RecyclerView
        recyclerSensores.setAdapter(adaptador);
    }
}
