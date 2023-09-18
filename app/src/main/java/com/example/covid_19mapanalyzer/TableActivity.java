package com.example.covid_19mapanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity {
    private RecyclerView provincesView;
    private ProvincesAdaptor provincesAdaptor;
    private List<Province> provinces;

    private String intensitySource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        intensitySource = "Mar20";
        setTitle(intensitySource);

        provincesView = findViewById(R.id.provinces_view);
        provincesView.setLayoutManager(new LinearLayoutManager(TableActivity.this));

        provinces = new ArrayList<>();

        provincesAdaptor = new ProvincesAdaptor();
        provincesView.setAdapter(provincesAdaptor);
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

            case R.id.action_mar20: intensitySource = "Mar20"; break;
            case R.id.action_apr20: intensitySource = "Apr20"; break;
            case R.id.action_may20: intensitySource = "May20"; break;
            case R.id.action_jun20: intensitySource = "Jun20"; break;
            case R.id.action_jul20: intensitySource = "Jul20"; break;
            case R.id.action_aug20: intensitySource = "Aug20"; break;
            case R.id.action_sep20: intensitySource = "Sep20"; break;
            case R.id.action_oct20: intensitySource = "Oct20"; break;
            case R.id.action_nov20: intensitySource = "Nov20"; break;
            case R.id.action_dec20: intensitySource = "Dec20"; break;
            case R.id.action_jan21: intensitySource = "Jan21"; break;
            case R.id.action_feb21: intensitySource = "Feb21"; break;
            case R.id.action_mar21: intensitySource = "Mar21"; break;
            case R.id.action_apr21: intensitySource = "Apr21"; break;
            case R.id.action_may21: intensitySource = "May21"; break;
            case R.id.action_jun21: intensitySource = "Jun21"; break;
            case R.id.action_jul21: intensitySource = "Jul21"; break;
            case R.id.action_aug21: intensitySource = "Aug21"; break;
            case R.id.action_sep21: intensitySource = "Sep21"; break;
            case R.id.action_oct21: intensitySource = "Oct21"; break;
            case R.id.action_nov21: intensitySource = "Nov21"; break;
            case R.id.action_dec21: intensitySource = "Dec21"; break;
            case R.id.action_jan22: intensitySource = "Jan22"; break;
            case R.id.action_feb22: intensitySource = "Feb22"; break;
            case R.id.action_mar22: intensitySource = "Mar22"; break;
            case R.id.action_apr22: intensitySource = "Apr22"; break;
            case R.id.action_may22: intensitySource = "May22"; break;
            case R.id.action_jun22: intensitySource = "Jun22"; break;
            case R.id.action_jul22: intensitySource = "Jul22"; break;
            case R.id.action_aug22: intensitySource = "Aug22"; break;
            case R.id.action_sep22: intensitySource = "Sep22"; break;
            case R.id.action_oct22: intensitySource = "Oct22"; break;
        }

        setTitle(intensitySource);
        loadProvinces();

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadProvinces();
    }

    private class ProvinceHolder extends RecyclerView.ViewHolder {
        private TextView nameView;
        private TextView populationView;
        private TextView casesView;
        private Province province;

        public ProvinceHolder(View itemView) {
            super(itemView);

            nameView = itemView.findViewById(R.id.name_view);
            populationView = itemView.findViewById(R.id.population_view);
            casesView = itemView.findViewById(R.id.cases_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(TableActivity.this, DetailsActivity.class);
                    i.putExtra("province", province);
                    startActivity(i);
                }
            });
        }

        private void bindProvince(Province province){
            this.province = province;
            nameView.setText(province.getName());
            populationView.setText(province.getPopulation() + "%");

            if("Mar20".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getMar20() + "");
            } else if("Apr20".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getApr20() + "");
            } else if("May20".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getMay20() + "");
            } else if("Jun20".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getJun20() + "");
            } else if("Jul20".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getJul20() + "");
            } else if("Aug20".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getAug20() + "");
            } else if("Sep20".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getSep20() + "");
            } else if("Oct20".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getOct20() + "");
            } else if("Nov20".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getNov20() + "");
            } else if("Dec20".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getDec20() + "");
            } else if("Jan21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getJan21() + "");
            } else if("Feb21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getFeb21() + "");
            } else if("Mar21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getMar21() + "");
            } else if("Apr21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getApr21() + "");
            } else if("May21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getMay21() + "");
            } else if("Jun21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getJun21() + "");
            } else if("Jul21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getJul21() + "");
            } else if("Aug21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getAug21() + "");
            } else if("Sep21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getSep21() + "");
            } else if("Oct21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getOct21() + "");
            } else if("Nov21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getNov21() + "");
            } else if("Dec21".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getDec21() + "");
            } else if("Jan22".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getJan22() + "");
            } else if("Feb22".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getFeb22() + "");
            } else if("Mar22".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getMar22() + "");
            } else if("Apr22".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getApr22() + "");
            } else if("May22".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getMay22() + "");
            } else if("Jun22".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getJun22() + "");
            } else if("Jul22".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getJul22() + "");
            } else if("Aug22".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getAug22() + "");
            } else if("Sep22".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getSep22() + "");
            } else if("Oct22".equalsIgnoreCase(intensitySource)){
                casesView.setText(province.getOct22() + "");
            }
        }
    }

    public void loadProvinces() {
        provinces.clear();
        provinces.addAll(getProvinces());
        provincesAdaptor.notifyDataSetChanged();
    }

    private class ProvincesAdaptor extends RecyclerView.Adapter<ProvinceHolder> {

        public ProvincesAdaptor() {
        }

        @Override
        public ProvinceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(TableActivity.this).inflate(R.layout.province, parent, false);
            return new ProvinceHolder(view);
        }

        @Override
        public void onBindViewHolder(ProvinceHolder holder, int position) {
            holder.bindProvince(provinces.get(position));
        }

        @Override
        public int getItemCount() {
            return provinces.size();
        }
    }

    private List<Province> getProvinces() {
        ArrayList<Province> data = new ArrayList<>();

        JSONArray jsonData = getJSONData();
        for(int i = 0; i < jsonData.length(); i++) {
            try {
                JSONObject item = jsonData.getJSONObject(i);
                data.add(new Province(item.getString("name"), item.getDouble("population"), item.getDouble("latitude"), item.getDouble("longitude"), item.getInt("Mar20"), item.getInt("Apr20"), item.getInt("May20"), item.getInt("Jun20"), item.getInt("Jul20"), item.getInt("Aug20"), item.getInt("Sep20"), item.getInt("Oct20"), item.getInt("Nov20"), item.getInt("Dec20"), item.getInt("Jan21"), item.getInt("Feb21"), item.getInt("Mar21"), item.getInt("Apr21"), item.getInt("May21"), item.getInt("Jun21"), item.getInt("Jul21"), item.getInt("Aug21"), item.getInt("Sep21"), item.getInt("Oct21"), item.getInt("Nov21"), item.getInt("Dec21"), item.getInt("Jan22"), item.getInt("Feb22"), item.getInt("Mar22"), item.getInt("Apr22"), item.getInt("May22"), item.getInt("Jun22"), item.getInt("Jul22"), item.getInt("Aug22"), item.getInt("Sep22"), item.getInt("Oct22")));
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