package com.example.projekt_zaliczenie;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Random;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    // attribute names for Map
    final String ATTR_NAME_TEXT = "TextView";
    final String ATTR_NAME_IMAGE = "ImageView";
    final String ATTR_NAME_CENA = "TextView";
    final String ATTR_NAME_RODZAJ = "LinearLayout";
    final String ATTR_NAME_CENA2 = "TextView";
    private static final int ADD_ID = 1;

    ListView lvList;
    SimpleAdapter sAdapter;
    ArrayList<Map<String, Object>> data;
    Map<String, Object> map;

    ArrayList<Map<String, Object>> data_koszyk;

    // data array
    String[] rodzaj = {"Zimowe","Zimowe","Zimowe","Zimowe","Zimowe","Letnie","Letnie","Letnie","Letnie","Letnie"};
    String[] items = {"Bridgestone", "Dębica", "Goodyear", "Michelin", "Nokian", "Continental", "Dunlop", "Falken", "Firemax", "Uniroyal"};
    String[] cena = {"220 zł", "210 zł", "230 zł", "250 zł", "300 zł", "310 zł", "200 zł", "190 zł", "185 zł", "200 zł"};
    int[]    cena2 = {220,210,230,250,300,310,200,190,185,200};
    Object[] images = {R.drawable.bridgestone, R.drawable.debica, R.drawable.goodyear, R.drawable.michelin, R.drawable.nokian, R.drawable.continental, R.drawable.dunlop, R.drawable.falken, R.drawable.firemax, R.drawable.uniroyal };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        data_koszyk = (ArrayList)getIntent().getSerializableExtra("KOSZYK");
        if (data_koszyk == null) {
            data_koszyk = new ArrayList<Map<String, Object>>();
        }


        data = new ArrayList<Map<String, Object>>();
        // pack the data into adapter structure
        for (int i = 1; i <= items.length; i++) {
            map = new HashMap<String, Object>();
            map.put(ATTR_NAME_CENA, cena[i-1]);
            map.put(ATTR_NAME_TEXT, "Marka: " + items[i - 1] + ". Cena: " + cena[i-1]);
            map.put(ATTR_NAME_IMAGE, images[i - 1]);
            map.put(ATTR_NAME_RODZAJ,rodzaj[i-1]);
            //map.put(ATTR_NAME_CENA2,cena2[i-1]);
            data.add(map);
        }

        // array of attribute names from which data will be read
        String[] from = { ATTR_NAME_IMAGE, ATTR_NAME_TEXT, ATTR_NAME_CENA };
        // array of IDs of View-components, in which data will be put in
        int[] to = { R.id.ivImage, R.id.tvText };

        // сreate adapter
        sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        // create list and assign it to adapter
        lvList = (ListView) findViewById(R.id.lvList);
        lvList.setAdapter(sAdapter);
        registerForContextMenu(lvList);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // add menu items
        menu.add(0, 1, 0, "Opony zimowe");
        menu.add(0, 2, 0, "Opony letnie");
        menu.add(0, 3, 3, "Pełna oferta");
        return super.onCreateOptionsMenu(menu);
    }

    // refresh menu
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    // events onClick
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();

        if (item.getTitle().equals("Pełna oferta")) {
            data = new ArrayList<Map<String, Object>>();
            // pack the data into adapter structure
            for (int i = 1; i <= items.length; i++) {
                map = new HashMap<String, Object>();
                map.put(ATTR_NAME_CENA, cena[i-1]);
                map.put(ATTR_NAME_TEXT, "Marka: " + items[i - 1] + ". Cena: " + cena[i-1]);
                map.put(ATTR_NAME_IMAGE, images[i - 1]);
                map.put(ATTR_NAME_RODZAJ,rodzaj[i-1]);
             //   map.put(ATTR_NAME_CENA2,cena2[i-1]);
                data.add(map);
            }

            // array of attribute names from which data will be read
            String[] from = { ATTR_NAME_IMAGE, ATTR_NAME_TEXT, ATTR_NAME_CENA };
            // array of IDs of View-components, in which data will be put in
            int[] to = { R.id.ivImage, R.id.tvText };

            // сreate adapter
            sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

            // create list and assign it to adapter
            lvList = (ListView) findViewById(R.id.lvList);
            lvList.setAdapter(sAdapter);
        } else if (item.getTitle().equals("Opony zimowe")) {
            data = new ArrayList<Map<String, Object>>();
            // pack the data into adapter structure
            for (int i = 1; i <= items.length; i++) {
                if (rodzaj[i-1]=="Zimowe") {
                    map = new HashMap<String, Object>();
                    map.put(ATTR_NAME_CENA, cena[i - 1]);
                    map.put(ATTR_NAME_TEXT, "Marka: " + items[i - 1] + ". Cena: " + cena[i - 1]);
                    map.put(ATTR_NAME_IMAGE, images[i - 1]);
                    map.put(ATTR_NAME_RODZAJ,rodzaj[i-1]);
                //    map.put(ATTR_NAME_CENA2,cena2[i-1]);
                    data.add(map);
                }
            }

            // array of attribute names from which data will be read
            String[] from = { ATTR_NAME_IMAGE, ATTR_NAME_TEXT, ATTR_NAME_CENA };
            // array of IDs of View-components, in which data will be put in
            int[] to = { R.id.ivImage, R.id.tvText };

            // сreate adapter
            sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

            // create list and assign it to adapter
            lvList = (ListView) findViewById(R.id.lvList);
            lvList.setAdapter(sAdapter);
        } else if (item.getTitle().equals("Opony letnie")) {
            data = new ArrayList<Map<String, Object>>();
            // pack the data into adapter structure
            for (int i = 1; i <= items.length; i++) {
                if (rodzaj[i-1]=="Letnie") {
                    map = new HashMap<String, Object>();
                    map.put(ATTR_NAME_CENA, cena[i - 1]);
                    map.put(ATTR_NAME_TEXT, "Marka: " + items[i - 1] + ". Cena: " + cena[i - 1]);
                    map.put(ATTR_NAME_IMAGE, images[i - 1]);
                    map.put(ATTR_NAME_RODZAJ,rodzaj[i-1]);
                 //   map.put(ATTR_NAME_CENA2,cena2[i-1]);
                    data.add(map);
                }
            }

            // array of attribute names from which data will be read
            String[] from = { ATTR_NAME_IMAGE, ATTR_NAME_TEXT, ATTR_NAME_CENA };
            // array of IDs of View-components, in which data will be put in
            int[] to = { R.id.ivImage, R.id.tvText };

            // сreate adapter
            sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

            // create list and assign it to adapter
            lvList = (ListView) findViewById(R.id.lvList);
            lvList.setAdapter(sAdapter);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBtnClick(View v) {
        //odesłanie do koszyka
        Intent intent = new Intent(getBaseContext(), MainActivity5.class);
        intent.putExtra("KOSZYK", data_koszyk);
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, ADD_ID, 0, "Dodaj do koszyka");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == ADD_ID) {
            // get info about list item
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

            Toast.makeText(this, "Dodano", Toast.LENGTH_SHORT).show();

            data_koszyk.add(data.get(acmi.position));

            //  notify that data has been changed
            sAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    public void onBtnClickbacktomenu(View view) {
        //odesłanie do menu
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("KOSZYK", data_koszyk);
        startActivity(intent);
    }
}