package com.example.missensores;

import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.SensorViewHolder> {

    private List<Sensor> listaDeSensores;

    // Constructor
    public SensorAdapter(List<Sensor> listaDeSensores) {
        this.listaDeSensores = listaDeSensores;
    }

    @NonNull
    @Override
    public SensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sensor_layout, parent, false);
        return new SensorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorViewHolder holder, int position) {
        Sensor sensorActual = listaDeSensores.get(position);

        // Rellenar los 4 campos de la tarjeta
        holder.tvSensorNombre.setText(sensorActual.getName());
        holder.tvSensorFabricante.setText(sensorActual.getVendor());
        holder.tvSensorTipo.setText("Tipo: " + sensorActual.getType());
        holder.tvSensorPotencia.setText("Potencia: " + sensorActual.getPower() + " mA");
    }

    @Override
    public int getItemCount() {
        return listaDeSensores.size();
    }

    // El ViewHolder ahora referencia los 4 TextViews de la tarjeta
    public static class SensorViewHolder extends RecyclerView.ViewHolder {
        public TextView tvSensorNombre;
        public TextView tvSensorFabricante;
        public TextView tvSensorTipo;
        public TextView tvSensorPotencia;

        public SensorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSensorNombre = itemView.findViewById(R.id.tvSensorNombre);
            tvSensorFabricante = itemView.findViewById(R.id.tvSensorFabricante);
            tvSensorTipo = itemView.findViewById(R.id.tvSensorTipo);
            tvSensorPotencia = itemView.findViewById(R.id.tvSensorPotencia);
        }
    }
}
