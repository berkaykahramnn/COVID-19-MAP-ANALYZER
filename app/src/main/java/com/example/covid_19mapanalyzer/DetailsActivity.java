package com.example.covid_19mapanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    private Province province;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("province")) {
            province = (Province) intent.getSerializableExtra("province");
        } else {
            finish();
        }

        setTitle(province.getName());

        ((TextView) findViewById(R.id.mar20_cases_view)).setText(province.getMar20() + "");
        ((TextView) findViewById(R.id.apr20_cases_view)).setText(province.getApr20() + "");
        ((TextView) findViewById(R.id.may20_cases_view)).setText(province.getMay20() + "");
        ((TextView) findViewById(R.id.jun20_cases_view)).setText(province.getJun20() + "");
        ((TextView) findViewById(R.id.jul20_cases_view)).setText(province.getJul20() + "");
        ((TextView) findViewById(R.id.aug20_cases_view)).setText(province.getAug20() + "");
        ((TextView) findViewById(R.id.sep20_cases_view)).setText(province.getSep20() + "");
        ((TextView) findViewById(R.id.oct20_cases_view)).setText(province.getOct20() + "");
        ((TextView) findViewById(R.id.nov20_cases_view)).setText(province.getNov20() + "");
        ((TextView) findViewById(R.id.dec20_cases_view)).setText(province.getDec20() + "");
        ((TextView) findViewById(R.id.jan21_cases_view)).setText(province.getJan21() + "");
        ((TextView) findViewById(R.id.feb21_cases_view)).setText(province.getFeb21() + "");
        ((TextView) findViewById(R.id.mar21_cases_view)).setText(province.getMar21() + "");
        ((TextView) findViewById(R.id.apr21_cases_view)).setText(province.getApr21() + "");
        ((TextView) findViewById(R.id.may21_cases_view)).setText(province.getMay21() + "");
        ((TextView) findViewById(R.id.jun21_cases_view)).setText(province.getJun21() + "");
        ((TextView) findViewById(R.id.jul21_cases_view)).setText(province.getJul21() + "");
        ((TextView) findViewById(R.id.aug21_cases_view)).setText(province.getAug21() + "");
        ((TextView) findViewById(R.id.sep21_cases_view)).setText(province.getSep21() + "");
        ((TextView) findViewById(R.id.oct21_cases_view)).setText(province.getOct21() + "");
        ((TextView) findViewById(R.id.nov21_cases_view)).setText(province.getNov21() + "");
        ((TextView) findViewById(R.id.dec21_cases_view)).setText(province.getDec21() + "");
        ((TextView) findViewById(R.id.jan22_cases_view)).setText(province.getJan22() + "");
        ((TextView) findViewById(R.id.feb22_cases_view)).setText(province.getFeb22() + "");
        ((TextView) findViewById(R.id.mar22_cases_view)).setText(province.getMar22() + "");
        ((TextView) findViewById(R.id.apr22_cases_view)).setText(province.getApr22() + "");
        ((TextView) findViewById(R.id.may22_cases_view)).setText(province.getMay22() + "");
        ((TextView) findViewById(R.id.jun22_cases_view)).setText(province.getJun22() + "");
        ((TextView) findViewById(R.id.jul22_cases_view)).setText(province.getJul22() + "");
        ((TextView) findViewById(R.id.aug22_cases_view)).setText(province.getAug22() + "");
        ((TextView) findViewById(R.id.sep22_cases_view)).setText(province.getSep22() + "");
        ((TextView) findViewById(R.id.oct22_cases_view)).setText(province.getOct22() + "");

    }
}