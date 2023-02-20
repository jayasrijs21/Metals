package com.example.metals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RVInterface {

    ArrayList<Metals_Model>metalsModels = new ArrayList<>();
    int[] images = {R.drawable.baseline_create_24, R.drawable.baseline_color_lens_24, R.drawable.baseline_dock_24,
            R.drawable.baseline_emoji_objects_24, R.drawable.baseline_flight_takeoff_24,
            R.drawable.baseline_flight_takeoff_24, R.drawable.baseline_hotel_class_24,
            R.drawable.baseline_near_me_24, R.drawable.baseline_settings_system_daydream_24,
            R.drawable.baseline_sports_volleyball_24, R.drawable.baseline_surfing_24};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recylerView);
        setUpModels();
        M_RVAdapter adapter = new M_RVAdapter(this,metalsModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }



    public void setUpModels() {
        String [] metName = getResources().getStringArray(R.array.metal_names);
        String [] sciNames = getResources().getStringArray(R.array.scientific_names);
        String [] syms = getResources().getStringArray(R.array.symbols);


        for(int i=0; i<metName.length; i++) {
            metalsModels.add(new Metals_Model(metName[i] , sciNames[i],syms[i],images[i] ));

        }
    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(this , MainActivity2.class);

        intent.putExtra("metal_names", metalsModels.get(position).getMetalName());
        intent.putExtra("symbols", metalsModels.get(position).getSymbol());
        startActivity(intent);

    }
}