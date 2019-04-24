package com.midterm.lasalle.drawerlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import model.Country;
import model.CountryFragment;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listViewCountry;
    ArrayList<Country> listOfCountries;
    ArrayAdapter<Country> countryAdapter;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        listViewCountry = findViewById(R.id.listViewCountry);
        listViewCountry.setOnItemClickListener(this);
        listOfCountries = new ArrayList<>();
        listOfCountries.add(new Country("France", "Paris"));
        listOfCountries.add(new Country("India", "New Delhi"));
        listOfCountries.add(new Country("Bresil", "Brasilia"));
        countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfCountries);
        listViewCountry.setAdapter(countryAdapter);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // replace linear layout with the fragment
        CountryFragment countryFragment = new CountryFragment();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_ui, countryFragment);
        fragmentTransaction.commit();
        drawerLayout.closeDrawer(listViewCountry);
    }
}
