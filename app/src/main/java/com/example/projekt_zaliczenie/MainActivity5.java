package com.example.projekt_zaliczenie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity5 extends AppCompatActivity {

    // attribute names for Map
    final String ATTR_NAME_TEXT = "TextView";
    final String ATTR_NAME_IMAGE = "ImageView";
    final String ATTR_NAME_RODZAJ = "LinearLayout";
    final String ATTR_NAME_CENA2 = "TextView";

    float w_koszyka = 0;

    private static final int DELETE_ID = 1;

    ListView lvList;
    SimpleAdapter sAdapter;
    ArrayList<Map<String, Object>> data;
    Map<String, Object> map;
    TextView textView2;
    // data array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);



        // pack the data into adapter structure
        data = (ArrayList) getIntent().getSerializableExtra("KOSZYK");

        // array of attribute names from which data will be read
        String[] from = { ATTR_NAME_IMAGE, ATTR_NAME_TEXT, ATTR_NAME_RODZAJ, ATTR_NAME_CENA2};
        // array of IDs of View-components, in which data will be put in
        int[] to = { R.id.ivImage, R.id.tvText,R.id.linearLayout2 };


        // сreate adapter
        sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        sAdapter.setViewBinder(new MyViewBinder());

        // create list and assign it to adapter
        lvList = (ListView) findViewById(R.id.lvList);
        lvList.setAdapter(sAdapter);
        registerForContextMenu(lvList);
        wartoscKoszyka();
    }

    public void wartoscKoszyka() {
         textView2 = findViewById(R.id.textView2);
        String tempString = "";
        int tempInt = 0;
        int total = 0;
        String numberOnly = "";
        for (int i = 0; i < data.size(); i++) {
            tempString = data.get(i).get(ATTR_NAME_TEXT).toString();
            numberOnly = tempString.replaceAll("[^0-9]", "");
            tempInt = Integer.parseInt(numberOnly);
            total = total + tempInt;
        }
        textView2.setText("Wartość koszyka: " + total + " zł.");
    }
    class MyViewBinder implements SimpleAdapter.ViewBinder {

        int blue = getResources().getColor(R.color.Blue);
        int green = getResources().getColor(R.color.Green);

        @Override
        public boolean setViewValue(View view, Object data,
                                    String textRepresentation) {
            String rodzaj = "Zimowe";
            switch (view.getId()) {
                // LinearLayout
                case R.id.linearLayout2:
                    rodzaj = ((String) data).toString();
                    if (rodzaj.equals("Zimowe")) view.setBackgroundColor(blue);
                    else if (rodzaj.equals("Letnie")) view.setBackgroundColor(green);
                    return true;
            }
            return false;
        }
    }




    public void onBtnClick(View v) {
        Intent intent = new Intent(getBaseContext(), MainActivity2.class);
        intent.putExtra("KOSZYK", data);
        startActivity(intent);


        /*Random rand = new Random();
        int rand_int = rand.nextInt(items.length);

        // create new Map
        map = new HashMap<String, Object>();
        map.put(ATTR_NAME_TEXT, items[rand_int] + " " + (data.size() + 1));
        map.put(ATTR_NAME_IMAGE, R.mipmap.ic_launcher);
        // add it to collection
        data.add(map);
        // notify that data has been changed
        sAdapter.notifyDataSetChanged();*/
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, DELETE_ID, 0, "Delete item");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == DELETE_ID) {
            // get info about list item
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            // delete Map from collection, using the position number in the list
            data.remove(acmi.position);
            //  notify that data has been changed
            sAdapter.notifyDataSetChanged();
            wartoscKoszyka();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}