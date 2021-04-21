package com.zhenekns.android.encyclopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.zhenekns.android.encyclopedia.adapter.DataAdapter;
import com.zhenekns.android.encyclopedia.adapter.ListItem;
import com.zhenekns.android.encyclopedia.adapter.RecycleViewOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavItemSelectedListener {

    private RecycleViewOnClickListener recycleViewOnClickListener;
    private DataAdapter adapter;
    private List<ListItem> listData;
    private RecyclerView rcView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMenu();
        setRecOnClickListener();
        init();
    }

    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        MenuListFragment mMenuFragment = (MenuListFragment) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new MenuListFragment();
            mMenuFragment.setNavItemSelectedListener(this);
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }
    }

    @Override
    public void onNavItemSelectedListener(MenuItem item) {
        //Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case R.id.id_favorite:

                break;
            case R.id.id_planets:
                updateMainList(getResources().getStringArray(R.array.planets));
                break;
            case R.id.id_stars:
                updateMainList(getResources().getStringArray(R.array.stars));
                break;
            case R.id.id_travel:
                updateMainList(getResources().getStringArray(R.array.travels));
                break;
            case R.id.id_universe:
                updateMainList(getResources().getStringArray(R.array.universe));
                break;
            case R.id.id_clever_words:
                updateMainList(getResources().getStringArray(R.array.clever_words));
                break;
            case R.id.id_philosophers_words:
                updateMainList(getResources().getStringArray(R.array.philosophers_words));
                break;
            case R.id.id_humour_words:
                updateMainList(getResources().getStringArray(R.array.humour_words));
                break;
            case R.id.id_awesome_plants:
                updateMainList(getResources().getStringArray(R.array.awesome_plants));
                break;
            case R.id.id_danger_plants:
                updateMainList(getResources().getStringArray(R.array.danger_plants));
                break;
            case R.id.id_cure_plants:
                updateMainList(getResources().getStringArray(R.array.cure_plants));
                break;
            case R.id.id_ufo:
                updateMainList(getResources().getStringArray(R.array.ufo));
                break;
            case R.id.id_spirits:
                updateMainList(getResources().getStringArray(R.array.spirits));
                break;
        }
    }

    private void updateMainList(String[] array){
        List<ListItem> list = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            ListItem listItem = new ListItem();
            listItem.setText(array[i]);
            listItem.setFavorite(false);
            list.add(listItem);
        }
        adapter.updateList(list);
    }

    private void init() {
        rcView = findViewById(R.id.rcView);
        rcView.setLayoutManager(new LinearLayoutManager(this));
        listData = new ArrayList<>();
        String[] planetsArray = getResources().getStringArray(R.array.planets);
        for(int i=0;i<planetsArray.length;i++){
            ListItem listItem = new ListItem();
            listItem.setText(planetsArray[i]);
            listItem.setFavorite(false);
            listData.add(listItem);
        }
        adapter = new DataAdapter(this, recycleViewOnClickListener, listData);
        rcView.setAdapter(adapter);

    }

    private void setRecOnClickListener() {
        recycleViewOnClickListener = new RecycleViewOnClickListener() {
            @Override
            public void onItemClicked(int pos) {
                Toast.makeText(MainActivity.this, "Position = " + pos, Toast.LENGTH_SHORT).show();
            }
        };
    }
}