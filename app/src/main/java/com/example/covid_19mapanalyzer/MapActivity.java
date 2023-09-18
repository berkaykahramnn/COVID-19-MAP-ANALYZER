package com.example.covid_19mapanalyzer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.example.covid_19mapanalyzer.databinding.ActivityMapBinding;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.google.maps.android.heatmaps.WeightedLatLng;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap googleMap;
    private ActivityMapBinding binding;
    private String intensitySource;
    private int maximumIntensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intensitySource = "Mar20";
        setTitle(intensitySource);
        maximumIntensity = 426;

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home: finish(); break;

            case R.id.action_mar20: intensitySource = "Mar20"; maximumIntensity = 426; break;
            case R.id.action_apr20: intensitySource = "Apr20"; maximumIntensity = 3360; break;
            case R.id.action_may20: intensitySource = "May20"; maximumIntensity = 1378; break;
            case R.id.action_jun20: intensitySource = "Jun20"; maximumIntensity = 1133; break;
            case R.id.action_jul20: intensitySource = "Jul20"; maximumIntensity = 975; break;
            case R.id.action_aug20: intensitySource = "Aug20"; maximumIntensity = 1237; break;
            case R.id.action_sep20: intensitySource = "Sep20"; maximumIntensity = 1529; break;
            case R.id.action_oct20: intensitySource = "Oct20"; maximumIntensity = 1786; break;
            case R.id.action_nov20: intensitySource = "Nov20"; maximumIntensity = 5605; break;
            case R.id.action_dec20: intensitySource = "Dec20"; maximumIntensity = 24476; break;
            case R.id.action_jan21: intensitySource = "Jan21"; maximumIntensity = 8468; break;
            case R.id.action_feb21: intensitySource = "Feb21"; maximumIntensity = 7060; break;
            case R.id.action_mar21: intensitySource = "Mar21"; maximumIntensity = 19391; break;
            case R.id.action_apr21: intensitySource = "Apr21"; maximumIntensity = 47357; break;
            case R.id.action_may21: intensitySource = "May21"; maximumIntensity = 13508; break;
            case R.id.action_jun21: intensitySource = "Jun21"; maximumIntensity = 5552; break;
            case R.id.action_jul21: intensitySource = "Jul21"; maximumIntensity = 9494; break;
            case R.id.action_aug21: intensitySource = "Aug21"; maximumIntensity = 20831; break;
            case R.id.action_sep21: intensitySource = "Sep21"; maximumIntensity = 24121; break;
            case R.id.action_oct21: intensitySource = "Oct21"; maximumIntensity = 27686; break;
            case R.id.action_nov21: intensitySource = "Nov21"; maximumIntensity = 24022; break;
            case R.id.action_dec21: intensitySource = "Dec21"; maximumIntensity = 21639; break;
            case R.id.action_jan22: intensitySource = "Jan22"; maximumIntensity = 67326; break;
            case R.id.action_feb22: intensitySource = "Feb22"; maximumIntensity = 77792; break;
            case R.id.action_mar22: intensitySource = "Mar22"; maximumIntensity = 24290; break;
            case R.id.action_apr22: intensitySource = "Apr22"; maximumIntensity = 5403; break;
            case R.id.action_may22: intensitySource = "May22"; maximumIntensity = 1281; break;
            case R.id.action_jun22: intensitySource = "Jun22"; maximumIntensity = 7140; break;
            case R.id.action_jul22: intensitySource = "Jul22"; maximumIntensity = 31446; break;
            case R.id.action_aug22: intensitySource = "Aug22"; maximumIntensity = 16825; break;
            case R.id.action_sep22: intensitySource = "Sep22"; maximumIntensity = 2825; break;
            case R.id.action_oct22: intensitySource = "Oct22"; maximumIntensity = 3877; break;
        }

        setTitle(intensitySource);
        loadData();

        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(38.722100, 35.489122)));
        this.googleMap.animateCamera(CameraUpdateFactory.zoomTo(5f));
        this.googleMap.getUiSettings().setZoomControlsEnabled(true);
        this.loadData();
    }

    public void loadData(){
        googleMap.clear();
        HeatmapTileProvider heatmapTileProvider = new HeatmapTileProvider.Builder().weightedData(getLocationData()).radius(50).maxIntensity(maximumIntensity).build();
        TileOverlayOptions tileoverlayoptions = new TileOverlayOptions().tileProvider(heatmapTileProvider);
        TileOverlay tileoverlay = googleMap.addTileOverlay(tileoverlayoptions);
        tileoverlay.clearTileCache();
    }

    private ArrayList getLocationData() {
        ArrayList<WeightedLatLng> data = new ArrayList<>();

        JSONArray jsonData = getJSONData();
        for(int i = 0; i < jsonData.length(); i++) {
            try {
                JSONObject item = jsonData.getJSONObject(i);
                data.add(new WeightedLatLng(new LatLng(item.getDouble("latitude"), item.getDouble("longitude")),item.getInt(intensitySource)));
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return data;
    }

    public JSONArray getJSONData() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.data);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            return new JSONArray(new String(buffer, "UTF-8"));
        } catch (Exception e){
            e.printStackTrace();
        }
        return new JSONArray();
    }
}