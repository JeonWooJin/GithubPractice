package com.example.jeonwoojin.captsone;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class detailResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailresult);

        class SearchResultContentAdapter extends BaseAdapter {
            ArrayList<SearchResultContent> items = new ArrayList<SearchResultContent>();

            public int getCount() {
                return items.size();
            }

            public void addItem(SearchResultContent item) {
                items.add(item);
            }

            public Object getItem(int position) {
                return items.get(position);
            }

            public long getItemId(int position) {
                return position;
            }

            public View getView(int position, View converView, ViewGroup viewGroup) {
                SearchResultContentView view = new SearchResultContentView(getApplicationContext());
                SearchResultContent item = items.get(position);
                view.setCompany(item.getCompany());
                view.setCampus(item.getCampus());
                view.setStatus(item.getStatus());
                view.setContenttitle(item.getContenttitle());
                view.setTime(item.getTime());

                return view;
            }
        }

        final ListView listView;
        final SearchResultContentAdapter listviewadapter;

        listView = (ListView) findViewById(R.id.detailresult);
        listviewadapter = new SearchResultContentAdapter();
        Intent previnput = getIntent();
        String[] result = new String[5];



        listviewadapter.addItem(new SearchResultContent(previnput.getStringExtra("company"),previnput.getStringExtra("time")
                ,previnput.getStringExtra("content"),previnput.getStringExtra("campus"),previnput.getStringExtra("status")));
        listView.setAdapter(listviewadapter);



        Button AddCalender = (Button) findViewById(R.id.AddCalender);
        AddCalender.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_EDIT);
                i.setType("vnd.android.cursor.item/event");
                startActivity(i);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);


        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.actionbar, null);

        actionBar.setCustomView(actionbar);
        Button BackButton = (Button) findViewById(R.id.btnBack);
        BackButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button HomeButton = (Button) findViewById(R.id.btnhome);
        HomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(i);
            }
        });
        return true;
    }


}
